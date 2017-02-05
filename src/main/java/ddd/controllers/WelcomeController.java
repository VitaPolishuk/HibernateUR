package ddd.controllers;

import com.google.gson.Gson;
import ddd.model.Role;
import ddd.model.User;
import ddd.services.RoleService;
import ddd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping(value = "addUserTable", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<List<User>> addUserTable(@RequestBody User user) throws SQLException {//PathVariable
        this.userService.addUser(user);

        return new ResponseEntity<>(this.userService.returnListUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "addRole", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<List<Role>> addRole(@RequestBody Role role) throws SQLException {//PathVariable
        this.roleService.addRole(role);

        return new ResponseEntity<>(this.roleService.returnListRole(), HttpStatus.OK);
    }

    @RequestMapping(value = "selectRole", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<List<Role>> selectRole(@RequestBody Role role) throws SQLException {//PathVariable


        return new ResponseEntity<>(this.roleService.returnListRole(), HttpStatus.OK);
    }

    @RequestMapping(value = "saveChange", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<List<User>> saveChange(@RequestBody User user) throws SQLException {//PathVariable
        this.userService.changeUser(user);

        return new ResponseEntity<>(this.userService.returnListUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "changeRole", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<List<Role>> changeRole(@RequestBody Role role) throws SQLException {//PathVariable
        System.out.println(role.getId_roles());
        System.out.println(role.getName_roles());
        this.roleService.changeRole(role);

        return new ResponseEntity<>(this.roleService.returnListRole(), HttpStatus.OK);
    }

    @RequestMapping(value = "delUser", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<List<User>> delUser(@RequestBody User user) throws SQLException {
        this.userService.deleteUser(user.getId_user());

        return new ResponseEntity<>(this.userService.returnListUser(), HttpStatus.OK);
    }


    @RequestMapping(value = "deleteRole", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<List<Role>> deleteRole(@RequestBody Role role) throws SQLException {

        this.roleService.deleteRole(role.getId_roles());
        return new ResponseEntity<>(this.roleService.returnListRole(), HttpStatus.OK);
    }

}