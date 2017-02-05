package ddd.controllers;

import com.google.gson.Gson;
import ddd.model.Role;
import ddd.model.User;
import ddd.services.RoleService;
import ddd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.sql.*;
import java.util.List;

@Controller
@RequestMapping(value = "/")

public class WelcomeController {
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    @Autowired(required = true)
    private UserService userService;

    @Autowired(required = true)
    private RoleService roleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String usersAndRoles() throws SQLException, ClassNotFoundException {

        return "usersAndRoles";
    }

    @RequestMapping(value = "roles", method = RequestMethod.GET)

    public String roles(Model model) throws SQLException, ClassNotFoundException {
          model.addAttribute("listR", new Gson().toJson(roleService.returnListRole()));
        return "roles";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)

    public String users(Model model) throws SQLException, ClassNotFoundException {
        List<User> user = userService.returnListUser();
        System.out.println("в контролере пользователи" + user.get(0).getName_user());
        List<Role> role = roleService.returnListRole();
        System.out.println("в контролере роли" + role.get(0).getName_roles());
        model.addAttribute("listUser", new Gson().toJson(userService.returnListUser()));
        model.addAttribute("listRole", new Gson().toJson(roleService.returnListRole()));
        return "users";
    }

}