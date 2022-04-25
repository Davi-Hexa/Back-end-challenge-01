package br.com.tarefas.tarefas.services;

import org.springframework.stereotype.Service;

import br.com.tarefas.tarefas.config.ErrorMessege;
import br.com.tarefas.tarefas.model.Quadro;
import br.com.tarefas.tarefas.model.Tarefa;
import br.com.tarefas.tarefas.repositor.QuadroRepositor;
import br.com.tarefas.tarefas.repositor.TarefaRepositor;
import br.com.tarefas.tarefas.services.dto.PostTarefaDto;
import br.com.tarefas.tarefas.services.dto.ResponseTarefaDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TarefaService { 
    private final TarefaRepositor tarefaRepositor;
    private final QuadroRepositor quadroRepositor;

    public ResponseTarefaDto createTarefa(Integer id, PostTarefaDto dto){
        Tarefa tarefa = new Tarefa();
        Quadro quadro = this.quadroRepositor.findById(id).orElseThrow(() -> new ErrorMessege("Quadro não existe"));

        tarefa.setNome_tarefa(dto.getNome_tarefa());
        tarefa.setEstado(dto.getEstado());
        tarefa.setId_quadro(quadro);

        this.tarefaRepositor.save(tarefa);

        ResponseTarefaDto responseTarefaDto = new ResponseTarefaDto(tarefa, quadro);
        return responseTarefaDto;
    }

    public ResponseTarefaDto updateTarefa(Integer id, PostTarefaDto dto){
        Tarefa tarefa = this.tarefaRepositor.findById(id).orElseThrow(() -> new ErrorMessege("Tarefa inexistente!"));

        tarefa.setEstado(dto.getEstado());
        this.tarefaRepositor.saveAndFlush(tarefa);

        ResponseTarefaDto responseTarefaDto = new ResponseTarefaDto();
        responseTarefaDto.setEstado(dto.getEstado());
        responseTarefaDto.setNome(tarefa.getNome_tarefa());
        responseTarefaDto.setId(id);
        return responseTarefaDto;
    }
    public String deleteTarefa(Integer id){
        Tarefa tarefa = this.tarefaRepositor.findById(id).orElseThrow(() -> new ErrorMessege("Tarefa Inexistente!"));
        tarefaRepositor.delete(tarefa);
        
        return "A tarefa " + id + " Foi Excluida!\n" + "Os valores eram:\n" + "nome: "+ tarefa.getNome_tarefa() + "\nestado: " + tarefa.getEstado();
    }
}
