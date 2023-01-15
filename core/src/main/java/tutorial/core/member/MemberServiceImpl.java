package tutorial.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; // 추상화에만 의존 DIP원칙

    @Autowired // memberRepository를 MemberServiceImpl에 의존성을 주이
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //test용도 -> singleton test
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
