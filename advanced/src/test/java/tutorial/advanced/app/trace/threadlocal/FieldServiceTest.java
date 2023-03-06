package tutorial.advanced.app.trace.threadlocal;

import com.sun.jdi.Field;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import tutorial.advanced.app.trace.threadlocal.code.FieldService;

@Slf4j
public class FieldServiceTest {
    private FieldService fieldService = new FieldService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA = ()->{
            fieldService.logic("userA");
        };
        Runnable userB = ()->{
            fieldService.logic("userB");
        };
        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");


        threadA.start();
       // sleep(2000);//동시성 문제가 아예 발생하지 않음. 실행이 끝나는 시간보다 더 늦게 다음 쓰레드가 시작.
        sleep(100);//동시성 문제가 발생 왜? 싱글톤이 기본
        threadB.start();

        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
