package tutorial.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

public class ModelView {

    private String ViewName; //view의 논리적인 이름만 가져오고
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName) {
        ViewName = viewName;
    }

    public String getViewName() {
        return ViewName;
    }

    public void setViewName(String viewName) {
        ViewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
