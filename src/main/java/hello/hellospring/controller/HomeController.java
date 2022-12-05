package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //localhost:8080으로 진입하면 일로 진입함
    @GetMapping("/")
    public String home()
    {
        return "home";
    }

}
