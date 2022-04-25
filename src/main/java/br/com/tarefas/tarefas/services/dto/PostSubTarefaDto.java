package br.com.tarefas.tarefas.services.dto;

import br.com.tarefas.tarefas.config.EnumerateEstado;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostSubTarefaDto {
    private String nome_subtarefa;

    private EnumerateEstado estado;

    private Integer id_tarefa;

}
