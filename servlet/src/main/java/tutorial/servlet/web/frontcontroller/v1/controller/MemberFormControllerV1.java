package tutorial.servlet.web.frontcontroller.v1.controller;


import tutorial.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);//controller에서 view이동시에 사용
        dispatcher.forward(request,response);//servlet에서 jsp를 호출하는 것이 됨 server안에서 내부적인 작업으로 redirect의 개념이 아님.

    }
}
