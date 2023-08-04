package com.project.useraccountmanagement.admin;

import com.project.useraccountmanagement.user.User;
import com.project.useraccountmanagement.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    public User updateUser(Integer id, User userDetail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setFirstname(userDetail.getFirstname());
        user.setLastname(userDetail.getLastname());
        user.setEmail(userDetail.getEmail());
        user.setPassword(userDetail.getPassword());
        userRepository.save(user);
        return user;
    }

    public Boolean deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }


}
