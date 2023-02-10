package tutorial.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tutorial.springmvc.basic.HelloData;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@Controller
@RestController
public class ResponseBodyController {

    @ResponseStatus //ResponseEntity처럼 응답코드 사용을 위해 적용
    @ResponseBody //mesage converter사용
    @GetMapping("/response-body-json")
    public HelloData responseBodyJsonV1(){
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);
        return helloData;
    }

    @ResponseStatus //ResponseEntity처럼 응답코드 사용을 위해 적용
//    @ResponseBody //mesage converter사용
    @GetMapping("/response-body-json2")
    public HelloData responseBodyJsonV2(){
        HelloData helloData = new HelloData();
        helloData.setUsername("userB");
        helloData.setAge(20);
        return helloData;
    }

}
