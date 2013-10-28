package springapp.web;

import org.springframework.web.servlet.ModelAndView;
import springapp.web.HelloController;
import static org.junit.Assert.*;
import org.junit.Test;

public class HelloControllerTests {

    @Test
    public void testHandleRequestView() throws Exception {
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("hello.jsp", modelAndView.getViewName());
    }
}