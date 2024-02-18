package com.MongoSpring.MongoSpring.Repository;

import com.MongoSpring.MongoSpring.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
//This StudentRepo repository corresponds to Student.java class
public interface StudentRepo extends MongoRepository<Student,Integer> {
}
