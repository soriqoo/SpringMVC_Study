package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

/**
 *  서블릿 기술을 전혀 사용하지 않음
 */
public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);
}
