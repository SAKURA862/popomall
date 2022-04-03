package com.main.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CommodityWithBLOBs extends Commodity {
    private byte[] commPic;

    private byte[] commDetailpic1;

    private byte[] commDetailpic2;

    private byte[] commDetailpic3;

    public byte[] getCommPic() {
        return commPic;
    }

    public void setCommPic(byte[] commPic) {
        this.commPic = commPic;
    }

    public byte[] getCommDetailpic1() {
        return commDetailpic1;
    }

    public void setCommDetailpic1(byte[] commDetailpic1) {
        this.commDetailpic1 = commDetailpic1;
    }

    public byte[] getCommDetailpic2() {
        return commDetailpic2;
    }

    public void setCommDetailpic2(byte[] commDetailpic2) {
        this.commDetailpic2 = commDetailpic2;
    }

    public byte[] getCommDetailpic3() {
        return commDetailpic3;
    }

    public void setCommDetailpic3(byte[] commDetailpic3) {
        this.commDetailpic3 = commDetailpic3;
    }
}