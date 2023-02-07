<%@ page import="tutorial.servlet.domain.member.MemberRepository" %>
<%@ page import="tutorial.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    //service로직은 그대로 지원이 되기 때문에 request, response 그대로 사용
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>



<html>
  <head>
    <title>Title</title>
  </head>
  <body>

  성공
  <ul>
      <li>id=<%=member.getId()%></li>
      <li>username=<%=member.getUsername()%></li>
      <li>age=<%=member.getAge()%></li>
  </ul>
  <a href="/index.html">메인</a>

  </body>
</html>
