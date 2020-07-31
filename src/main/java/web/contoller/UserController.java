package web.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getUser(ModelMap model) {
        List<User> users = userService.getUsers();

        model.addAttribute("users", users);
        model.addAttribute("title", "Users");

         return "users";
    }

}
