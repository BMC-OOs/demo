package cn.lemon.controller;

import cn.lemon.constrant.CommonConstrants;
import cn.lemon.dto.AllStuScoreDTO;
import cn.lemon.dto.StuByNameScoreDTO;
import cn.lemon.service.StudentService;
import com.nhsoft.provider.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @date 2020-04-06 22:59
 */
@Slf4j
@RestController
@Api(tags = "学生查询")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);
    @ApiOperation(value = "查询所有学生成绩")
    @RequestMapping("nhsoft.demo.student.getallstuscore")
    public Response getAllStuScore(@RequestParam(value = "current_Page",defaultValue = CommonConstrants.CURRENT_PAGE) Integer current_Page,
                                   @RequestParam(value = "page_Size",defaultValue = CommonConstrants.PAGE_SIZE) Integer page_Size){
        List<AllStuScoreDTO> list = null;
        try {
             list = studentService.findAllStudentScore( current_Page ,page_Size);
            return Response.data(list);
        }catch (Exception e){
            logger.error("发生异常,异常信息：{}",e.getMessage());
        }
        return Response.data(list);
    }
    @ApiOperation(value = "学生查询自己的成绩")
    @RequestMapping("nhsoft.demo.student.getstuscorebyname")
    public Response getStuScoreByName(@RequestParam(value = "name") String name){
        List<StuByNameScoreDTO> list = null;
        try {
            list = studentService.findStuScoreByName(name);
            return Response.data(list);
        }catch (Exception e){
            logger.error("发生异常，异常信息：{}",e.getMessage());
        }
            return Response.data(list);
    }

}
