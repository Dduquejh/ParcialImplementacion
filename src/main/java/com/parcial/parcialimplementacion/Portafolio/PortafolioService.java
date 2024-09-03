package com.parcial.parcialimplementacion.Portafolio;

import com.parcial.parcialimplementacion.Modelo.IModeloDAO;
import com.parcial.parcialimplementacion.Portafolio.IPortafolioDAO;
import com.parcial.parcialimplementacion.Portafolio.PortafolioEntity;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import javax.management.loading.PrivateClassLoader;

import java.util.List;
import java.time.LocalDate;

@Service
public class PortafolioService implements IPortafolioService{
    @Autowired
    private IPortafolioDAO portafolioDAO;
    @Autowired
    private IModeloDAO modeloDAO;

    @Override
    public List<PortafolioEntity> findAll() {
        return portafolioDAO.findAll();
    }

    @Transactional
    @Override
    public PortafolioEntity save(@Valid PortafolioEntity portafolio){
        if (portafolio.getModelos()== null || modeloDAO.findById(portafolio.getModelos().getModelo_id()).isEmpty()){
            throw new RuntimeException("Modelo is required");
        }
        return portafolioDAO.save(portafolio);
    }

    @Override
    public PortafolioEntity findById(Long id) {
        return portafolioDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id){
        portafolioDAO.deleteById(id);
    }

    @Override
    public List<PortafolioEntity> findPortafolioByModeloId(Long Modelo_id){
        return portafolioDAO.findPortafolioByModeloId(Modelo_id);
    }

}
