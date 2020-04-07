package cn.bmc.service;

import cn.bmc.dto.TeacherDTO;
import cn.bmc.model.Teacher;
import com.nhsoft.provider.common.Response;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-07 0:06
 */
public interface TeacherService {
    /**
     * 教师查询自己平均分，最高分，最低分
     * @param name
     * @return
     */
    Response<List<TeacherDTO>> getTeacherScoreByName(String name, Integer page_Size, Integer current_Page);

    /**
     * 教师-学科平均成绩，最高分，最低分
     * @return
     */
    Response<List<TeacherDTO>> getAllTeacherScore();

    /**
     * 获取教师信息
     * @param id
     * @return
     */
    int getTeacher(Integer id);

}
