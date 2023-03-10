package tutorial.core.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorial.core.AppConfig;
import tutorial.core.member.Grade;
import tutorial.core.member.Member;
import tutorial.core.member.MemberService;
import tutorial.core.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){

        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "membera", Grade.VIP );

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itema", 10000);

        //then
        Assertions.assertEquals(order.getDiscountPrice(),1000);

    }
}

