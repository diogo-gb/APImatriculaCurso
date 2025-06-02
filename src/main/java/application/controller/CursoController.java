package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import application.model.Curso;
import repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearerAuth")
public class CursoController {

    @Autowired private CursoRepository cursoRepo;

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoRepo.save(curso));
    }

    @GetMapping
    public List<Curso> listar() {
        return cursoRepo.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso curso) {
        Curso existente = cursoRepo.findById(id).orElseThrow();
        existente.setNome(curso.getNome());
        existente.setDescricao(curso.getDescricao());
        existente.setCargaHoraria(curso.getCargaHoraria());
        return ResponseEntity.ok(cursoRepo.save(existente));
    }
}
