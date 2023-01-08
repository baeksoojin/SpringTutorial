package tutorial.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tutorial.core.discount.DiscountPolicy;
import tutorial.core.discount.FixDiscountPolicy;
import tutorial.core.member.MemberRepository;
import tutorial.core.member.MemberService;
import tutorial.core.member.MemberServiceImpl;
import tutorial.core.member.MemoryMemberRepository;
import tutorial.core.order.OrderService;
import tutorial.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }//생성자 주입

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }//생성자주입

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
