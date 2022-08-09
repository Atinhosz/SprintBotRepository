package br.com.alura.forum.controller.form;

import br.com.alura.forum.modelo.Curso;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CursosForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String nome;

    @NotNull @NotEmpty @Length(min = 3)
    private String categoria;


    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Curso converterForm(CursosForm cursosform) {
        return new Curso (cursosform.getNome(),cursosform.getCategoria());
    }

}
