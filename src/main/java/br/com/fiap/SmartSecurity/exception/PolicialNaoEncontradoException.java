package br.com.fiap.SmartSecurity.exception;

public class PolicialNaoEncontradoException extends RuntimeException {

    public PolicialNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

}