package com.parcial.parcialimplementacion.User.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDAO extends JpaRepository<Role, Long> {
    public Role findByName(String name);
}
