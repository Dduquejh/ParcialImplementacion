package com.parcial.parcialimplementacion.Portafolio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.parcial.parcialimplementacion.Portafolio.PortafolioEntity;
import com.parcial.parcialimplementacion.Portafolio.IPortafolioService;


@RestController()
@RequestMapping("/api/portafolios")
public class PortafolioController {
        @Autowired
        private IPortafolioService portafolioService;

        @PostMapping()
        public ResponseEntity<?> postPortafolio(@RequestBody PortafolioEntity portafolio) {
            try {
                System.out.println("Portafolio recibido: " + portafolio.getModelos());
                portafolioService.save(portafolio);
                return ResponseEntity.status(201).body(portafolio);
            } catch (Exception e) {
                System.out.print(e.getMessage());
                return createErrorResponse(e.getMessage(), 500);
            }
        }

        @GetMapping()
        public List<PortafolioEntity> getPortafolios () {
            return portafolioService.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getPortafolioById (@PathVariable Long id){
            PortafolioEntity portafolio = portafolioService.findById(id);
            if (portafolio == null) {
                return createErrorResponse("Portafolio no encontrado", 404);
            }
            return ResponseEntity.status(200).body(portafolio);
        }

        @DeleteMapping("/{id}")
        public void deletePortafolio (@PathVariable Long id){
            portafolioService.deleteById(id);
        }


        private ResponseEntity<Map<String, String>> createErrorResponse (String message,int status){
            Map<String, String> response = new HashMap<>();
            response.put("message", message);
            return ResponseEntity.status(status).body(response);
        }
    }
