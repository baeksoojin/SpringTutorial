package tutorial.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import tutorial.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    public void logic(String testId) {

        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("Service id = "+ testId);
    }
}
