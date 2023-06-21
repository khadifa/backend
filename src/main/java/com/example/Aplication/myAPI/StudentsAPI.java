package com.example.Aplication.myAPI;

import com.example.Aplication.model.Students;
import com.example.Aplication.repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")

public class StudentsAPI {
    @Autowired

    private StudentsRepo studentsRepo;


    @GetMapping("/allstudents")
    public ResponseEntity<?>getstudent(){
       try {
           List<Students>studentsList = studentsRepo.findAll();
           if (studentsList.isEmpty()){
               return new ResponseEntity<>("No data found", HttpStatus.NOT_FOUND);
           }else {
               return new ResponseEntity<>(studentsList,HttpStatus.OK);
           }
       }catch (Exception exception){
           return new ResponseEntity<>("Network Error",HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("/byid{Id}")
    public ResponseEntity<?>getByid(@PathVariable int Id){
        try {
            Optional<Students>optionalStudents = studentsRepo.findById(Id);
            if(optionalStudents.isPresent()){
                return new ResponseEntity<>(optionalStudents,HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No data found",HttpStatus.NOT_FOUND);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("System down",HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/add")
    public ResponseEntity<?> addstudents(@RequestBody Students students){
        try {
            Students students1 = studentsRepo.save(students);
            return new ResponseEntity<>("Inserted Succesefully",HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>("Not succesefully data inserted",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete{Id}")

    public ResponseEntity<?> delete(@PathVariable int Id){
     try {
         studentsRepo.deleteById(Id);
         return new ResponseEntity<>("Succesefully deleted",HttpStatus.OK);
     }catch (Exception exception){
         return new ResponseEntity<>("Server does not exixst",HttpStatus.BAD_REQUEST);
     }
    }
    @PutMapping("/updates{Id}")
    public ResponseEntity<?>updates(@PathVariable int Id,@RequestBody Students students){
        try {
            if (studentsRepo.findById(Id).isPresent()){
                Students students1 = studentsRepo.save(students);

                students1.setId(students.getId());
                students1.setName(students.getName());
                students1.setPhone(students.getPhone());
                students1.setEmail(students.getEmail());
                students1.setAddress(students.getAddress());
                Students updatesStudents = studentsRepo.save(students1);
                return new ResponseEntity<>("updated",HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity<>("not updated",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            return new ResponseEntity<>("Error",HttpStatus.BAD_GATEWAY);
        }
    }
}
