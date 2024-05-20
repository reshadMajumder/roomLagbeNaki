package com.roomLagbe.roomlagbenaki.controller;

import com.roomLagbe.roomlagbenaki.dao.RoomRepository;
import com.roomLagbe.roomlagbenaki.dao.UserRepository;
import com.roomLagbe.roomlagbenaki.entities.Room;
import com.roomLagbe.roomlagbenaki.entities.User;
import jakarta.servlet.http.HttpSession;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/all-post")
    public String allRooms(){
        return "allrooms";
    }



    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    // this handeller for register user
    @PostMapping("/do_register")
    public String registerUser(@Valid @ModelAttribute ("user") User user, @RequestParam (value ="agrement" ,defaultValue="false") boolean agrement, Model model ){
        try {

            System.out.println("agrement : "+agrement);
            System.out.println("user : "+user);
            user.setRole("ROLE_USER");
            user.setImageUrl("defaultImage");
            user.setEnabled(true);

            User result = this.userRepository.save(user);
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("user",user);
        }
        return  "register";
    }




}
