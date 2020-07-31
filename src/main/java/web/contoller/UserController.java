package web.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value ="/users")
    public String getUser(ModelMap model){
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        model.addAttribute("title", "Users");
        return "users";
    }

}
