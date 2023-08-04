package com.project.useraccountmanagement.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public String hello() {
        return "Hello from User site";
    }

    @GetMapping("/profile")
    public User userDetail(
            HttpServletRequest request
    ) {
        return service.getUserDetail(request);
    }

    @PutMapping("/updateUserProfile")
    public User put(
            @RequestParam("id") Integer id,
            @RequestBody User user
    ) {
        return service.updateUserProfile(id,user);
    }

}
