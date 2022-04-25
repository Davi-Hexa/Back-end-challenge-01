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


import br.com.tarefas.tarefas.repositor.TarefaRepositor;
import br.com.tarefas.tarefas.services.TarefaService;
import br.com.tarefas.tarefas.services.dto.PostTarefaDto;
import br.com.tarefas.tarefas.services.dto.ResponseTarefaDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class TarefaController {
    private final TarefaService tarefaService;
    private final TarefaRepositor tarefaRepositor;

    @PostMapping("v1/inserir/tarefa/{id}")
    public ResponseEntity<?> creatTarefa(@PathVariable(name = "id")Integer id,@RequestBody PostTarefaDto dto){
        ResponseTarefaDto response = this.tarefaService.createTarefa(id, dto);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping(value = "tarefaupdate/{id}")
    public ResponseEntity<?> updateTarefa(@PathVariable(name = "id")Integer id, @RequestBody PostTarefaDto dto){ //NÃO ESQUECER DO REQUESTBODY
        ResponseTarefaDto response = this.tarefaService.updateTarefa(id, dto);
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping("v1/deletar/tarefa/{id}")
    public String deleteTarefa(@PathVariable(name = "id")Integer id){
        return this.tarefaService.deleteTarefa(id);
    }

    @GetMapping("v1/tarefas")
    public ResponseEntity<?> showTarefas(){
        return new ResponseEntity<>(tarefaRepositor.findAll(), HttpStatus.OK); 
    }
}
