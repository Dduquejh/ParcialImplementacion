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
    public PortafolioEntity save(@Valid PortafolioEntity portafolio) {

        if (portafolio.getModelos() == null) {
            throw new IllegalArgumentException("Modelo is required");
        }

        if (portafolio.getModelos().getModeloId() == null || modeloDAO.findById(portafolio.getModelos().getModeloId()).isEmpty()) {
            throw new IllegalArgumentException("Modelo with ID " + portafolio.getModelos().getModeloId() + " does not exist");
        }

        // Optionally, log the details of the portafolio and modelos
        System.out.println("Saving Portafolio: " + portafolio);
        System.out.println("Modelo ID: " + portafolio.getModelos().getModeloId());

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
}
