package com.amigoscode.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;

    public StudentService(StudentDataAccessService studentDataAccessService) {
        this.studentDataAccessService = studentDataAccessService;
    }

    public List<Student> getAllStudents(){
        return studentDataAccessService.selectAllStudents();
    }

    void addNewStudent(Student student) {
        addNewStudent(null,student);
    }
    void addNewStudent(UUID studentId, Student student) {
        UUID newStudentID= Optional.ofNullable(studentId).orElse(UUID.randomUUID());
        // TODO : VERIFY THAT EMAIL IS NOT TAKEN
        studentDataAccessService.insertStudent(newStudentID,student);
    }

}
