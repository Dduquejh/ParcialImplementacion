package com.parcial.parcialimplementacion.Model;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.*;



@RestController()
@RequestMapping("/api/models")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @GetMapping()
    public List<Model> getModels(){
        return modelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getModelById(@PathVariable Long id){
        Model model = modelService.findById(id);
        if(model == null){
            return ResponseEntity.status(404).body("model not found");
        }
        return ResponseEntity.status(200).body(model);
    }

    @PostMapping()
    public ResponseEntity<?> postModel(@Valid @RequestBody Model model){
        try {
            modelService.save(model);
            return ResponseEntity.status(201).body(model);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModel(@PathVariable Long id){
        if(modelService.findById(id) == null){
            return ResponseEntity.status(404).body("model not found");
        }
        try{
            modelService.deleteById(id);
            return ResponseEntity.status(204).build();
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateModel(@PathVariable Long id, @RequestBody Model model){
        Model modelDB = modelService.findById(id);
        if(modelDB == null){
            return ResponseEntity.status(404).body("model not found");
        }
        try{
            modelDB.setModelName(model.getModelName());
            modelDB.setModelDescription(model.getModelDescription());
            modelService.save(modelDB);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }


    }
}
