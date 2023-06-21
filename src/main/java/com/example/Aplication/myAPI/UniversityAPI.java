package com.example.Aplication.myAPI;

import com.example.Aplication.model.University;
import com.example.Aplication.repository.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/University")



public class UniversityAPI {
    @Autowired
    private UniversityRepo universityRepo;

    @GetMapping("/allUniversity")
    public ResponseEntity<?>getUniversity(){
        try {
            List<University>universityList = universityRepo.findAll();
            if (universityList.isEmpty()){
                return new ResponseEntity<>("No Data Found", HttpStatus.NOT_FOUND);


            }else{
                return new ResponseEntity<>(universityList,HttpStatus.OK);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Network Error",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/byId{UniId}")
    public ResponseEntity<?>getByid(@PathVariable int UniId){
        try {
            Optional<University>optionalUniversity = universityRepo.findById(UniId);
            if (optionalUniversity.isPresent()){
                return new ResponseEntity<>(optionalUniversity,HttpStatus.OK);
            }else {
                return new ResponseEntity<>("No Data Found",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Server Down",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete{UniId}")
    public ResponseEntity<?>delete(@PathVariable int UniId){
        try {
            universityRepo.deleteById(UniId);
            return new ResponseEntity<>("Succesefully Deleted",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Server Down",HttpStatus.NOT_FOUND);
        }

    }
  @PostMapping("/add")
    public ResponseEntity<?>adduniversity(@RequestBody University university){
        try {
            University university1 = universityRepo.save(university);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("not successefully",HttpStatus.BAD_REQUEST);
        }
  }
  @PutMapping("/updates{UniId}")
    public ResponseEntity<?>updates(@PathVariable int UniId,@RequestBody University university ){
        try {
            if (universityRepo.findById(UniId).isPresent()){
                University university1 = universityRepo.save(university);

                university1.setUniId(university.getUniId());
                university1.setUniName(university.getUniName());
                university1.setLocation(university.getLocation());
                university1.setEmail(university.getEmail());
                University updatesUniversity = universityRepo.save(university1);
                    return new ResponseEntity<>("accepted",HttpStatus.ACCEPTED);

                }else {
                return new ResponseEntity<>("not accepted",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("server down",HttpStatus.NOT_FOUND);
        }
  }




}
