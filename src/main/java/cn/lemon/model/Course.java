package cn.lemon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程类
 * @author ：
 * @date : 2020-04-01 20:24
 */
@Data
@Entity
@Table(name = "course")
public class Course {
    /**
     * 课程id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;
    /**
     * 课程名
     */
    @Column(name="course_name")
    private String courseName;
    /**
     * 课程
     */
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Score> courScores = new ArrayList<>();
    /**
     * 教师
     */
    @ManyToMany(mappedBy = "teachCourse")
    private List<Teacher> teacherList = new ArrayList<>();

}
