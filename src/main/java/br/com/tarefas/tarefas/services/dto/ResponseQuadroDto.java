package br.com.tarefas.tarefas.services.dto;

import br.com.tarefas.tarefas.model.Quadro;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseQuadroDto {
    private Integer id;
    private String nome;

    public ResponseQuadroDto(Quadro quadro){
        this.setId(quadro.getId());
        this.setNome(quadro.getNome());
    }
}
