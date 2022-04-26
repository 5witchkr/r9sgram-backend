package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public  String home() {
        //강의에선 home이였지만 그냥 hello.html로 연결해주겠음..
        return "hello";
    }

}
