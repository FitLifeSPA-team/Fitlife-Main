package fitlife.data.cl.servicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import fitlife.data.cl.servicios.model.nutricionistas;
import fitlife.data.cl.servicios.service.nutricionistasService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class nutricionistasController {
    @Autowired
    private nutricionistasService nutricionistasService;
    
    @GetMapping
    public ResponseEntity<List<nutricionistas>> listar() {
        List<nutricionistas> nutricionistas1 = nutricionistasService.fetchAll();
        

        if (nutricionistas1.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(nutricionistas1);
        
    }



    @GetMapping("/{id2}")
    public ResponseEntity <nutricionistas> buscar(@PathVariable Long id) {
        
        nutricionistas nutricionistas1 = nutricionistasService.fetchById(id);
        
        return ResponseEntity.ok(nutricionistas1);
        
    }

    @PostMapping
    public ResponseEntity <nutricionistas> guardar(@RequestBody nutricionistas nutricionistas) {
        nutricionistas nutricionistasNueva = nutricionistasService.save(nutricionistas);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(nutricionistasNueva);
    }
    

    @PutMapping("/{id2}")
    public ResponseEntity<nutricionistas> actualizar
    (@PathVariable Long id, 
    @RequestBody nutricionistas nutricionistas) 
    {
        try {
            nutricionistas n = nutricionistasService.fetchById(id);
            n.setId(id);
            n.setNombre (nutricionistas.getNombre());
            n.setApellido(nutricionistas.getApellido());
            n.setEmail(nutricionistas.getEmail());
            n.setTelefono(nutricionistas.getTelefono());
            n.setEspecialidad(nutricionistas.getEspecialidad());
            n.setPrecioConsulta(nutricionistas.getPrecioConsulta());

            nutricionistasService.save(n);
            return ResponseEntity.ok(n);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id2}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            nutricionistasService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}