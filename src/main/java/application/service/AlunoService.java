package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Aluno;
import application.model.Curso;
import repository.AlunoRepository;
import repository.CursoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepo;
    @Autowired
    private CursoRepository cursoRepo;

    public Aluno salvar(Aluno aluno) {
        return alunoRepo.save(aluno);
    }

    public void matricularEmCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepo.findById(alunoId).orElseThrow();
        Curso curso = cursoRepo.findById(cursoId).orElseThrow();
       
        alunoRepo.save(aluno);
    }

    public Class<? extends Aluno> listarCursosMatriculados(Long alunoId) {
        return alunoRepo.findById(alunoId).orElseThrow().getClass();
    }
}
