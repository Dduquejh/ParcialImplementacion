package com.parcial.parcialimplementacion.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private IUserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder encoder; // This is the encoder that we will use to encode the password

    @Override
    public UserInfoDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail = userInfoRepository.findByEmail(email);

        return userDetail.map(UserInfoDetails::new)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserInfo user) {
        String roles[] = {user.getRole()};

        return Arrays.stream(roles).toList().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }
}