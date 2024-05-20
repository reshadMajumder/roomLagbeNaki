package com.roomLagbe.roomlagbenaki.controller;

import com.roomLagbe.roomlagbenaki.dao.RoomRepository;
import com.roomLagbe.roomlagbenaki.entities.Room;
import com.roomLagbe.roomlagbenaki.entities.User;
//import com.roomLagbe.roomlagbenaki.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    @GetMapping("/add")
    public String addRooms(Model model){
        model.addAttribute("room", new Room());
        System.out.println("done");

        return "addrooms";
    }
    @PostMapping("/do-add")
    public String addRooms(@ModelAttribute ("room") Room room ,Model model){


        System.out.println("data : " + room);
        Room result = this.roomRepository.save(room);


        return "addrooms";
    }


    @GetMapping("/rooms")
    public String showRooms(Model model) {
        List<Room> rooms= this.roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "allrooms"; // Assuming you have a Thymeleaf template named "rooms.html"


    }



}