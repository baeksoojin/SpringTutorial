package tutorial.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tutorial.advanced.app.trace.TraceId;
import tutorial.advanced.app.trace.TraceStatus;
import tutorial.advanced.app.trace.hellotrace.HelloTraceV2;
import tutorial.advanced.app.trace.logtrace.LogTrace;


@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace trace;

    public void orderItem(String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepositoryV3.save(itemId);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status,e);
            throw e;
        }

        orderRepositoryV3.save(itemId);
    }
}
