package tutorial.advanced.app.trace.logtrace;

import lombok.extern.slf4j.Slf4j;
import tutorial.advanced.app.trace.TraceId;
import tutorial.advanced.app.trace.TraceStatus;

@Slf4j
public class FieldLogTrace implements LogTrace {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";


    //parameter를 사용하지 않고 field를 사용하도록함.
    private TraceId traceIdHolder;//동시성 이슈 발생

    //syncTraceId() **중요**
    private void syncTraceId(){//level+1 using same id
        if(traceIdHolder==null) {//최초호출 -> 직전로그가 없을 때
            traceIdHolder = new TraceId();
        }else{
            traceIdHolder = traceIdHolder.createNextId();
        }
    }

    private void releaseTraceId(){//level -1 using same id
        if(traceIdHolder.isFirstLevel()) {
            traceIdHolder = null;//http transaction이 끝났을 때 null로 만들어서 구분해야함
        }else{
            traceIdHolder = traceIdHolder.createPreviousId();
        }
    }

    @Override
    public TraceStatus begin(String message) {
        TraceId traceId = new TraceId();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX,
                traceId.getLevel()), message);
        return new TraceStatus(traceId, startTimeMs, message);
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();
        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.getId(),
                    addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(),
                    resultTimeMs);
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(),
                    addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs,
                    e.toString());
        } }

    private static String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }
}
