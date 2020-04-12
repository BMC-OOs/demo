package cn.lemon.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生类
 * @author ：
 * @date : 2020-04-01 20:10
 */
@ApiModel("学生类")
@Data
@Entity
@Table(name = "student")
public class Student implements Serializable {
    /**
     * 学生id
     */
    @ApiModelProperty("学生id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private int stuId;
    /**
     * 学生姓名
     */
    @ApiModelProperty("学生姓名")
    @Column(name = "stu_name")
    private String stuName;
    /**
     * 学生年龄
     */
    @ApiModelProperty("学生年龄")
    @Column(name = "stu_age")
    private int stuAge;
    /**
     * 分数
     */
    @ApiModelProperty("关联关系表")
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    List<Score> stuScores = new ArrayList<>();


}
