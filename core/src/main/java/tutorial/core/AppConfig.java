package tutorial.core;

import tutorial.core.discount.FixDiscountPolicy;
import tutorial.core.member.MemberService;
import tutorial.core.member.MemberServiceImpl;
import tutorial.core.member.MemoryMemberRepository;
import tutorial.core.order.OrderService;
import tutorial.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }//생성자 주입

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }//생성자주입

}
