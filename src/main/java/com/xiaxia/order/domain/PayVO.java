package com.xiaxia.order.domain;

/**
 * @author xiaxia
 * @date 2024/5/5 23:55
 */
public class PayVO {
    private String sportName;
    private String vuenue;
    private String time;
    private String price;

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getVuenue() {
        return vuenue;
    }

    public void setVuenue(String vuenue) {
        this.vuenue = vuenue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
