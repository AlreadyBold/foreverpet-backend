package com.hello.foreverpet.domain.entity;

import com.hello.foreverpet.domain.dto.Address;
import com.hello.foreverpet.domain.dto.Categories;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "order_info")
@Getter
public class OrderInfo {
    // @NotNull 의 장점 = 데이터베이스에 SQL 쿼리를 보내기 전에 예외가 발생한다 즉 DB에 값이 넘어가기 전에 예외가 발생한다는 것
    // !
    // Nullable 은 DB에 값이 넘어갈 수도 있다고 합니다.
    // 자세한 사항은 https://kafcamus.tistory.com/15 확인하시면 됩니다.


    /*
     * 주문번호 관련 사항
     * -1 ) DB에서 검증해서 보내준다 --> 트랜잭션 필요 ( 동시 요청 시 )
     * -2 ) 프론트에서 uuid 발생 --> 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "order_no")
    private Long orderNo; // 주문번호

    @NotNull
    @Column(name = "order_payment_no")
    private Long orderPaymentNo; // 결제번호

    @NotNull
    @Column(name = "address")
    private Address address;

    @NotNull
    @Column(name ="payment_cd")
    private String paymentCd; // 결제방법

    @NotNull
    @Column(name ="user_no")
    private Long userNo; // 주문한 유저번호 ( FK 설정해야함 )
    // 비회원주문도 가능 -> 비회원주문할때 유저번호 하나 생성하면 될듯
    // userType같은 컬럼을 만들어서 소셜회원 ( N , K , G ), 회원, 비회원으로 나누는 방안

    @Column(name ="contents")
    private String contents; // 요청사항

    @Column(name ="memo")
    private String memo; // 메모

    @NotNull
    @Column(name ="order_process")
    private Long orderProcess; // 상품 배송 상황

    @NotNull
    @Column(name ="purchase_no")
    private Long purchaseNo; // 상품번호 ( FK 설정해야함 )

    @Builder
    public OrderInfo(Long orderNo, Long orderPaymentNo, Address address, String paymentCd,
        Long userNo, String contents, String memo, Long purchaseNo) {

            this.orderNo = orderNo;
            this.orderPaymentNo = orderPaymentNo;
            this.address = address;
            this.paymentCd = paymentCd;
            this.userNo = userNo;
            this.contents = contents;
            this.memo = memo;
            this.orderProcess = 1L;
            this.purchaseNo = purchaseNo;

    }

}