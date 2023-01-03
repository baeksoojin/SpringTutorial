package tutorial.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member = new Member(1l,"memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1l);

        //then
        Assertions.assertEquals(member, findMember);

    }
}
