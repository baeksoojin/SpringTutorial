package tutorial.core.scan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.core.member.MemberService;
import tutorial.core.AutoAppConfig;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }//직접 등록하는 방식에서 component scan 방식을 통한 자동등록을 확인. ->ClassPathBeanDefinitionScanner에 의해서 스캔되고 singleton bean으로 생성됨
}
