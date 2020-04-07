package cn.lemon.dao;

import cn.lemon.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-06 18:17
 */
public interface CourseDao extends JpaRepository<Course,Integer>, JpaSpecificationExecutor<Course> {
    /**
     * 查询所有课程平均分，最高，最低分
     * @return
     */
    @Query(value = "SELECT c.course_name,AVG(sc.scores) avgscore,MAX(sc.scores) maxscore,MIN(sc.scores) minscore,sc.score_date  FROM course c LEFT JOIN score sc ON c.course_id= sc.course_id GROUP BY c.course_name,sc.score_date",nativeQuery = true)
    List<Object[]> getAllCourseScore();
}
