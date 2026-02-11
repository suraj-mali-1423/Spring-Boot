package com.Surajmali.PostgressSQL.repository;

import com.Surajmali.PostgressSQL.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByEmail(String Name);

    Student findByName(String Name);

    Student findByNameAndGender(String Name, String Gender);

    Student findByEmailOrMobilenumbe(String Email, String number);

    List<Student> findByGenderNot(String Gender);

    List<Student> findByRollNumberGreaterThan(long l);

    List<Student> findByRollNumberLessThan(long l);

    List<Student> findByMobilenumbeGreaterThanEqual(long l);

    List<Student> findByMobilenumbeLessThanEqual(long l);

    List<Student> findByNameContaining(String patil);

    List<Student> findByGenderIn(List<String> male);

    List<Student> findByNameStartingWith(String rahul);

    List<Student> findByNameEndingWith(String shinde);

    List<Student> findByEmailLike(String mail);

    List<Student> findByOrderByRollNumberAsc();

    Long countByGender(String male);

    Student deleteByName(String rohitJadhav);

    List<Student> findByEmailNotNull();

    List<Student> findByEmailIsNull();
}
