package com.example.MyAccountantBackEnd.jwt;


import com.example.MyAccountantBackEnd.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@Slf4j
public class CustomerUsersDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private com.example.MyAccountantBackEnd.entity.User userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername{}",username);
        userDetail = userRepository.findByEmailId(username);
        if(!Objects.isNull(userDetail))
            return new User(userDetail.getEmail(),userDetail.getPassword(), new ArrayList<>());
        else
            throw new UsernameNotFoundException("User not found");
    }

    public com.example.MyAccountantBackEnd.entity.User getUserDetail(){
        return  userDetail;
    }

}
