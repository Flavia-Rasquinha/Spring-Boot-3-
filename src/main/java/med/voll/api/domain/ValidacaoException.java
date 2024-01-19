package med.voll.api.domain;

import med.voll.api.infra.exception.TratadorDeErro;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
