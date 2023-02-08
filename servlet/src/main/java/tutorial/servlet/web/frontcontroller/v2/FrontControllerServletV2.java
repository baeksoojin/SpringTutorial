package tutorial.servlet.web.frontcontroller.v2;

import tutorial.servlet.web.frontcontroller.MyView;
import tutorial.servlet.web.frontcontroller.v1.ControllerV1;
import tutorial.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import tutorial.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import tutorial.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2>
            controllerMap = new HashMap<>();
    //url을 통해서 controller를 호출할거여서 key를 string, value를 컨트롤러

    public FrontControllerServletV2(){
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServlet2.service");

        //map을 통해서 어떤 컨트롤러가 호출되었는지 찾고 jsp를 호출

        String requestURI = request.getRequestURI();

        ControllerV2 controller = controllerMap.get(requestURI);
        if(controller==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(request, response);
        view.render(request,response);
    }
}