package com.pragra.cruddemoapp.repo;

import com.pragra.cruddemoapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    // @Autowired is optional in case of 1 constructor
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Student - the name of entity , not the database table.
        TypedQuery<Student> query = entityManager.createQuery("From Student order by firstName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("From Student WHERE lastName= :theData", Student.class);

        query.setParameter("theData", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        Student merge = entityManager.merge(student);


    }

    @Override
    @Transactional
    public void delete(int id) {
        // retreive the student
        Student student = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {
       return entityManager.createQuery("DELETE from Student").executeUpdate();
    }
}
