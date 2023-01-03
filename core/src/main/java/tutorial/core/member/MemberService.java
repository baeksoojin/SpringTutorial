package tutorial.core.member;

public interface MemberService {

    void join(Member member);//가입

    Member findMember(Long memberId);//조회

}
