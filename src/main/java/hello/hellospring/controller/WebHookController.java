package hello.hellospring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class WebHookController {

    @PostMapping(path = "/webhook")
    public String webhookReveive(@RequestBody HashMap<String, Object> param )
    {
        System.out.println("param : " + param);
        return param.toString();

    }


}
