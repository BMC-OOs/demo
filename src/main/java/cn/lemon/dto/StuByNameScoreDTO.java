package cn.lemon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author BMC
 * @date 2020-04-12 15:16
 */
@Data
@AllArgsConstructor
@ApiModel
public class StuByNameScoreDTO {
    /**
     * 学生姓名
     */
    @ApiModelProperty("学生名")
    private String stuName;
    /**
     * 课程名
     */
    @ApiModelProperty("课程名")
    private String courseName;
    /**
     * 分数
     */
    @ApiModelProperty("分数")
    private Integer scores;
    /**
     * 日期
     */
    @ApiModelProperty("日期")
    private Date date;
}
