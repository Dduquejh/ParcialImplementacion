package com.parcial.parcialimplementacion.Portafolio;

import com.parcial.parcialimplementacion.Portafolio.PortafolioEntity;
import java.util.List;

public interface IPortafolioService {
    public PortafolioEntity save(PortafolioEntity portafolio);
    public void deleteById(Long id);
    public PortafolioEntity findById(Long id);
    public List<PortafolioEntity> findAll();
}
