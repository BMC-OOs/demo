package cn.lemon.serviceimpl;

import cn.lemon.dao.CourseDao;
import cn.lemon.dto.CourseDTO;
import cn.lemon.service.CourseService;
import cn.lemon.utils.CastEntityUtil;
import com.nhsoft.provider.common.Response;
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
