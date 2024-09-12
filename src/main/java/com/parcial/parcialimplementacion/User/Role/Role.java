package com.parcial.parcialimplementacion.User.Role;

import com.parcial.parcialimplementacion.User.UserInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /*
    @ManyToMany(mappedBy = "roles")
    private Set<UserInfo> users;
    */

}
