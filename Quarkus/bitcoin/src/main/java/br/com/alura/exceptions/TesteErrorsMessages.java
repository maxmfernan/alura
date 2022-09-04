package br.com.alura.exceptions;

import javax.ws.rs.core.Response.Status;

public enum TesteErrorsMessages {
    ERROR_MATRICULA_ERRADA("0001", "A matrícula informada está errada."),
    ERROR_USUARIO_SISTEMA_SEM_CREDENCIAIS("0002", "Usuário interno do sistema sem credencias para a operação");

    private final Status DEFAULT_HTTPCODE = Status.fromStatusCode(422);

    private String code;
    private String mensagem;
    private Status httpCode;

    private TesteErrorsMessages(String code, String mensagem) {
        this.code = code;
        this.mensagem = mensagem;
        this.httpCode = DEFAULT_HTTPCODE;
    }

    public TesteError createError() {
        return new TesteError(this.code, this.mensagem, this.httpCode);
    }

    public TesteError createError(Status httpCode) {
        return new TesteError(this.code, this.mensagem, httpCode);
    }

    private class TesteError implements Error {
        private String code;
        private String mensagem;
        private Status httpCode;

        public TesteError(String code, String mensagem, Status httpCode) {
            this.code = code;
            this.mensagem = mensagem;
            this.httpCode = httpCode;
        }

        public TesteError() {

        }

        @Override
        public String getCode() {
            return this.code;
        }

        @Override
        public String getMensagem() {
            return this.mensagem;
        }

        @Override
        public Status getHttpCode() {
            return this.httpCode;
        }

    }
}
