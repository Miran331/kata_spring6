package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/user/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/user/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("email") String email) {
        User user = new User(null, name, email);
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/user/edit")
    public String editUser(@RequestParam("id") Long id,
                           @RequestParam("name") String name,
                           @RequestParam("email") String email) {
        User user = new User(id, name, email);
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/user/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}


