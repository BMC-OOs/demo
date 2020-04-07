package cn.bmc.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author BMC
 * @date 2020-04-07 0:04
 */
@Data
public class TeacherDTO {
    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 平均分
     */
    private BigDecimal avgScore;
    /**
     * 最高分
     */
    private Integer maxScore;
    /**
     * 最低分
     */
    private Integer minScore;
    /**
     * 日期
     */
    private Date date;

    public TeacherDTO(String teacherName, String courseName, BigDecimal avgScore, Integer maxScore, Integer minScore, Date date) {
        this.teacherName = teacherName;
        this.courseName = courseName;
        this.avgScore = avgScore;
        this.maxScore = maxScore;
        this.minScore = minScore;
        this.date = date;
    }


}
