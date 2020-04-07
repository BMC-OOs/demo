package cn.bmc.serviceimpl;

import cn.bmc.dao.TeacherDao;
import cn.bmc.dto.TeacherDTO;
import cn.bmc.model.Teacher;
import cn.bmc.service.TeacherService;
import cn.bmc.utils.CastEntityUtil;
import cn.bmc.utils.PageList;
import com.nhsoft.provider.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-07 0:07
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Response<List<TeacherDTO>> getTeacherScoreByName(String name, Integer page_Size, Integer current_Page) {
        List<Object[]> objectList = teacherDao.getTeacherScoreByName(name);
        try {
            List<TeacherDTO> list = CastEntityUtil.castEntity(objectList, TeacherDTO.class);
            List<TeacherDTO> pageList = (List<TeacherDTO>) PageList.pageBySubList(list, page_Size, current_Page);
            return Response.data(pageList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.empty();
    }

    @Override
    public Response<List<TeacherDTO>> getAllTeacherScore() {
        List<Object[]> objectList = teacherDao.getAllTeacherScore();
        try {
            List<TeacherDTO> list = CastEntityUtil.castEntity(objectList, TeacherDTO.class);
            return Response.data(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.empty();
    }

    @Override
    public int getTeacher(Integer id) {
        final String POSITION = "主任";
        Teacher teacher = teacherDao.getOne(id);
        if (POSITION.equals(teacher.getTeachPosition())){
            return 1;
        }
        return 0;
    }
}
