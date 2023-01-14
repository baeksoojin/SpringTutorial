package tutorial.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.core.AppConfig;
import tutorial.core.member.Member;
import tutorial.core.member.MemberService;

public class SingletonTest {

    @Test
    @DisplayName("spring container를 활용하지 않은 순수한 DI container")
    void pureContainer(){
        AppConfig appconfig = new AppConfig();

        //1. 조회 : 호출시마다 객체 생성하는지 조회
        MemberService memberService1 = appconfig.memberService();

        //2.  조회 : 호출시마다 객체 생성하는지 조회
        MemberService memberService2 = appconfig.memberService();


        //참조값이 다른지 확인 -> 새로운 객체가 계속 생성됨을 알 수 있음.
        System.out.println("memberService1"+memberService1);
        System.out.println("memberService2"+memberService2);

        //자동화 -> 서로 다른지 확인
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("singleton pattern을 사용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);//같아야함
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회 : 호출시마다 객체 생성하는지 조회
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2.  조회 : 호출시마다 객체 생성하는지 조회
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


        //참조값이 다른지 확인 -> 새로운 객체가 계속 생성됨을 알 수 있음.
        System.out.println("memberService1"+memberService1);
        System.out.println("memberService2"+memberService2);

        //자동화 -> 서로 다른지 확인
        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }
}
