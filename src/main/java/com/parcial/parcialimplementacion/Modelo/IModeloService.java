package com.parcial.parcialimplementacion.Modelo;

import com.parcial.parcialimplementacion.Modelo.ModeloEntity;
import java.util.List;

public interface IModeloService {
    public List<ModeloEntity> findAll();
    public ModeloEntity findById(Long id);
    public ModeloEntity save(ModeloEntity modelo);
    public void deleteById(Long id);
}
