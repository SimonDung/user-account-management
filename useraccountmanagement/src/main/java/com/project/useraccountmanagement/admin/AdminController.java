package com.project.useraccountmanagement.admin;

import com.project.useraccountmanagement.user.User;
import com.project.useraccountmanagement.user.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

   private final AdminService service;


   @GetMapping
   public String hello() {
       return "Hello from Admin site";
   }

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
       List<User> users = service.getAllUser();
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return service.getUser(id);
    }

    @PutMapping("/updateUser")
    public User put(
            @RequestParam("id") Integer id, @RequestBody User user
    ) {
        return service.updateUser(id,user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Boolean delete(
            @PathVariable("id") Integer id
    ) {
        return service.deleteUser(id);
    }
}
