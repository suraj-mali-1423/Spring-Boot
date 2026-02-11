package com.Surajmali.PostgressSQL;

import com.Surajmali.PostgressSQL.entity.Student;
import com.Surajmali.PostgressSQL.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.Name;
import java.util.List;

@SpringBootTest
public class getMethods {

    @Autowired
    private StudentRepository studentRepository;

    // 1️⃣ Get All Students
    @Test
    public void testGetAllStudents() {
        List<Student> list = studentRepository.findAll();
        list.forEach(System.out::println);
    }

    // 2️⃣ Logical Methods (AND / OR)
    @Test
    public void testLogical(){

        // AND
        Student s1 = studentRepository.findByNameAndGender("Rohit Jadhav", "Female");
        System.out.println("AND Result: " + s1);

        // OR
        Student s2 = studentRepository.findByEmailOrMobilenumbe(
                "rahul.patil@gmail.com", "8459713413");
        System.out.println("OR Result: " + s2);
    }

    // 3️⃣ Comparison Methods
    @Test
    public void testComparison() {

        List<Student> s2 = studentRepository.findByGenderNot("Male");
        System.out.println("Not Equals: " + s2);

        List<Student> s3 = studentRepository.findByRollNumberGreaterThan(5L);
        System.out.println("Greater Than: " + s3);

        List<Student> s4 = studentRepository.findByRollNumberLessThan(7L);
        System.out.println("Less Than: " + s4);

        List<Student> s5 = studentRepository.findByMobilenumbeGreaterThanEqual(9654321098L);
        System.out.println("Greater Than Equal: " + s5);

        List<Student> s6 = studentRepository.findByMobilenumbeLessThanEqual(9543210987L);
        System.out.println("Less Than Equal: " + s6);

        List<Student> s7 = studentRepository.findByNameContaining("Patil");
        System.out.println("Containing: " + s7);

        List<Student> s8 = studentRepository.findByGenderIn(List.of("Male", "Female"));
        System.out.println("IN Query: " + s8);
    }

    // 4️⃣ LIKE Queries
    @Test
    public void LikeKeyword(){

        List<Student> s1 = studentRepository.findByNameContaining("Patil");
        System.out.println("Containing: " + s1);

        List<Student> s2 = studentRepository.findByNameStartingWith("Rahul");
        System.out.println("Starts With: " + s2);

        List<Student> s3 = studentRepository.findByNameEndingWith("Shinde");
        System.out.println("Ends With: " + s3);

        List<Student> s4 = studentRepository.findByEmailLike("%@gmail.com");
        System.out.println("LIKE Pattern: " + s4);
    }

    // 5️⃣ Sorting
    @Test
    public void SortingMethod(){
        List<Student> list = studentRepository.findByOrderByRollNumberAsc();
        System.out.println("Sorted List: " + list);
    }

    // 6️⃣ Count
    @Test
    public void CountMethod(){
        Long count = studentRepository.countByGender("Female");
        System.out.println("Total Females: " + count);
    }

    // 7️⃣ Delete
    @Test
    @Transactional
    public void DeleteMethods(){
        studentRepository.deleteByName("Rohit Jadhav");
        System.out.println("Deleted Successfully");
    }

    // 8 Null Check Methods
    @Test
    public  void  nullMethods(){

             // Find the Record Where the email are not null
            List<Student> l1 = studentRepository.findByEmailNotNull();
            System.out.println(l1);

            // Finf the Record Where the email are Null
            List<Student>l2  = studentRepository.findByEmailIsNull();
            System.out.println(l2);
    }
}
