package tutorial.advanced.app.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import tutorial.advanced.app.trace.strategy.code.ContextV1;
import tutorial.advanced.app.trace.strategy.code.Strategy;
import tutorial.advanced.app.trace.strategy.code.StrategyLogic1;
import tutorial.advanced.app.trace.strategy.code.StrategyLogic2;
import tutorial.advanced.app.trace.template.code.AbstractTemplate;
import tutorial.advanced.app.trace.template.code.SubClassLogic1;
import tutorial.advanced.app.trace.template.code.SubClassLogic2;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis(); //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis(); long resultTime = endTime - startTime; log.info("resultTime={}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis(); //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    //위의 코드 분석 -> 비즈니스 로직을 제외하고는 코드가 완전히 동일하다. 변하는 부분과 변하지 않는 부분을 분리해서 모듈화한다.

    @Test
    void strategyV1() {
        Strategy strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();
        Strategy strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV2() {


        ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
        context2.execute();
    }//변수로 담아둘 필요가 없음.


}
