package com.parcial.parcialimplementacion.Model;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class ModelService implements IModelService {

    @Autowired
    private IModelDAO modelDAO;

    @Override
    public List<Model> findAll() {
        return modelDAO.findAll();
    }

    @Override
    public Model save(Model model) {
        return modelDAO.save(model);
    }

    @Override
    public Model findById(Long id) {
        return modelDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        modelDAO.deleteById(id);
    }
}

