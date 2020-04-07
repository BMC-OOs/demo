package cn.lemon.dto;

import lombok.Data;

import java.sql.Date;

/**
 * @author BMC
 * @date 2020-04-06 19:24
 */
@Data
public class StudentDTO {
    /**
     * 学生姓名
     */
    private String stuName;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 分数
     */
    private Integer scores;
    /**
     * 日期
     */
    private Date scoreDate;

    public StudentDTO(String stuName, String courseName, Integer scores, Date scoreDate) {
        this.stuName = stuName;
        this.courseName = courseName;
        this.scores = scores;
        this.scoreDate = scoreDate;
    }
}
