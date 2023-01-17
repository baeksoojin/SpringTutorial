package tutorial.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tutorial.core.discount.FixDiscountPolicy;
import tutorial.core.member.Grade;
import tutorial.core.member.Member;
import tutorial.core.member.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void CreateOrder(){//생성자 주입의 장점 -> 컴파일 오류를 내줘서 의존관계 주입을 빼먹지 않도록함.
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1l, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L,"itema",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}