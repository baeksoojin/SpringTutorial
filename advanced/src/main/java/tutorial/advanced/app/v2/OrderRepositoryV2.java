package tutorial.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tutorial.advanced.app.trace.TraceId;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    public void save(TraceId traceId,String itemId){

        //예외처리상황
        if(itemId.equals("exception-test")){
            throw new IllegalStateException("예외 발생");
        }
        //처리시간 설정
        sleep(1000);//1초간 슬립. 상품저장하는데 1초 걸린다고 가정

    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


}
