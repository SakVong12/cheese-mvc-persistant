package com.launchcode.cheesemvc.Controller;


import com.launchcode.cheesemvc.Model.User;
import com.launchcode.cheesemvc.Model.data.UserDAO;
import com.launchcode.cheesemvc.Model.data.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "user")
public class UserController {

    //private static ArrayList<String> user = new ArrayList<>();

    private UserDAO userDAO;

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("users", UserManager.getAll());
        model.addAttribute("title","My User");
        return "user/index";
    }

    @RequestMapping(value ="add", method = RequestMethod.GET)
    public String addForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title", "Add User");
        return "user/addUser";
    }

    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String processAddForm(Model template, @ModelAttribute @Valid User newUser, Errors errors){

        if(errors.hasErrors()){
            template.addAttribute("title", "add user");
            return "user/add";
        }
        userDAO.save(newUser);
        return "redirect:";
    }

}


