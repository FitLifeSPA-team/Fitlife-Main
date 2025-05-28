package fitlife.data.cl.servicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fitlife.data.cl.servicios.model.asesorias;
import fitlife.data.cl.servicios.service.asesoriasService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class asesoriasController {

    @Autowired
    private asesoriasService asesoriasService;
    
    @GetMapping
    public ResponseEntity<List<asesorias>> listar() {
        List<asesorias> asesorias1 = asesoriasService.fetchAll();
        

        if (asesorias1.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(asesorias1);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity <asesorias> buscar(@PathVariable Integer id) {
        
        asesorias asesorias1 = asesoriasService.fetchById(id);
        
        return ResponseEntity.ok(asesorias1);
        
    }

    @PostMapping
    public ResponseEntity <asesorias> guardar(@RequestBody asesorias asesorias) {
        asesorias asesoriasNueva = asesoriasService.save(asesorias);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(asesoriasNueva);
    }
    


}
