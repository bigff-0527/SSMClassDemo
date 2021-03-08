package cn.bigff.controller;

import cn.bigff.domain.UserPO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/testAjax")
    public @ResponseBody
    UserPO testAjax(){
        UserPO userPO = new UserPO();
        userPO.setName("bigff");
        userPO.setAge(18);
        return userPO;
    }

}
