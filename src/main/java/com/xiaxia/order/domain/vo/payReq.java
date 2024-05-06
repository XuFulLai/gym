package com.xiaxia.order.domain.vo;

import com.xiaxia.order.domain.PayVO;

import java.util.List;

/**
 * @author xiaxia
 * @date 2024/5/5 23:26
 */
public class payReq {
    private List<PayVO> payList;

    public List<PayVO> getpayList() {
        return payList;
    }

    public void setpayList(List<PayVO> payList) {
        this.payList = payList;
    }
}
