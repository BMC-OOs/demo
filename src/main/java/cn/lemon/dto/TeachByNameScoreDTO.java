package cn.lemon.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author BMC
 * @date 2020-04-12 16:22
 */
@Data
@AllArgsConstructor
@ApiModel
public class TeachByNameScoreDTO {
    /**
     * 教师名
     */
    @ApiModelProperty("教师名")
    private String teachName;
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
     * 最高分
     */
    @ApiModelProperty("最高分")
    private Integer maxScore;
    /**
     * 最低分
     */
    @ApiModelProperty("最低分")
    private Integer minScore;
    /**
     * 日期
     */
    @ApiModelProperty("日期")
    private Date date;
}
