package tutorial.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 다형성에 의해서 MemberRepository가 아니라 MemoryMemberRepository가 호출되고 join, findmember에서 사용됨
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
