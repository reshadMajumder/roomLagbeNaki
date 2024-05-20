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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import java.nio.file.Path;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    private static String UPLOADED_FOLDER = "src/main/resources/static/img/";

    @GetMapping("/add")
    public String addRooms(Model model){
        model.addAttribute("room", new Room());
        System.out.println("done");

        return "addrooms";
    }
    @PostMapping("/do-add")
    public String addRooms(@ModelAttribute("room") Room room, @RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/add";
        }

        try {
            // Get the bytes of the file
            byte[] bytes = file.getBytes();
            // Set the image URL
            room.setImageUrl(file.getOriginalFilename()); // You may want to change this to a unique identifier

            // Define the path where the file will be stored
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            // Save the file
            Files.write(path, bytes);

            // Save room details to the database
            roomRepository.save(room);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/add";
    }


    @GetMapping("/rooms")
    public String showRooms(Model model) {
        List<Room> rooms= this.roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "allrooms"; // Assuming you have a Thymeleaf template named "rooms.html"


    }

    @GetMapping("/room-details/{roomId}")
    public String showRoomDetails(@PathVariable int roomId, Model model) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room != null) {
            model.addAttribute("room", room);
            return "product-details"; // Assuming you have a Thymeleaf template named "room-details.html"
        } else {
            return "error"; // Handle the case where room is not found
        }
    }

    @GetMapping("/room-details")
    public String showRoomDetails() {
        
        return "product-details";
    }



}