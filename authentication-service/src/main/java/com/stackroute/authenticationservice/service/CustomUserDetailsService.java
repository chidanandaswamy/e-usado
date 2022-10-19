package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());

    }
    public User findByEmailAndPassword(String email, String password) throws UsernameNotFoundException {
        User loggedInUser = repository.findByEmailAndPassword(email, password);
        if(loggedInUser == null)
        {
            throw new UsernameNotFoundException("User not found");
        }

        return loggedInUser;
    }


    public User register(User user)  {
//        if (repository.findByEmail(user.getEmail()).isPresent()) {
//            throw new UserAlreadyExistsException();
//        }
        return repository.save(user);
    }


}



