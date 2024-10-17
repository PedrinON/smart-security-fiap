package br.com.fiap.SmartSecurity.advice;

import org.aspectj.lang.annotation.AdviceName;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> manusearArgumentosInvalidos(MethodArgumentNotValidException erro){

        Map<String, String> mapaDeErros = new HashMap<>();
        List<FieldError> campos = erro.getBindingResult().getFieldErrors();

        for (FieldError campo: campos){
            mapaDeErros.put(campo.getField(), campo.getDefaultMessage());
        }
        return mapaDeErros;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> manusearIntegridadeDosDados(){

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("erro", "Usuário já cadastrado!");
        return errorMap;

    }
}