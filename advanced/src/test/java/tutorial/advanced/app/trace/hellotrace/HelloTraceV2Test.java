package tutorial.advanced.app.trace.hellotrace;

import org.junit.jupiter.api.Test;
import tutorial.advanced.app.trace.TraceStatus;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV2Test {

    @Test
    void begin_end() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(),"hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception() {
        var trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status.getTraceId(), "hello2");
        trace.exception(status2,new IllegalStateException());
        trace.exception(status, new IllegalStateException());

    }
}