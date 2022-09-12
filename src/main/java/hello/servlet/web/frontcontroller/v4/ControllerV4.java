package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    // ModelView가 없음. model객체는 파라미터로 전달되므로 그냥 사용하고, 뷰의 이름만 반환하면 됨
    /**
     *  @param paramMap
     *  @param model
     *  @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
