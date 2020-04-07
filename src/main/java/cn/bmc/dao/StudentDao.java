package cn.bmc.dao;

import cn.bmc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-06 18:18
 */
public interface StudentDao extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
    /**
     * 学生查询自己平均分，最高，最低分
     * @param name
     * @return
     */
    @Query(value = "SELECT  s.stu_name,c.course_name,sc.scores,sc.score_date FROM student s LEFT JOIN score sc ON s.stu_id=sc.stu_id LEFT JOIN course c ON sc.course_id= c.course_id WHERE s.stu_name = ?",nativeQuery = true)
    List<Object[] > findStudentScoreByName(String name);
}
