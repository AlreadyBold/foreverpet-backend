package com.hello.foreverpet.domain.dto.request;

import com.hello.foreverpet.domain.dto.Address;
import com.hello.foreverpet.domain.entity.OrderInfo;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;


public class OrderInfoRequest {
    @NotNull
    private Long orderNo; // 주문번호

    @NotNull
    private Long orderPaymentNo; // 결제번호

    @NotNull
    private Address address;    // 주소

    @NotNull
    private String paymentCd; // 결제방법

    @NotNull
    private Long userNo; // 주문한 유저번호

    private String contents; // 요청사항

    private String memo; // 메모

    private Long orderProcess; // 상품 배송 상황 ( 기본값 1 => 주문완료 )

    @NotNull
    private Long purchaseNo; // 상품번호 ( FK 설정해야함 )

    public OrderInfo toEntity() {
        return OrderInfo.builder().orderNo(this.orderNo)
                .orderPaymentNo(this.orderPaymentNo)
                .address(this.address)
                .paymentCd(this.paymentCd)
                .userNo(this.userNo)
                .contents(this.contents)
                .memo(this.memo)
                .build();
    }


    public OrderInfoRequest( Long orderNo, Long orderPaymentNo, Address address,
        String paymentCd, Long UserNo, String contents, String memo){
            this.orderNo = orderNo;
            this.orderPaymentNo = orderPaymentNo;
            this.address = address;
            this.paymentCd = paymentCd;
            this.userNo = userNo;
            this.contents = contents;
            this.memo = memo;
    }
}
