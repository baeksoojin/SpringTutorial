package tutorial.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.core.AppConfig;
import tutorial.core.member.MemberRepository;
import tutorial.core.member.MemberService;
import tutorial.core.member.MemberServiceImpl;
import tutorial.core.member.MemoryMemberRepository;
import tutorial.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService",OrderServiceImpl.class);
        MemoryMemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);
        //service 구체타입으로 꺼내면 좋지않지만..singleton test를 위해서 inpl에 만들어놓은 것을 사용하기 위해서 다음곽 같이 적음

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository"+ memberRepository1);
        System.out.println("orderService -> memberRepository"+ memberRepository2);
        System.out.println("memberRepository"+ memberRepository);

        Assertions.assertThat(memberRepository1).isSameAs(memberRepository);
        Assertions.assertThat(memberRepository2).isSameAs(memberRepository);

    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = "+bean.getClass());
        //bean = class tutorial.core.AppConfig$$EnhancerBySpringCGLIB$$69863c26
    }

}

