package cn.bigff.controller;


import cn.bigff.domain.UserPO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

//    @PostMapping("add")
//    public String  add(UserPO userPO ,Model model){
//        model.addAttribute("user",userPO);
//        return "result";
//    }

    @PostMapping("add")
    public @ResponseBody UserPO add(UserPO userPO){
//        model.addAttribute("user",userPO);
//        System.out.println(userPO.getName()+";"+userPO.getAge());

        return userPO;
    }


    @RequestMapping(value = "/ajaxDelete",method = RequestMethod.DELETE)
    @ResponseBody
    public String testAjaxDelete(UserPO user){
        System.out.println(user.getName());
        return "success";
    }

    @PutMapping("edit")
    public String edit(UserPO userPO, Model model){
        model.addAttribute("user",userPO);
        return "redirect:/";
    }

    @DeleteMapping("{id}")
    public String remove(@PathVariable Long id){
        System.out.println(id);
        return "result";
    }




}
