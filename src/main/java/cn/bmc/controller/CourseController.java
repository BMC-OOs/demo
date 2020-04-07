package cn.bmc.controller;

import cn.bmc.dto.CourseDTO;
import cn.bmc.service.CourseService;
import cn.bmc.service.TeacherService;
import com.nhsoft.provider.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-07 0:22
 */
@Slf4j
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;

    private final static Logger logger = LoggerFactory.getLogger(CourseController.class);

    @RequestMapping("nhsoft.demo.course.getallscore")
    public Response getAllScore(@RequestParam("id") Integer id){

        try {
            // 获取教师职位
            int permission = teacherService.getTeacher(id);
            // 判断权限
            if (permission == 1) {
                return courseService.getAllCourseScore();
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("发生异常,异常信息：{}",e.getMessage());
        }
        return Response.error(500,"您没有权限");
    }

}
