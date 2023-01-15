package tutorial.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import tutorial.core.member.MemberRepository;
import tutorial.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        basePackages = "tutorial.core", // 해당 package부터 하위패키지로 component를 찾아감.
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes=Configuration.class)
)
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
