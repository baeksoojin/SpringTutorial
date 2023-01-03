package tutorial.core;

import tutorial.core.member.Grade;
import tutorial.core.member.Member;
import tutorial.core.member.MemberService;
import tutorial.core.member.MemberServiceImpl;
import tutorial.core.order.Order;
import tutorial.core.order.OrderService;
import tutorial.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1l;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itema",10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
