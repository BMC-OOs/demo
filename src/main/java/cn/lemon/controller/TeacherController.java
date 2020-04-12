package cn.lemon.controller;

import cn.lemon.constrant.CommonConstrants;
import cn.lemon.dto.AllTeachScoreDTO;
import cn.lemon.dto.TeachByNameScoreDTO;
import cn.lemon.service.TeacherService;
import com.nhsoft.provider.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author BMC
 * @date 2020-04-12 14:29
 */
@RestController
@Api(tags = "教师查询")
@Slf4j
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    private final static Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @ApiOperation(value = "查询所有教师的学科成绩")
    @RequestMapping("nhsoft.demo.teacher.findteacher")
    public Response findAllTeacherScore(@Param(value = "id") Integer id,
                                        @RequestParam(value = "current_Page", defaultValue = CommonConstrants.CURRENT_PAGE) Integer current_Page,
                                        @RequestParam(value = "page_Size", defaultValue = CommonConstrants.PAGE_SIZE) Integer page_Size){
        Boolean permission = teacherService.isPermission(id);
        List<AllTeachScoreDTO> list = null;
        if (permission){
            try {
                list = teacherService.findAllTeacherScore( current_Page, page_Size);
                return Response.data(list);
            }catch (Exception e){
                logger.error("发生异常,异常信息：{}",e.getMessage());
            }
        }
        return Response.data(list);
    }
    @RequestMapping("nhsoft.demo.teacher.findteacherscorebyname")
    @ApiOperation("教师查询本人学科成绩")
    public Response findTeacherScoreByName(String name){
        List<TeachByNameScoreDTO> list = null;
        try {
            list = teacherService.findTeacherScoreByName(name);
            return Response.data(list);
        }catch (Exception e){
            logger.error("发生异常,异常信息：{}",e.getMessage());
        }
        return Response.data(list);
    }
}
