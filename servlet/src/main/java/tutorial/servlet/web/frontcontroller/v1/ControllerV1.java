package tutorial.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOError;
import java.io.IOException;

public interface ControllerV1 {
    void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    //서블릿과 비슷한 모양의 인터페이스를 도입하고 이를 활용해서 각 컨트롤러는 구현을 하면 된다.

}
