package com.parcial.parcialimplementacion.Modelo;

import com.parcial.parcialimplementacion.Modelo.ModeloEntity;
import com.parcial.parcialimplementacion.Modelo.IModeloDAO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Service
public class ModeloService implements IModeloService {

    @Autowired
    private IModeloDAO modeloDAO;

    @Override
    public List<ModeloEntity> findAll() {
        return modeloDAO.findAll();
    }

    @Override
    public ModeloEntity save(ModeloEntity modelo) {
        return modeloDAO.save(modelo);
    }

    @Override
    public ModeloEntity findById(Long id) {
        return modeloDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        modeloDAO.deleteById(id);
    }
}

