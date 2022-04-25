package br.com.tarefas.tarefas.repositor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tarefas.tarefas.model.SubTarefa;

@Repository
public interface SubTarefaRepositor extends JpaRepository<SubTarefa, Integer>{
    
    @Modifying
    @Query("update SubTarefa s set s.estado = :estado where s.id = :id")
    void updatePhone(@Param(value = "id") Integer id, @Param(value = "estado") SubTarefa subTarefa);
}
