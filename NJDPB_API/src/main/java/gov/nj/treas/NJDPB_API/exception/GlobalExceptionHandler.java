package gov.nj.treas.NJDPB_API.exception;


import gov.nj.treas.NJDPB_API.dto.ErrorResponseDTO;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleMemberNotFound(RecordNotFoundException ex){

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(ex.getMessage()) //I am getting the message from the cusom exception class
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidArgument(MethodArgumentNotValidException ex){

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(ex.getFieldError().getDefaultMessage())//I am getting the message from the RequestDto classc
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<ErrorResponseDTO> handleRequestNotPermitted(RequestNotPermitted ex){

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(ex.getMessage())//I am getting the message from the Resilience4J class
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .build();

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.TOO_MANY_REQUESTS);

    }
}