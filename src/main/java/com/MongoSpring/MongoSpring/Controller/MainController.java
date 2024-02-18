package com.MongoSpring.MongoSpring.Controller;

import com.MongoSpring.MongoSpring.Model.Student;
import com.MongoSpring.MongoSpring.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired   //basically it is used to make the connection between different classes.
                 //We can use object of StudentRepo class in this MainController class.
    StudentRepo studentRepo;
//    When the @Autowired annotation is used on the studentRepo field in the MainController class,
//    Spring will automatically inject an instance of the StudentRepo class into the MainController class.

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student)  //We have requested the data to get fetch from Postman API to save it in 'student' variable to use it later.

    //All the student data created is stored is 'student' variable.
    {
        //Now, we have created a repository StudentRepo to save the data in it.
        //We will now save the fetched data( which you created from Postman Platform) in StudentRepo repository.
        this.student = student;   //This is to save data in 'student' variable to use it for GetMapping later.
        studentRepo.save(student);  //This is to save data in student repository to save it in MongoDB
        return "Added Student with id :"+ student.getRno();
    }

    Student student;   //All the student data created is stored is 'student' variable.
    @GetMapping("/getStudent")
    public Student readStudentData(Integer rno)
    {
        return student;
    }


    @PutMapping("/updateStudent")
    public String updateStudentdata(@RequestBody Student student) //We have requested the data to get fetch from Postman API to save it in 'student' variable to use it later.
    {
        // Assuming the student object contains the updated data including the ID
        // Retrieve the student by ID from the database
        Student existingStudent = studentRepo.findById(student.getRno()).orElse(null);

        //Check if student exists
        if (existingStudent != null){
            //Update the existing student with new data
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setAge(student.getAge());
            existingStudent.setGrade(student.getGrade());


            this.student=existingStudent;
            //Save the updated student back to the database mmongoDB
            studentRepo.save(existingStudent);

            return "Updated the student data of Id :"+ student.getRno();
        }
        else {
            return "Student not found. Update failed!";
        }

    }

    @DeleteMapping("/deleteStudent/{rno}")
    public ResponseEntity<String> removeStudentdata(@PathVariable Integer rno) {
        Student student = studentRepo.findById(rno).orElse(null);
        if (student == null) {
            return new ResponseEntity<>("Student with roll number " + rno + " does not exist.", HttpStatus.NOT_FOUND);
        }
        studentRepo.delete(student);
        return new ResponseEntity<>("Student with roll number " + rno + " has been deleted.", HttpStatus.OK);
    }

}


