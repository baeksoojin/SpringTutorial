package tutorial.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tutorial.core.discount.DiscountPolicy;
import tutorial.core.discount.FixDiscountPolicy;
import tutorial.core.discount.RateDiscountPolicy;
import tutorial.core.member.Member;
import tutorial.core.member.MemberRepository;
import tutorial.core.member.MemoryMemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService{

    private final MemberRepository memberRepository; //interface에만 의존하고 구체화에는 의존하지 않도록 DIP 원칙을 가져감
    private final DiscountPolicy discountPolicy; //interface에만 의존하고 구체화에는 의존하지 않도록 DIP 원칙을 가져감

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test용도 -> singleton test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
