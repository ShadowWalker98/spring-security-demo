package org.example.springsecuritydemo.service;

import org.example.springsecuritydemo.model.UserPrincipal;
import org.example.springsecuritydemo.model.Users;
import org.example.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        System.out.println("Searching for user: "+ username);

        if (user == null) {
            System.out.printf("user with username %s not found\n", username);
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);
    }
}
