package com.calculadora.calculadoraseguro.config.http;

import com.calculadora.calculadoraseguro.exception.PrecoBaseException;
import com.calculadora.calculadoraseguro.exception.SeguroNotFoundException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SeguroNotFoundException.class)
    public ResponseEntity<String> handleSeguroNotFoundException(SeguroNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PrecoBaseException.class)
    public ResponseEntity<String> handleSeguroNotFoundException(PrecoBaseException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(Exception ex) {
        Throwable mostSpecificCause = ex.getCause();

        if (mostSpecificCause instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) mostSpecificCause;
            String fieldName = invalidFormatException.getPath().get(0).getFieldName();
            String rejectedValue = invalidFormatException.getValue().toString();

            Class<?> enumClass = invalidFormatException.getTargetType().getEnumConstants().getClass();
            String acceptedValues = String.join(", ", Arrays.stream(enumClass.getComponentType().getEnumConstants())
                    .map(Object::toString)
                    .toArray(String[]::new));

            String errorMessage = String.format("O campo '%s' com valor '%s' não é válido. Valores aceitos: %s",
                    fieldName, rejectedValue, acceptedValues);


            log.error("Erro de mapeamento JSON. Verifique a estrutura do JSON enviado: {}", errorMessage, ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        } else if (mostSpecificCause instanceof JsonMappingException) {
            String errorMessage = "Erro de mapeamento JSON. Verifique a estrutura do JSON enviado.";
            log.error(errorMessage, ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        } else {
            log.error("Erro de desserialização JSON: {}", ex);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de desserialização JSON");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        log.error("Erro genérico", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
    }
}
