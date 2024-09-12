package com.parcial.parcialimplementacion.User.Role;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner initializeRoles(IRoleDAO roleDAO){     // Generate values in role table only when the app run for first time or when role table is empty
        return args ->{
            if (roleDAO.count() == 0){
                Role adminRole = new Role(null, "ADMIN_ROLE");
                Role organizerRole = new Role(null, "ORGANIZER_ROLE");
                Role modelRole = new Role(null, "MODEL_ROLE");
                Role attendeeRole = new Role(null, "ATTENDEE_ROLE");

                roleDAO.save(adminRole);
                roleDAO.save(organizerRole);
                roleDAO.save(modelRole);
                roleDAO.save(attendeeRole);
            }
        };
    }
}
