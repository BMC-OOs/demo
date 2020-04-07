package cn.bmc.dao;

import cn.bmc.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-06 18:18
 */
public interface TeacherDao extends JpaRepository<Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
    /**
     * 教师查询自己平均分，最高分，最低分
     * @param name
     * @return
     */
    @Query(value = "SELECT t.teacher_name,c.course_name,AVG(sc.scores) avgscore,MAX(sc.scores) maxscore,MIN(sc.scores) minscore,sc.score_date FROM teacher t LEFT JOIN teacher_course tc  ON t.teacher_id=tc.teacher_id LEFT JOIN course  c ON tc.course_id= c.course_id LEFT JOIN score sc ON sc.course_id= c.course_id WHERE t.teacher_name=? GROUP BY c.course_name ,sc.score_date",nativeQuery = true)
    List<Object[]> getTeacherScoreByName(String name);

    /**
     * 教师-学科平均成绩，最高分，最低分
     * @return
     */
    @Query(value = "SELECT t.teacher_name,c.course_name,AVG(sc.scores) avgscore,MAX(sc.scores) maxscore,MIN(sc.scores) minscore,sc.score_date FROM teacher t LEFT JOIN teacher_course tc  ON t.teacher_id=tc.teacher_id LEFT JOIN course  c ON tc.course_id= c.course_id LEFT JOIN score sc ON sc.course_id= c.course_id  GROUP BY t.teacher_name ,c.course_name,sc.score_date",nativeQuery = true)
    List<Object[]> getAllTeacherScore();


}
