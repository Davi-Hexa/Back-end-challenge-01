package br.com.tarefas.tarefas.services.dto;


import br.com.tarefas.tarefas.config.EnumerateEstado;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostTarefaDto {
    private EnumerateEstado estado;

    private String nome_tarefa;

    private Integer id_quadro;
}
