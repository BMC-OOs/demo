package cn.bmc.controller;

import cn.bmc.dto.StudentDTO;
import cn.bmc.service.StudentService;
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
 * @date 2020-04-06 22:59
 */
@Slf4j
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping("nhsoft.demo.student.getscore")
    public Response getScore(@RequestParam("name") String name,@RequestParam("page_Size") Integer page_Size,@RequestParam("current_Page") Integer current_Page){
        try {
            return studentService.findStudentScoreByName(name,page_Size,current_Page);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("发生异常,异常信息：{}",e.getMessage());
        }
        return Response.empty();
    }
}
