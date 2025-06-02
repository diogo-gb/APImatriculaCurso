package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Modulo;
import repository.ModuloRepository;

@Service
public class ModuloService {
    @Autowired
    private ModuloRepository moduloRepo;

    public Modulo salvar(Modulo modulo) {
        return moduloRepo.save(modulo);
    }

    public Modulo atualizar(Long id, Modulo modulo) {
        Modulo existente = moduloRepo.findById(id).orElseThrow();
        existente.setTitulo(modulo.getTitulo());
        existente.setDescricao(modulo.getDescricao());
        return moduloRepo.save(existente);
    }
}
