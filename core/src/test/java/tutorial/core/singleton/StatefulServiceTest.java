package tutorial.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //threada : a사용자가 만원주문
        statefulService1.order("usera",10000);
        //threadb : b사용자가 2만원주문
        statefulService2.order("userb",20000);

        //threada : usera의 주문 금액 조호ㅚ
        int price = statefulService1.getPrice();
        System.out.println("price = "+price);

        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    @Test
    void statelessServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig2.class);

        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        //threada : a사용자가 만원주문
        int userAPrice = statelessService1.order("usera",10000);
        //threadb : b사용자가 2만원주문
        int userBPrice = statelessService2.order("userb",20000);

        //threada : usera의 주문 금액 조호ㅚ
        int price = statelessService1.getPrice();
        System.out.println("price = "+price);

        org.assertj.core.api.Assertions.assertThat(userAPrice).isEqualTo(10000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

    static class TestConfig2{
        @Bean
        public StatelessService statelessService(){
            return new StatelessService();
        }
    }
}