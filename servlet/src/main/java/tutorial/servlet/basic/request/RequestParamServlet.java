package tutorial.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 1. 파라미터 전송
* http://localhost:8080/request-param?username=hello&age=20
* */

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName+"="+
                req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");

        System.out.println("[단일 파라미터 조회] - start");

        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("username" + "=" + username +
                            "age" + "=" + age);

        System.out.println("[단일 파라미터 조회] - end");

        // key값이 동일하게 여러 값이 넘어온 복수 파라미터를 조회하고 싶을 때

        System.out.println("복수 파라미터 조회");
        String[] usernames = req.getParameterValues("username");
        for(String name : usernames){
            System.out.println("username = "+name);
        }




    }
}
