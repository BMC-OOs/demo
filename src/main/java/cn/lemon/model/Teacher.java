package cn.lemon.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 教师类
 * @author ：
 * @date : 2020-04-01 20:12
 */
@Data
@Entity
@Table(name = "teacher")
public class Teacher {
    /**
     * 教师id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teachId;
    /**
     * 教师姓名
     */
    @Column(name = "teacher_name")
    private String teachName;
    /**
     * 教师职位
     */
    @Column(name = "teacher_position")
    private String teachPosition;

    @ManyToMany(targetEntity = Course.class,cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_course",
            joinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "course_id")}
    )
    private List<Course> teachCourse = new ArrayList<>();


}
