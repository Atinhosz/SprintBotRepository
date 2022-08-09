package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.CursoDto;
import br.com.alura.forum.controller.form.CursosForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursosController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<CursoDto>> lista() {
        List<Curso> curso = cursoRepository.findAll();
        return ResponseEntity.ok(CursoDto.converterListaCurso(curso));
    }

    @GetMapping ("/{curso}")
    public ResponseEntity<CursoDto> listaCursos(@PathVariable String nome) {
        Optional<Curso> curso = cursoRepository.findByNome(nome);
        if(!curso.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new CursoDto(curso.get()));
    }

    @PostMapping
    public ResponseEntity<CursoDto> criar(@RequestBody @Valid CursosForm cursosForm, UriComponentsBuilder uriComponentsBuilder){
           Curso curso = cursosForm.converterForm(cursosForm);
           Curso cursoSalva = cursoRepository.save(curso);
        URI uri = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
      return ResponseEntity.created(uri).body(CursoDto.converterCurso(cursoSalva));
    }


}
