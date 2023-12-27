package vlrtstat.gg.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vlrtstat.gg.user.controller.error.DuplicatedEmailException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(CustomError.class)
    public ResponseEntity<ErrorResponse> handleError(CustomError e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(), e.getHttpStatus());
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors()
                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INPUT_ERROR, HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }
}
