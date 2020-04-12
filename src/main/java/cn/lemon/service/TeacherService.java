package cn.lemon.service;

import cn.lemon.dto.AllTeachScoreDTO;
import cn.lemon.dto.TeachByNameScoreDTO;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-12 14:26
 */
public interface TeacherService {
    /**
     * 教导主任查询教师各科平均成绩，最高分，最低分
     * @param current_Page
     * @param page_Size
     * @return
     */
    List<AllTeachScoreDTO> findAllTeacherScore(Integer current_Page, Integer page_Size);

    /**
     * 查询老师是否是教导主任
     * @param id
     * @return
     */
    Boolean isPermission(Integer id);

    /**
     * 教师查询本人每学年，学科平均成绩，最高分，最低分
     * @param name
     * @return
     */
    List<TeachByNameScoreDTO> findTeacherScoreByName(String name);
}
