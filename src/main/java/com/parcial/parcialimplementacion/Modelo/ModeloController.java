package com.parcial.parcialimplementacion.Modelo;

import com.parcial.parcialimplementacion.Modelo.ModeloService;
import com.parcial.parcialimplementacion.Modelo.ModeloEntity;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.*;



@RestController()
@RequestMapping("/api/modelos")
public class ModeloController {
    @Autowired
    private ModeloService modeloService;

    @GetMapping()
    public List<ModeloEntity> getModelos(){
        return modeloService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getModeloById(@PathVariable Long id){
        ModeloEntity modelo = modeloService.findById(id);
        if(modelo == null){
            return createErrorResponse("Modelo no encontrado", 404); //toca crear este metodo
        }
        return ResponseEntity.status(200).body(modelo);
    }

    @PostMapping()
    public ResponseEntity<?> postModelo(@Valid @RequestBody ModeloEntity modelo){
        try {
            modeloService.save(modelo);
            return ResponseEntity.status(201).body(modelo);
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), 500);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteModelo(@PathVariable Long id){
        modeloService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ModeloEntity updateModelo(@PathVariable Long id, @RequestBody ModeloEntity modelo){
        ModeloEntity modeloActual = modeloService.findById(id);
        if(modeloActual == null){
            throw new RuntimeException("Modelo no encontrado");
        }
        modelo.setModelo_name(modelo.getModelo_name());
        modelo.setModelo_description(modelo.getModelo_description());
        return modeloService.save(modelo);
    }

    private ResponseEntity<Map<String,String>> createErrorResponse(String message, int status){
        Map<String,String> response = new HashMap<>();
        response.put("error", message);
        return ResponseEntity.status(status).body(response);
    }
}
