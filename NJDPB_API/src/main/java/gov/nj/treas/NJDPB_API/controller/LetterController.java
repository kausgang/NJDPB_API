package gov.nj.treas.NJDPB_API.controller;



import gov.nj.treas.NJDPB_API.dto.LetterRequestDTO;
import gov.nj.treas.NJDPB_API.dto.LetterResponseDTO;
import gov.nj.treas.NJDPB_API.service.impl.LetterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pur")
@RequiredArgsConstructor
public class LetterController {

    private final LetterServiceImpl letterServiceImplimentation;
//    private final LetterRequestDTO letterRequestDTO;

//    @Autowired
//    private final LetterMapper letterMapper;
    private LetterRequestDTO letterRequestDTO;




    @GetMapping("/ssn/{ssn}")
    public ResponseEntity<List<LetterResponseDTO>> getLettersBySsn(@PathVariable String ssn) {

//        long parsedSsn;
//        try {
//            parsedSsn = Long.parseLong(ssn);
//        } catch (NumberFormatException e) {
//            // Handle the error, maybe return a custom error response
//            throw new IllegalArgumentException("Invalid ID format");
//        }

        letterRequestDTO = new LetterRequestDTO(ssn);


        List<LetterResponseDTO> letters = letterServiceImplimentation.getLetterBySSN(letterRequestDTO);
        return ResponseEntity.ok(letters);
    }

    @PostMapping("/ssn")
//    public ResponseEntity<List<LetterResponseDTO>> postLettersBySsn(@RequestBody LetterRequestDTO letterRequestDTO){
    public ResponseEntity<?> postLettersBySsn(@RequestBody LetterRequestDTO letterRequestDTO){

        try{
            List<LetterResponseDTO> letters = letterServiceImplimentation.getLetterBySSN(letterRequestDTO);

//            this also works
//            return ResponseEntity.ok(letters);
            return new ResponseEntity<>(letters, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }



    }
}
