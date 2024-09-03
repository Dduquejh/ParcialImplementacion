package com.parcial.parcialimplementacion.Portafolio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.parcial.parcialimplementacion.Portafolio.PortafolioEntity;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface IPortafolioDAO extends JpaRepository<PortafolioEntity, Long> {

}
