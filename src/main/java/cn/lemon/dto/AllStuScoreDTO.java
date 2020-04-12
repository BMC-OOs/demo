package cn.lemon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


/**
 * @author BMC
 * @date 2020-04-06 19:24
 */
@Data
@AllArgsConstructor
@ApiModel
public class AllStuScoreDTO {
    /**
     * 学生姓名
     */
    @ApiModelProperty("学生姓名")
    private String stuName;
    /**
     * 课程名
     */
    @ApiModelProperty("课程名")
    private String courseName;
    /**
     * 平均分
     */
    @ApiModelProperty("平均分")
    private Double avgScore;
    /**
     * 最大分
     */
    @ApiModelProperty("最大分")
    private Integer maxScore;
    /**
     * 最小分
     */
    @ApiModelProperty("最小分")
    private Integer minScore;
    /**
     * 日期
     */
    @ApiModelProperty("时间")
    private Date scoreDate;


}
