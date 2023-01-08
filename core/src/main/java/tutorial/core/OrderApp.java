package tutorial.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.core.member.Grade;
import tutorial.core.member.Member;
import tutorial.core.member.MemberService;
import tutorial.core.member.MemberServiceImpl;
import tutorial.core.order.Order;
import tutorial.core.order.OrderService;
import tutorial.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1l;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itema",10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
