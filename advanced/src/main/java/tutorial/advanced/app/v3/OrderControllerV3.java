package tutorial.advanced.app.v3;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tutorial.advanced.app.trace.TraceId;
import tutorial.advanced.app.trace.TraceStatus;
import tutorial.advanced.app.trace.hellotrace.HelloTraceV2;
import tutorial.advanced.app.trace.logtrace.LogTrace;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(TraceId traceId,String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) { trace.exception(status, e);
            throw e; //예외를 꼭 다시 던져주어야 한다.
        }


    }
}
