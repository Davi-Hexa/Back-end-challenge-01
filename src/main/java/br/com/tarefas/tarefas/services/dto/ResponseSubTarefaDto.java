package br.com.tarefas.tarefas.services.dto;

import br.com.tarefas.tarefas.config.EnumerateEstado;
import br.com.tarefas.tarefas.model.SubTarefa;
import br.com.tarefas.tarefas.model.Tarefa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseSubTarefaDto {
    private Integer id;

    private String nome;

    private EnumerateEstado estado;

    private Integer id_tarefa;

    public ResponseSubTarefaDto(SubTarefa subTarefa, Tarefa tarefa){
        this.setId(subTarefa.getId());
        this.setNome(subTarefa.getNome_subTarefa());
        this.setEstado(subTarefa.getEstado());
        this.setId_tarefa(tarefa.getId());
    } 
}
