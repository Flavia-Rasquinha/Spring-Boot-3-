package med.voll.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.medico.DadosCadastrosMedicos;
import med.voll.api.domain.medico.Endereco;
import med.voll.api.domain.medico.Especialidade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser
    void cadastrar_sucess() throws  Exception{

        DadosCadastrosMedicos dados = new DadosCadastrosMedicos("Bia", "bia@voll.me", "999999999", "123456", Especialidade.ORTOPEDIA,
                new DadosEndereco("rua 1","bairro","12345678","Brasilia","DF","complemento", "1"));

        mvc.perform(MockMvcRequestBuilders
                        .post("/medicos")
                        .content(objectMapper.writeValueAsString(dados))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void testCadastrarMedicoComFalhaDeValidacao() throws Exception {
        DadosCadastrosMedicos dados = new DadosCadastrosMedicos("Bia", "bia@voll.me", "999999999", "123456", Especialidade.ORTOPEDIA,
                null
        );

        mvc.perform(MockMvcRequestBuilders
                        .post("/medicos")
                        .content(objectMapper.writeValueAsString(dados))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}