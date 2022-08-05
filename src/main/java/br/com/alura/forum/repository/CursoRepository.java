package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findAll();
    Curso findByNome(String nome);
    Optional<Curso> findBynome(String nome);
}
