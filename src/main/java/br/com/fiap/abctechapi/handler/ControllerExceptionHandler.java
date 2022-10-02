package br.com.fiap.abctechapi.handler;

import br.com.fiap.abctechapi.handler.exception.MaximoServicosPorOsException;
import br.com.fiap.abctechapi.handler.exception.MinimoServicosPorOsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MinimoServicosPorOsException.class)
    public ResponseEntity<ErrorMessageResponse> errorMinServicosRequired(MinimoServicosPorOsException exception){
        return getErrorMessageResponseResponseEntity(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaximoServicosPorOsException.class)
    public ResponseEntity<ErrorMessageResponse> errorMaxServicosAllowed(MaximoServicosPorOsException exception){
        return getErrorMessageResponseResponseEntity(exception.getMessage(), exception.getDescription(), HttpStatus.BAD_REQUEST);
    }
    private ResponseEntity<ErrorMessageResponse> getErrorMessageResponseResponseEntity(String message, String description, HttpStatus statusCode) {
        ErrorMessageResponse error = new ErrorMessageResponse();
        error.setMessage(message);
        error.setDescription(description);
        error.setTimestamp(new Date());
        error.setStatusCode(statusCode.value());

        return new ResponseEntity<ErrorMessageResponse>(error, statusCode);
    }


}
