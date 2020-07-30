package web.contoller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String getIndex(){
        return "index";
    }

    @GetMapping(value ="/welcome")
    public String getWelcome(){
        return "welcome";
    }
}

