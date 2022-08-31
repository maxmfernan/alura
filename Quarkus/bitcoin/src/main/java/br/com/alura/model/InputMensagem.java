package br.com.alura.model;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"matricula"})
public class InputMensagem {
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
}
