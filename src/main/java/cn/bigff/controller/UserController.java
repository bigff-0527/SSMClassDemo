package cn.bigff.controller;


import cn.bigff.domain.UserPO;
import cn.bigff.service.IUserService;
import cn.bigff.service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("add")
    public String  add(UserPO userPO ,Model model){
        userPO.setCreateTime(new Date());
        int i = this.userService.insertUser(userPO);
        model.addAttribute("message",i);
        return "result";
    }

    @GetMapping("list")
    public String list(Model model){
        List<UserPO> userPOS = userService.selectUserList();
        model.addAttribute("userList",userPOS);
        return "result";
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
