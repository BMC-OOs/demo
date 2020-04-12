package cn.lemon.repository;

import cn.lemon.dto.AllStuScoreDTO;
import cn.lemon.dto.StuByNameScoreDTO;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-12 18:06
 */
public interface StudentScoreRepository {
    /**
     * 学生学年学科平均分，最高，最低分
     * @param page_Size
     * @param current_Page
     * @return
     */
     List<AllStuScoreDTO> findAllStudentScore(Integer current_Page, Integer page_Size);
    /**
     *学生查询本人每学年各学科成绩
     * @param name
     * @return
     */
     List<StuByNameScoreDTO> findStudentScoreByName(String name);
}
