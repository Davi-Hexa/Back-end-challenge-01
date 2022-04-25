package br.com.tarefas.tarefas.services;

import org.springframework.stereotype.Service;

import br.com.tarefas.tarefas.config.ErrorMessege;
import br.com.tarefas.tarefas.model.Quadro;
import br.com.tarefas.tarefas.repositor.QuadroRepositor;
import br.com.tarefas.tarefas.services.dto.PostQuadroDto;
import br.com.tarefas.tarefas.services.dto.ResponseQuadroDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuadroService {
    private final QuadroRepositor quadroRepositor;

    public ResponseQuadroDto createQuadro(PostQuadroDto dto){
        Quadro quadro = new Quadro();

        quadro.setNome(dto.getNome());
        this.quadroRepositor.save(quadro);

        ResponseQuadroDto responseQuadroDto = new ResponseQuadroDto(quadro);
        return responseQuadroDto;
    }

    public ResponseQuadroDto updateQuadro(Integer id,PostQuadroDto dto){
        Quadro quadro = this.quadroRepositor.findById(id).orElseThrow(() -> new ErrorMessege("Quadro não existe"));

        quadro.setNome(dto.getNome());
        this.quadroRepositor.save(quadro);
        
        ResponseQuadroDto response = new ResponseQuadroDto(quadro);
        return response;
    }
    public String deletarQuadro(Integer id){
        Quadro quadro = this.quadroRepositor.findById(id).orElseThrow(() -> new ErrorMessege("Quadro inexistente!"));
        quadroRepositor.delete(quadro);
        return "o Quadro "+ id + " Foi excluido!";
    }
}
