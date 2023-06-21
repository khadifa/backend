package com.example.Aplication.myAPI;

import com.example.Aplication.model.Program;
import com.example.Aplication.model.University;
import com.example.Aplication.repository.ProgramRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Program")


public class ProgramAPI {
    @Autowired
    private ProgramRepo programRepo;

    @GetMapping("/allPrograms")
    public ResponseEntity<?>getProgram(){
        try {
            List<Program>programList = programRepo.findAll();
            if (programList.isEmpty()){
                return new ResponseEntity<>("No Data Found", HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<>(programList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
        }



    }
    @GetMapping("/byid{ProId}")

    public ResponseEntity<?>getByid(@PathVariable int ProId){
        try {
            Optional<Program>optionalProgram = programRepo.findById(ProId);
            if (optionalProgram.isPresent()){
                return new ResponseEntity<>(optionalProgram,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No Data Found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Server Down",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete{ProId}")
    public ResponseEntity<?>delete(@PathVariable int ProId){
        try {
            programRepo.deleteById(ProId);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/addprogram")
    public ResponseEntity<?>addprogram(@RequestBody Program program){
        try {
            Program program1 = programRepo.save(program);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updates{ProId}")
    public ResponseEntity<?>updates(@PathVariable int ProId,@RequestBody Program program ) {
        try {
            if (programRepo.findById(ProId).isPresent()) {
                Program program1 = programRepo.save(program);

                program1.setProId(program.getProId());
                program1.setProName(program.getProName());

                Program updatesProgram = programRepo.save(program1);
                return new ResponseEntity<>("accepted", HttpStatus.ACCEPTED);

            } else {
                return new ResponseEntity<>("not accepted", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>("server down", HttpStatus.NOT_FOUND);
        }

    }

}
