package cn.bmc.serviceimpl;

import cn.bmc.dao.CourseDao;
import cn.bmc.dto.CourseDTO;
import cn.bmc.service.CourseService;
import cn.bmc.utils.CastEntityUtil;
import cn.bmc.utils.PageList;
import com.nhsoft.provider.common.Response;
import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-07 0:20
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public Response<List<CourseDTO>> getAllCourseScore() {
        List<Object[]> objectList = courseDao.getAllCourseScore();
        try {
            List<CourseDTO> list = CastEntityUtil.castEntity(objectList, CourseDTO.class);
            return Response.data(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.empty();
    }
}
