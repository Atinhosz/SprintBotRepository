package br.com.alura.forum.controller.form;

import br.com.alura.forum.controller.dto.CursoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curso")
public class CusosController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDto> lista() {
        List<Curso> curso = cursoRepository.findAll();
        return CursoDto.converter(curso);
    }

    @GetMapping ("/{curso}")
    public ResponseEntity<CursoDto> listaCursos(@PathVariable String nome) {
        Optional<Curso> curso = cursoRepository.findBynome(nome);
        if(!curso.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new CursoDto(curso.get()));
    }




}
