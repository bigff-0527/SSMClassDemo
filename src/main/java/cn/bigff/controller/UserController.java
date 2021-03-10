package cn.bigff.controller;


import cn.bigff.domain.UserPO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("add")
    public String  add(UserPO userPO ,Model model){
        model.addAttribute("user",userPO);
        return "result";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<UserPO> list(){
        List<UserPO> userPOList = new ArrayList<>();
        UserPO bigff = new UserPO("bigff",18);
        UserPO zs = new UserPO("zs",19);
        UserPO ls = new UserPO("ls",20);
        userPOList.add(bigff);
        userPOList.add(zs);
        userPOList.add(ls);
        return userPOList;
    }

    @PostMapping("login")
    @ResponseBody
    public String login(UserPO userPO,Model model){
        System.out.println(userPO.getUsername()+";"+userPO.getPassword());
        return "result";
    }

//    @PostMapping("add")
//    public @ResponseBody UserPO add(UserPO userPO){
////        model.addAttribute("user",userPO);
////        System.out.println(userPO.getName()+";"+userPO.getAge());
//
//        return userPO;
//    }


    @RequestMapping(value = "/ajaxDelete",method = RequestMethod.DELETE)
    @ResponseBody
    public String testAjaxDelete(UserPO user){
        System.out.println(user.getUsername());
        return "success";
    }

    @PutMapping("edit")
    public String edit(UserPO userPO, Model model){
        model.addAttribute("user",userPO);
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String remove(@PathVariable Long id){
        System.out.println(id);
        return "result";
    }




}
