package com.example.couponapi;

import com.example.couponcore.model.Coupon;
import com.example.couponcore.model.CouponType;
import com.example.couponcore.repository.mysql.CouponJpaRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Arrays;

import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CouponIssuer {

    private final CouponJpaRepository couponJpaRepository;

    @PostConstruct
    @Transactional
    public void init() {
        log.info("===== 쿠폰 생성 시작 =====");

        // 쿠폰 데이터 목록
        List<Coupon> coupons = Arrays.asList(
                createCoupon("discount_5000", 5000, 50000),
                createCoupon("discount_3000", 3000, 30000),
                createCoupon("discount_2000", 2000, 20000),
                createCoupon("discount_1000", 1000, 10000)
        );

        // 각 쿠폰을 DB에 저장
        couponJpaRepository.saveAll(coupons);
        log.info("===== 쿠폰 생성 종료=====");
    }

    // 쿠폰 객체 생성 메소드
    private Coupon createCoupon(String title, int discountAmount, int minAvailableAmount) {
        final Coupon coupon = new Coupon();
        coupon.setTitle(title);
        coupon.setCouponType(CouponType.FIRST_COME_FIRST_SERVED);
        coupon.setTotalQuantity(100000); // 총 쿠폰 수량
        coupon.setIssuedQuantity(0); // 발급된 쿠폰 수량
        coupon.setDiscountAmount(discountAmount); // 할인 금액
        coupon.setMinAvailableAmount(minAvailableAmount); // 최소 사용 가능 금액

        final LocalDateTime now = LocalDateTime.now();
        coupon.setDateIssueStart(now);
        coupon.setDateIssueEnd(now.plusDays(30)); // 발급 후 30일간 사용 가능

        return coupon;
    }
}
