package com.abhi.hotel.management.service.impl;

import com.abhi.hotel.management.exceptions.UserNotFoundException;
import com.abhi.hotel.management.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            return userRepository.findByEmail(username).orElseThrow(
                    ()->new UserNotFoundException("Username/Email not found.")
            );
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
