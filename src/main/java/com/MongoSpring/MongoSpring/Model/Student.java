package com.MongoSpring.MongoSpring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document   //This is going to our table name i.e. Student
@Data       //From lombok, Reduces the uses of having getters, setters, initializing the values.
@NoArgsConstructor
@AllArgsConstructor
//The @NoArgsConstructor and @AllArgsConstructor annotations can be used to save time and effort when writing Java code.
//By using these annotations, you do not have to write the constructors yourself.
//The Lombok library will generate the constructors for you at compile time.

public class Student {



    @Id    //Defines the primary key
    private Integer rno;


    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }
    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    private Integer age;

    private Integer grade;
}
