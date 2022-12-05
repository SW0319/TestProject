package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")   //GET Message (html 주소 상에 입력되는 값)
    public String hello(Model model)
    {
        model.addAttribute("data","hello!");    //data라는 속성에 hello!라는 값을 넣는다.
        return "hello"; //resources / templeate에 있는 hello로 찾아가서 값을 넣어라.


    }
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(value = "name", defaultValue = "iam default!") String name, @RequestParam("pwd") String pwd, Model model)
            //@RequestParam(가져올 데이터 이름(html에서 설정)) 데이터타입 변수명
    {
        model.addAttribute("name", name);
        model.addAttribute("pwd", pwd);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //내가 적은 문자열이 그대로 반환된다. (html을 거치지 않는다.)
    public String helloString(@RequestParam("name") String name)
    {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name, @RequestParam("pwd") String pwd) {

        Hello hello = new Hello();
        hello.setName(name);
        hello.setpwd(pwd);
        return hello;
    }


    static class Hello {
        private String name;
        private String pwd;
        public String getName()
        {
            return name;
        }
        public String getPwd()
        {
            return pwd;
        }

        public void setName(String name)
        {
            this.name = name;
        }
        public void setpwd(String pwd) {
            this.pwd = pwd;
        }


    }

}


