/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lenovo
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/registration")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminPage() {

        return "registration";

    }

    @RequestMapping("/signup")
    @PreAuthorize("hasAuthority('ADMIN')")

    public String registerUser(@ModelAttribute User user, Model m) {

        String message = "";

        user.setPassword(new BCryptPasswordEncoder().encode(rawPassword: user.getPassword()));

        try {

            userRepository.save(entity: user);

            message = user.getUsername() + " is succesfully saved!";

        } catch (Exception e) {

            message += e.getMessage();

        }

        m.addAttribute(attributeName: "message", attributeValue: message);

        return "registration";

    }

}
