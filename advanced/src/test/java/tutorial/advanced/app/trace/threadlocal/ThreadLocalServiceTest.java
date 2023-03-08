package tutorial.advanced.app.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import tutorial.advanced.app.trace.threadlocal.code.FieldService;
import tutorial.advanced.app.trace.threadlocal.code.ThreadLocalService;

@Slf4j
public class ThreadLocalServiceTest {
    private ThreadLocalService threadLocalService = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA = ()->{
            threadLocalService.logic("userA");
        };
        Runnable userB = ()->{
            threadLocalService.logic("userB");
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
