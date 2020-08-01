package web.contoller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUser(Model model) {


        LOGGER.info("showFormUsers");

        List<User> users = userService.getUsers();

        model.addAttribute("users", users);

        return "users";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        LOGGER.info("showFormForAdd");

        User user = new User();

        model.addAttribute("user", user);

        return "save-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {

        LOGGER.info("showFormSaveUsers");

        userService.addUser(user);

        return "redirect:/users";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") long idUser,
                                    Model model) {

        User user = userService.getUserById(idUser);

        model.addAttribute("user", user);

        LOGGER.info("showFormForUpdate");

        return "edit-user";
    }


    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {

        LOGGER.info("updateUser");

        userService.updateUser(user);

        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") long idUser) {

        userService.deleteUser(idUser);

        return "redirect:/users";
    }
}
