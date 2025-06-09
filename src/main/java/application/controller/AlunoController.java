package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Aluno;
import application.model.Curso;
import repository.AlunoRepository;
import repository.CursoRepository;

@RestController
@RequestMapping("/alunos")
@SecurityRequirement(name = "bearerAuth")
public class AlunoController {
    @Autowired private AlunoRepository alunoRepo;
    @Autowired private CursoRepository cursoRepo;

    @PostMapping("/{alunoId}/matricular/{cursoId}")
    public ResponseEntity<?> matricular(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        Aluno aluno = alunoRepo.findById(alunoId).orElseThrow();
        Curso curso = cursoRepo.findById(cursoId).orElseThrow();
        alunoRepo.save(aluno);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{alunoId}/cursos")
    public Class<? extends Aluno> cursosMatriculados(@PathVariable Long alunoId) {
        return alunoRepo.findById(alunoId).orElseThrow().getClass();
    }
}
