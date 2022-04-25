package br.com.tarefas.tarefas.controller;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.tarefas.tarefas.repositor.QuadroRepositor;
import br.com.tarefas.tarefas.services.QuadroService;
import br.com.tarefas.tarefas.services.dto.PostQuadroDto;
import br.com.tarefas.tarefas.services.dto.ResponseQuadroDto;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class QuadroController {
    private final QuadroService quadroService;
    public final QuadroRepositor quadroRepositor;

    @PostMapping("v1/inserir/quadro")
    public ResponseEntity<?> createQuadro(@RequestBody PostQuadroDto dto){
        ResponseQuadroDto response = this.quadroService.createQuadro(dto);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("v1/atualizar/quadro/{id}")
    public ResponseEntity<?> updateQuadro(@PathVariable(name = "id")Integer id,@RequestBody PostQuadroDto dto){
        ResponseQuadroDto response = this.quadroService.updateQuadro(id, dto);
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping("v1/deletar/quadro/{id}")
    public String deletarQuadro(@PathVariable(name = "id") Integer id){
        return this.deletarQuadro(id);
    }

    @GetMapping("v1/quadros")
    public ResponseEntity<?> showAll(Pageable pageable){
        return new ResponseEntity<>(quadroRepositor.findAll(), HttpStatus.OK);
    }
}
