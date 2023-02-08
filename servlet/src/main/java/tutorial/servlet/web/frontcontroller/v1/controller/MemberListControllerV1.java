package tutorial.servlet.web.frontcontroller.v1.controller;

import tutorial.servlet.domain.member.Member;
import tutorial.servlet.domain.member.MemberRepository;
import tutorial.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {


    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //controller
        System.out.println("MvcMemberListServlet.service");
        List<Member> members = memberRepository.findAll();

        //model에 저장

        request.setAttribute("members", members);

        // view로 전달
        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
