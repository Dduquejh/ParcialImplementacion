package com.parcial.parcialimplementacion.User.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleDAO roleDAO;

    @Override
    public List<Role> findAll(){return roleDAO.findAll();}
}
