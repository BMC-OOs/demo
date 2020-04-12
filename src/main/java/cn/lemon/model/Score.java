package cn.lemon.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * 分数类
 * @author ：
 * @date : 2020-04-01 20:45
 */
@Data
@Entity
@Table(name = "score")
@ApiModel("分数类")
public class Score implements Serializable {

    /**
     * 分数
     */
    @ApiModelProperty("分数")
    @Column(name = "scores")
    private Integer scores;
    /**
     * 日期
     */
    @ApiModelProperty("时间")
    @Column(name = "score_date")
    private Date scoreDate;
    /**
     * 学生
     */
    @ApiModelProperty("学生")
    @Id
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "stu_id",referencedColumnName = "stu_id")
    private Student student;
    /**
     * 课程
     */
    @ApiModelProperty("课程")
    @Id
    @ManyToOne(targetEntity = Course.class)
    @JoinColumn(name = "course_id",referencedColumnName = "course_id")
    private Course course;
    /**
     * 教师
     */
    @ApiModelProperty("教师")
    @Id
    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacher_id")
    private Teacher teacher;


}
