package tutorial.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; // 추상화에만 의존 DIP원칙

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
