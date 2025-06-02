package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Curso;
import repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepo;

    public Curso salvar(Curso curso) {
        return cursoRepo.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepo.findAll();
    }

    public Curso atualizar(Long id, Curso curso) {
        Curso existente = cursoRepo.findById(id).orElseThrow();
        existente.setNome(curso.getNome());
        existente.setDescricao(curso.getDescricao());
        existente.setCargaHoraria(curso.getCargaHoraria());
        return cursoRepo.save(existente);
    }
}

