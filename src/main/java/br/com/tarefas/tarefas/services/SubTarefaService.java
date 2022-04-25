package br.com.tarefas.tarefas.services;

import org.springframework.stereotype.Service;

import br.com.tarefas.tarefas.config.ErrorMessege;
import br.com.tarefas.tarefas.model.SubTarefa;
import br.com.tarefas.tarefas.model.Tarefa;
import br.com.tarefas.tarefas.repositor.SubTarefaRepositor;
import br.com.tarefas.tarefas.repositor.TarefaRepositor;
import br.com.tarefas.tarefas.services.dto.PostSubTarefaDto;
import br.com.tarefas.tarefas.services.dto.ResponseSubTarefaDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubTarefaService {
    private SubTarefaRepositor subTarefaRepositor;
    private TarefaRepositor tarefaRepositor;

    public ResponseSubTarefaDto createSubTarefa(Integer id, PostSubTarefaDto dto){
        SubTarefa subTarefa = new SubTarefa();
        Tarefa tarefa = this.tarefaRepositor.findById(id).orElseThrow(() -> new ErrorMessege("Tarefa Inexistente"));

        subTarefa.setNome_subTarefa(dto.getNome_subtarefa());
        subTarefa.setEstado(dto.getEstado());
        subTarefa.setId_tarefa(tarefa);
        
        this.subTarefaRepositor.save(subTarefa);

        ResponseSubTarefaDto response = new ResponseSubTarefaDto(subTarefa, tarefa);
        return response;
    }

    public ResponseSubTarefaDto updateSubTarefa(Integer id, PostSubTarefaDto dto){
        SubTarefa subTarefa = this.subTarefaRepositor.findById(id).orElseThrow(() -> new ErrorMessege("SubTarefa inexistente!"));

        subTarefa.setEstado(dto.getEstado());
        this.subTarefaRepositor.save(subTarefa);

        ResponseSubTarefaDto responseTarefaDto = new ResponseSubTarefaDto();
        responseTarefaDto.setEstado(dto.getEstado());
        responseTarefaDto.setNome(subTarefa.getNome_subTarefa());
        responseTarefaDto.setId(id);
        return responseTarefaDto;
    }
    public String deletarSub(Integer id){
        SubTarefa subTarefa = this.subTarefaRepositor.findById(id).orElseThrow(() -> new ErrorMessege("SubTarefa inexistente!"));
        subTarefaRepositor.delete(subTarefa);
        return "A SubTarefa "+ id + " Foi excluida!\nos valores eram:\nnome: " + subTarefa.getNome_subTarefa() + "\nestado: " + subTarefa.getEstado();
    }
    
}
