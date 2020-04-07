package cn.bmc.service;

import cn.bmc.dto.CourseDTO;
import com.nhsoft.provider.common.Response;


import java.util.List;

/**
 * @author BMC
 * @date 2020-04-07 0:19
 */
public interface CourseService {
    /**
     * 查询所有课程平均分，最高，最低分
     *
     * @return
     */
    Response<List<CourseDTO>> getAllCourseScore();
}
