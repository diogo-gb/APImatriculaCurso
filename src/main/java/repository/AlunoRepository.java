package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
     Optional<Aluno> findByEmail(String email);
}
