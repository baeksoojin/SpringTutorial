package tutorial.core.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tutorial.core.member.Grade;
import tutorial.core.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "membervip", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertEquals(discount, 1000);
    }

    @Test
    @DisplayName("vip가 아니면 할인이 적용되면 안 된다")
    void vip_x(){
        //given
        Member member = new Member(1L, "membervip", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertEquals(discount, 0);

    }
}