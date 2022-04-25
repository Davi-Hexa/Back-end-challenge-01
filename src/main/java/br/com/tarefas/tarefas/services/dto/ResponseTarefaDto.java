package br.com.tarefas.tarefas.services.dto;

import br.com.tarefas.tarefas.config.EnumerateEstado;
import br.com.tarefas.tarefas.model.Quadro;
import br.com.tarefas.tarefas.model.Tarefa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseTarefaDto {
    private Integer id;

    private String nome;

    private EnumerateEstado estado;

    private Integer id_quadro;

    public ResponseTarefaDto(Tarefa tarefa, Quadro quadro){
        this.setId(tarefa.getId());
        this.setEstado(tarefa.getEstado());
        this.setNome(tarefa.getNome_tarefa());
        this.setId_quadro(quadro.getId());
    }
    
}
