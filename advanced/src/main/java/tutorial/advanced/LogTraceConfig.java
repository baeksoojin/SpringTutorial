package tutorial.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tutorial.advanced.app.trace.logtrace.FieldLogTrace;
import tutorial.advanced.app.trace.logtrace.LogTrace;
import tutorial.advanced.app.trace.logtrace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
