package tutorial.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tutorial.core.annotation.MainDiscountPolicy;
import tutorial.core.member.Grade;
import tutorial.core.member.Member;

@Component
@MainDiscountPolicy //compile error check 위해서 직접 annotation 생성
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
