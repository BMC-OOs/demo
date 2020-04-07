package cn.bmc.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * 分数类
 * @author ：
 * @date : 2020-04-01 20:45
 */
@Data
@Entity
@Table(name = "score")
public class Score {
    /**
     * 课程id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer scoreId;
    /**
     * 分数
     */
    @Column(name = "scores")
    private Integer scores;
    /**
     * 日期
     */
    @Column(name = "score_date")
    private Date ScoreDate;

    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "stu_id",referencedColumnName = "stu_id")
    private Student student;

    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id",referencedColumnName = "course_id")
    private Course course;

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", scores=" + scores +
                ", ScoreDate=" + ScoreDate +
                ", course=" + course +
                '}';
    }
}