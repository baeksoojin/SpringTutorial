package tutorial.servlet.web.frontcontroller.v3;

import tutorial.servlet.web.frontcontroller.ModelView;
import tutorial.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3>
            controllerMap = new HashMap<>();
    //url을 통해서 controller를 호출할거여서 key를 string, value를 컨트롤러

    public FrontControllerServletV3(){
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServlet3.service");

        //map을 통해서 어떤 컨트롤러가 호출되었는지 찾고 jsp를 호출

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if(controller==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //model에 데이터를 저장하는 단계
        Map<String, String> paramMap = creteParamMap(request);

        //controller를 통해서 요청된 controller만 처리하는 단계
        ModelView mv = controller.process(paramMap);
        mv.getViewName();//논리만 얻어옴

        String viewName = mv.getViewName();//논리이름 new-form
        MyView view = viewResolver(viewName);//물리적으로 매핑

        view.render(mv.getModel(), request, response);
    }

    private static MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private static Map<String, String> creteParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(
                paramName -> paramMap.put(paramName, request.getParameter(paramName))
        );
        return paramMap;
    }
}