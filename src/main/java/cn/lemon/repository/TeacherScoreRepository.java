package cn.lemon.repository;

import cn.lemon.dto.AllTeachScoreDTO;
import cn.lemon.dto.TeachByNameScoreDTO;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-12 18:06
 */
public interface TeacherScoreRepository {
    /**
     * 查询教师每学年各科成绩
     * @param current_Page
     * @param page_Size
     * @return
     */
    public List<AllTeachScoreDTO> findAllTeacherScore(Integer current_Page, Integer page_Size);

    /**
     * 教师查询本人每学年，学科平均成绩，最高分，最低分
     * @param name
     * @return
     */
    public List<TeachByNameScoreDTO> findTeacherScoreByName(String name);
}
