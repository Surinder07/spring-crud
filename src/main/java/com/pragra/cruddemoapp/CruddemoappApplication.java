package com.pragra.cruddemoapp;

import com.pragra.cruddemoapp.entity.Student;
import com.pragra.cruddemoapp.repo.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            //createStudent(studentDAO);x
            createMultipleStudent(studentDAO);
             //findStudentById(studentDAO);
            // queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
             //updateStudent(studentDAO);
           // deleteStudent(studentDAO);
            //deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students..");
        int numberOfStudents = studentDAO.deleteAll();
        System.out.println("Number of students deleted " + numberOfStudents);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        // retreive student by id

        int studentId = 1;
        Student student = studentDAO.findById(studentId);
        // delete the student
        studentDAO.delete(studentId);

        // dispaly student obj
        System.out.println("Student which is deleted : "+student);
    }

    private void updateStudent(StudentDAO studentDAO) {

        //retrieve student based on it
        int studentId = 1;
        System.out.println("getting student with id : " +studentId);
        Student studentToUpdate = studentDAO.findById(studentId);

        // change the first Name
        studentToUpdate.setLastName("Super");


        // update the student
        studentDAO.update(studentToUpdate);

        // display the student
        System.out.println(studentToUpdate);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        List<Student> byLastName = studentDAO.findByLastName("Singh");

        for (Student names : byLastName){
            System.out.println(names);
        }

    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> studentList = studentDAO.findAll();
        //System.out.println(studentList);

        for (Student tempStudent : studentList){
            System.out.println(tempStudent);
        }
    }

    private void findStudentById(StudentDAO studentDAO) {
        // create student
        System.out.println("Creating.. student");
        Student student = new Student("Surinder","Singh","surinder@gmail.com");

        // save the student
        System.out.println("saving student...");
        studentDAO.save(student);

        // find the student object
        Student retrivedStudent = studentDAO.findById(student.getId());

        // print the student object
        System.out.println(retrivedStudent);



    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        //creating 3 students
        System.out.println("Creating.. 3 students");
        Student student1 = new Student("Surinder","Singh","surinder@gmail.com");
        Student student2 = new Student("Sachin","Singh","saching@gmail.com");
        Student student3 = new Student("Rachna","Singh","rachna@gmail.com");

        // saving 3 students..
        System.out.println("Saving 3 students..");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create student
        System.out.println("Creating.. student");
        Student student = new Student("Surinder","Singh","surinder@gmail.com");

        // save the student
        System.out.println("saving student...");
        studentDAO.save(student);

        // get id of the student
        System.out.println("Get student id " + student.getId());
    }

}
