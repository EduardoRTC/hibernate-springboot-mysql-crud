package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    //definir atributos para o entity maneger

    private EntityManager entityManager;

    //Injetar o entity manager com constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implementar o save();
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //criar query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);


        //retornar resultados

        return theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastname=:theData", Student.class);
        theQuery.setParameter("theData", theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);

        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }

}
