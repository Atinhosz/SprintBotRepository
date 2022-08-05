package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoDto {


    private Long id;
    private String nome;
    private String categoria;

    public CursoDto(Curso curso){
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public static List<CursoDto> converter(List<Curso> curso) {
        return curso.stream().map(CursoDto::new).collect(Collectors.toList());
    }
}
