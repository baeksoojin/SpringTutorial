package tutorial.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();//싱글톤으로 설정해서 new하면 에러나는게 잘 동작함

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }//test 순서는 보장되지 않기 때문에 테스트끝나고 clear는 필수로 생각하자.

    @DisplayName("저장 테스트")
    @Test
    void save(){
        //given
        Member member= new Member("hello",20);

        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @DisplayName("모든 user조회 테스트")
    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 23);

        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        //when

        List<Member> result = memberRepository.findAll();

        //then

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);

    }


}
