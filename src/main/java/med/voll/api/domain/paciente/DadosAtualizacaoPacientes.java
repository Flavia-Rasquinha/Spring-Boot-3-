package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPacientes(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
