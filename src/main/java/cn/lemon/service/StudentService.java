package cn.lemon.service;

import cn.lemon.dto.AllStuScoreDTO;
import cn.lemon.dto.StuByNameScoreDTO;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-06 19:17
 */
public interface StudentService {
    /**
     * 学生每年学科平均分，最高，最低分
     * @param page_Size
     * @param current_Page
     * @return
     */
    List<AllStuScoreDTO> findAllStudentScore(Integer page_Size, Integer current_Page);

    /**
     * 学生查询自己每年学科各科成绩
     * @param name
     * @return
     */
    List<StuByNameScoreDTO>  findStuScoreByName(String name);
}
