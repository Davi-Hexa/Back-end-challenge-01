package br.com.tarefas.tarefas.repositor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tarefas.tarefas.model.Tarefa;

@Repository
public interface TarefaRepositor extends JpaRepository<Tarefa, Integer>{
    
}
