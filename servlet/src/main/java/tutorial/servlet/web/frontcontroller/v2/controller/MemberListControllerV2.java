package tutorial.servlet.web.frontcontroller.v2.controller;

import tutorial.servlet.domain.member.Member;
import tutorial.servlet.domain.member.MemberRepository;
import tutorial.servlet.web.frontcontroller.MyView;
import tutorial.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {


    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //controller
        System.out.println("MvcMemberListServlet.service");
        List<Member> members = memberRepository.findAll();

        //model에 저장

        request.setAttribute("members", members);

        // view로 전달
        return new MyView("/WEB-INF/views/members.jsp");
    }
}
