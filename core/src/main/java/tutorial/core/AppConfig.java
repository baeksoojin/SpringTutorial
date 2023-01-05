package tutorial.core;

import tutorial.core.discount.DiscountPolicy;
import tutorial.core.discount.FixDiscountPolicy;
import tutorial.core.member.MemberRepository;
import tutorial.core.member.MemberService;
import tutorial.core.member.MemberServiceImpl;
import tutorial.core.member.MemoryMemberRepository;
import tutorial.core.order.OrderService;
import tutorial.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }//생성자 주입

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }//생성자주입

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
