package com.parcial.parcialimplementacion.User;

import com.parcial.parcialimplementacion.User.Role.IRoleDAO;
import com.parcial.parcialimplementacion.User.Role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private IUserInfoRepository userInfoRepository;

    @Autowired
    private IRoleDAO roleDao;

    @Autowired
    private PasswordEncoder encoder; // This is the encoder that we will use to encode the password

    @Override
    public UserInfoDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail = userInfoRepository.findByEmail(email);

        return userDetail.map(UserInfoDetails::new)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserInfo user) {
        String roles[]= {user.getRol()};
        return Arrays.stream(roles).toList().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        Role attendeeRole = roleDao.findByName("ATTENDEE_ROLE");
        if (attendeeRole == null) {
            throw new RuntimeException("Role not found");
        }
        userInfo.setRol(attendeeRole.getName());
        userInfoRepository.save(userInfo);
        return "User added successfully";
    }
}