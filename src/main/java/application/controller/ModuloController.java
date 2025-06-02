package application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Modulo;
import repository.ModuloRepository;

@RestController
@RequestMapping("/modulos")
@SecurityRequirement(name = "bearerAuth")
public class ModuloController {
    @Autowired private ModuloRepository moduloRepo;

    @PostMapping
    public ResponseEntity<Modulo> criar(@RequestBody Modulo modulo) {
        return ResponseEntity.ok(moduloRepo.save(modulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modulo> atualizar(@PathVariable Long id, @RequestBody Modulo modulo) {
        Modulo existente = moduloRepo.findById(id).orElseThrow();
        existente.setTitulo(modulo.getTitulo());
        existente.setDescricao(modulo.getDescricao());
        return ResponseEntity.ok(moduloRepo.save(existente));
    }
}
