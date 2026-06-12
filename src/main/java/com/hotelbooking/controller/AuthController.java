package com.hotelbooking.controller;

import com.hotelbooking.entity.Role;
import com.hotelbooking.entity.User;
import com.hotelbooking.repository.RoleRepository;
import com.hotelbooking.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    public AuthController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@RequestParam String email, 
                          @RequestParam String password,
                          @RequestParam String fullName) {
        
        Role touristRole = roleRepository.findByName("TOURIST").get();
        
        User user = new User();
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setFullName(fullName);
        user.setRole(touristRole);
        
        userRepository.save(user);
        
        return "redirect:/login-page";
    }
    
    @GetMapping("/login-page")
    public String loginPage() {
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        var user = userRepository.findByEmail(email);
        if (user.isPresent() && encoder.matches(password, user.get().getPassword())) {
            return "redirect:/";
        }
        return "redirect:/login-page?error=true";
    }
}