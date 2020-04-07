package cn.bmc.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author BMC
 * @date 2020-04-07 0:18
 */
@Data
public class CourseDTO {
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 平均分
     */
    private BigDecimal avgScore;
    /**
     * 最大分
     */
    private Integer maxScore;
    /**
     * 最小分
     */
    private Integer minScore;
    /**
     * 日期
     */
    private Date date;

    public CourseDTO(String courseName, BigDecimal avgScore, Integer maxScore, Integer minScore, Date date) {
        this.courseName = courseName;
        this.avgScore = avgScore;
        this.maxScore = maxScore;
        this.minScore = minScore;
        this.date = date;
    }
}
