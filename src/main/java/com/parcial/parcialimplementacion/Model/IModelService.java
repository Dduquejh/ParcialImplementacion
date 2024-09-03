package com.parcial.parcialimplementacion.Model;

import java.util.List;

public interface IModelService {
    public List<Model> findAll();
    public Model findById(Long id);
    public Model save(Model model);
    public void deleteById(Long id);
}
