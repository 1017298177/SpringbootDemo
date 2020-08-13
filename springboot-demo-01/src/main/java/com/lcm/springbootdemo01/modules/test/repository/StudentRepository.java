package com.lcm.springbootdemo01.modules.test.repository;

import com.lcm.springbootdemo01.modules.test.entity.Clazz;
import com.lcm.springbootdemo01.modules.test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description StudentRepository
 * @Author HymanHu
 * @Date 2020/8/12 15:31
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByStudentName(String studentName);

    List<Student> findByStudentNameLike(String studentName);

    List<Student> findTop2ByStudentNameLike(String studentName);


//    @Query(value = "select s from Student s where s.studentName = ?1 and s.studentCard.cardId = ?2")
//    @Query(value = "select s from Student s where s.studentName = :studentName " +
//            "and s.studentCard.cardId = :cardId")
    @Query(nativeQuery = true,
            value = "select * from h_student where student_name = :studentName " +
                    "and card_id = :cardId")
    List<Student> getStudentsByParams(String studentName, int cardId);
}
