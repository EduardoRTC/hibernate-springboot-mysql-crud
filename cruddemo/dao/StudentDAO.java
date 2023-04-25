package com.example.cruddemo.dao;
import com.example.cruddemo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();

}
