package com.xiaxia.order.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName order
 */
public class Order implements Serializable {

    private Integer userId;
    /**
     *
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 金额
     */
    private String money;

    /**
     * 体育活动名称
     */
    private String sportName;

    private String court;

    /**
     * 订单状态
     */
    private String orderStatus;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     */
    public Long getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 下单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 下单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 金额
     */
    public String getMoney() {
        return money;
    }

    /**
     * 金额
     */
    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * 体育活动名称
     */
    public String getSportName() {
        return sportName;
    }

    /**
     * 体育活动名称
     */
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    /**
     * 订单状态
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getSportName() == null ? other.getSportName() == null : this.getSportName().equals(other.getSportName()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getSportName() == null) ? 0 : getSportName().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", money=").append(money);
        sb.append(", sportName=").append(sportName);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
