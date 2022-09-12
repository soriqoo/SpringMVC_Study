package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  ControllerV3을 지원하는 어댑터
 */
public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    // ControllerV3을 처리할 수 있는 어댑터
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        // 컨트롤러 V3로 변환 후 V3 형식에 맞게 호출
        ControllerV3 controller = (ControllerV3) handler;   // surpports()로 ControllerV3만 지원하므로 타입 변환 걱정 없이 실행 가능
        Map<String, String> paramMap = createParamMap(request);

        ModelView mv = controller.process(paramMap);

        return mv;  // ControllerV3는 ModelView 반환하므로 그대로 반환
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }
}
