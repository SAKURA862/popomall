package com.main.shopping.controller;

import com.main.api.common.CommonResult;
import com.main.api.dto.shopping.OrderParm;
import com.main.api.exception.InsertFailException;
import com.main.api.exception.UpdateFailException;
import com.main.api.utils.TokenUtil;
import com.main.shopping.config.RabbitmqConfig;
import com.main.shopping.service.IOrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author roxy
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ResponseBody
    @PostMapping(value = "/add")
    public CommonResult placeOrder(@RequestHeader("authrize") String token, @RequestBody @Valid OrderParm arg) {
        Long userId = TokenUtil.getUserId(token);
        arg.setOrderBuyerId(userId);

        Long orderId = orderService.addOrder(arg);
        if (orderId == null || orderId <= 0) {
            throw new InsertFailException("下单失败");
        }

        rabbitTemplate.convertAndSend(
                RabbitmqConfig.DELAYED_EXCHANGE_NAME,
                RabbitmqConfig.DELAYED_ROUTING_KEY,
                String.valueOf(orderId),
                msg -> {
                    msg.getMessageProperties().setDelay(RabbitmqConfig.DELAYED_TIME);
                    return msg;
                }
        );
        return CommonResult.success(
                orderId,
                "下单成功，请在" + RabbitmqConfig.DELAYED_TIME / (1000 * 60) + "分钟内付款"
        );
    }

    @ResponseBody
    @PostMapping(value = "/pay/{orderId}")
    public CommonResult pay(@RequestHeader("authrize") String token, @PathVariable("orderId") Long orderId) {
        Long userId = TokenUtil.getUserId(token);

        Integer affectRowsNum = orderService.pay(orderId, userId);
        if (affectRowsNum == null || affectRowsNum <= 0) {
            throw new UpdateFailException("支付失败");
        }
        return CommonResult.success(affectRowsNum, "支付成功");
    }
}
