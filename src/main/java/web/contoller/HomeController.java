package web.contoller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

//1. Написать CRUD-приложение. Использовать Spring MVC + Hibernate.
//2. Должен быть класс User с произвольными полями (id, name и т.п.).
//3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и изменять юзера.
//4. Конфигурация Spring через JavaConfig и аннотации, по аналогии с предыдущими проектами. Без Spring Boot.
//5. Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен использоваться EntityManager.

    @GetMapping(value = "/")
    public String getIndex() {
        return "index";
    }


}

