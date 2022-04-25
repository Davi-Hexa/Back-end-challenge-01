package br.com.tarefas.tarefas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.tarefas.tarefas.repositor.SubTarefaRepositor;
import br.com.tarefas.tarefas.services.SubTarefaService;
import br.com.tarefas.tarefas.services.dto.PostSubTarefaDto;
import br.com.tarefas.tarefas.services.dto.ResponseSubTarefaDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class SubTarefaController {
    private final SubTarefaService subTarefaService;
    private final SubTarefaRepositor subTarefaRepositor;

    @PostMapping("v1/inserir/subtarefa/{id}")
    public ResponseEntity<?> createSubTarefa(@PathVariable(name = "id")Integer id ,@RequestBody PostSubTarefaDto dto){
        ResponseSubTarefaDto response  = this.subTarefaService.createSubTarefa(id, dto);
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping("v1/deletar/subtarefa/{id}")
    public String deletarSub(@PathVariable(name = "id") Integer id){
        return this.subTarefaService.deletarSub(id);
    }

    @GetMapping("v1/subtarefas")
    public ResponseEntity<?> showSub(){
        return new ResponseEntity<>(subTarefaRepositor.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "subtarefaupdate/{id}")
    public ResponseEntity<?> updateSub(@PathVariable(name = "id")Integer id, @RequestBody PostSubTarefaDto dto){
        ResponseSubTarefaDto response = this.subTarefaService.updateSubTarefa(id, dto);
        return ResponseEntity.ok(response);
    }
}
