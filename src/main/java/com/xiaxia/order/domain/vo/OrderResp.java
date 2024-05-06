package com.xiaxia.order.domain.vo;

import com.xiaxia.order.domain.Order;

import java.util.List;

/**

 * @date 2024/4/20 22:39
 */
public class OrderResp {
    private Integer code;
    private String msg;

    private List<Order> list;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }
}
