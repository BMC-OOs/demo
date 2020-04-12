package cn.lemon.model;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
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
@ApiModel("课程类")
public class Course implements Serializable {
    /**
     * 课程id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    @ApiModelProperty("课程id")
    private Integer courseId;
    /**
     * 课程名
     */

    @Column(name="course_name")
    @ApiModelProperty("课程名")
    private String courseName;
    /**
     * 课程
     */
    @ApiModelProperty("关联关系表")
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Score> courScores = new ArrayList<>();



}
