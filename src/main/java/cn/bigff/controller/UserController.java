package cn.bigff.controller;


import cn.bigff.domain.UserPO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserController {

    @PostMapping("add")
    public String add(UserPO userPO, Model model){
        model.addAttribute("user",userPO);
//        System.out.println(userPO.getName()+";"+userPO.getAge());

        return "result";
    }




}
