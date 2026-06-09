package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;




@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home Page Handler");
        
        // sending data to the view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtubeChannel","Learn with me");
        model.addAttribute("githubRepo","https://github.com/your-repo");
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        System.out.println("About Page Handler");
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services Page Handler");
        return "services";
    }

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    @GetMapping("register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        // We can upload default data as well
        model.addAttribute("userForm", userForm);

        return "register";
    }
    
    // processing register
    @RequestMapping(value="/do_register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session ){
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data
        if (rBindingResult.hasErrors()) {            
            return "register";
        }

        // save to database

        // userService
        //UserForm --> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://img.freepik.com/premium-vector/male-face-avatar-icon-set-flat-design-social-media-profiles_1281173-3806.jpg?w=2000")
        // .build();
        // User savedUser = userService.saveUser(user);

        User user= new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://img.freepik.com/premium-vector/male-face-avatar-icon-set-flat-design-social-media-profiles_1281173-3806.jpg?w=2000");
        user.setEnabled(false);
        User savedUser = userService.saveUser(user);

        // message = "Registration successful"

        // add the message'
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);
        // redirect to login page
        return "redirect:/register";
    }


}
