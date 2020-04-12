package cn.lemon.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
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
@ApiModel("教师类")
public class Teacher implements Serializable {
    /**
     * 教师id
     */
    @ApiModelProperty("教师id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teachId;
    /**
     * 教师姓名
     */
    @ApiModelProperty("教师姓名")
    @Column(name = "teacher_name")
    private String teachName;
    /**
     * 教师职位
     */
    @ApiModelProperty("教师职位")
    @Column(name = "teacher_position")
    private String teachPosition;
    /**
     * 课程
     */
    @ApiModelProperty("关联关系表")
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<Score> teacherScore = new ArrayList<>();


}
