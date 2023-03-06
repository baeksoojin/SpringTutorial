package tutorial.advanced.app.trace.logtrace;

import tutorial.advanced.app.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
