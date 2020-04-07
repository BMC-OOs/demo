package cn.bmc.controller;

import cn.bmc.dao.TeacherDao;
import cn.bmc.dto.TeacherDTO;
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
 * @date 2020-04-07 0:10
 */
@Slf4j
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping("nhsoft.demo.teacher.getteacherscore")
    public Response getTeacherScore(@RequestParam("name") String name,@RequestParam("page_Size") Integer page_Size,@RequestParam("current_Page") Integer current_Page){
        try {
            return teacherService.getTeacherScoreByName(name,page_Size,current_Page);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("发生异常,异常信息：{}",e.getMessage());
        }
        return Response.empty();

    }
    @RequestMapping("nhsoft.demo.teacher.getallteacherscore")
    public Response getAllTeacherScore(@RequestParam("id") Integer id){
        try {
            // 获取教师职位
            int permission = teacherService.getTeacher(id);
            // 判断权限
            if (permission == 1) {
                return teacherService.getAllTeacherScore();
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("发生异常,异常信息：{}",e.getMessage());

        }
        return  Response.error(500,"您没有权限");
    }
}
