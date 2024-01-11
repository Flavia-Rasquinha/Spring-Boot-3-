package med.voll.api.controller;

import med.voll.api.paciente.DadosCadastrosPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastrosPaciente dados){
        System.out.println(dados);

    }
}
