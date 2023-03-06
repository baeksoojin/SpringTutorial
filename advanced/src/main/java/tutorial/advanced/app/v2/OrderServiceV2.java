package tutorial.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tutorial.advanced.app.trace.TraceId;
import tutorial.advanced.app.trace.TraceStatus;
import tutorial.advanced.app.trace.hellotrace.HelloTraceV1;
import tutorial.advanced.app.trace.hellotrace.HelloTraceV2;


@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId,String itemId){

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderService.orderItem()");
            orderRepositoryV2.save(status.getTraceId(),itemId);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status,e);
            throw e;
        }

        orderRepositoryV2.save(traceId,itemId);
    }
}
