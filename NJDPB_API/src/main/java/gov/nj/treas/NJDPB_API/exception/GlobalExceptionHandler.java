package gov.nj.treas.NJDPB_API.exception;


import gov.nj.treas.NJDPB_API.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleMemberNotFound(RecordNotFoundException ex){

        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .message(ex.getMessage()) //I am getting the message from the cusom exception class
                .build();

        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}