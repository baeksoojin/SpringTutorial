package tutorial.servlet.web.frontcontroller.v2.controller;

import tutorial.servlet.domain.member.Member;
import tutorial.servlet.domain.member.MemberRepository;
import tutorial.servlet.web.frontcontroller.MyView;
import tutorial.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //비즈니스로직이 들어가는 controller
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        //model에 데이터 보관

        request.setAttribute("member", member);

        //view로 전환
        return new MyView("/WEB-INF/views/save-result.jsp");


    }
}
