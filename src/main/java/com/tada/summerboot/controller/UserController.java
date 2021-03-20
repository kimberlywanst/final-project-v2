package com.tada.summerboot.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl user_service_implementation;

    @PostMapping(path="/user/new")
    public String newUser(User newUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        user_service_implementation.createUser(newUser);
        return "login";
    }

    @GetMapping(path="/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping(path="/every-users")
    public String every(Model model) {
        List<User> list = user_service_implementation.getAllUsers();
        model.addAttribute("users", list);
        return "examples/every-users";
    }

    @GetMapping(path="/register")
    public String register(User newUser) {
        return "register";
    }

    @GetMapping(path="/register-admin")
    public String registerAdmin(User newUser) {
        return "examples/register-admin";
    }


    @GetMapping(path="/user/all")
    public List<User> all(){
        return user_service_implementation.getAllUsers();
    }


    @GetMapping(path="/admin")
    public String goToAdmin(){
        return "examples/admin";
    }

    @GetMapping(path="user/show/{id}")
    public String show(Model model, @PathVariable Integer id) {
        Optional<User> user = user_service_implementation.getUser(id);
        model.addAttribute("user", user);
        return "examples/show-user";
    }

    @RequestMapping(path="user/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String destroy(@PathVariable Integer id) {
        user_service_implementation.deleteUser(id);
        return "examples/every-users";
    }

    @RequestMapping(path = {"user/edit", "user/edit/{id}"})
    public String editPost(Model model, @PathVariable("id") Integer id)
    {
        if (id != null) { // when id is null, because it is not in the database
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = user_service_implementation.current_user();
            model.addAttribute("user", user);
        } else { //else id is present, then we will just create a new entry in the database
            System.out.println("The id is NULL");
            model.addAttribute("post", new Post());
        }
        return "examples/register";
    }
}
