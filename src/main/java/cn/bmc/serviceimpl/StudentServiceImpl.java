package cn.bmc.serviceimpl;

import cn.bmc.dao.StudentDao;
import cn.bmc.dto.StudentDTO;
import cn.bmc.service.StudentService;
import cn.bmc.utils.CastEntityUtil;
import cn.bmc.utils.PageList;
import com.nhsoft.provider.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-06 22:14
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Response<List<StudentDTO>> findStudentScoreByName(String name, Integer page_Size, Integer current_Page) {
        List<Object[]> objectList = this.studentDao.findStudentScoreByName(name);
        try {
            List<StudentDTO> list = CastEntityUtil.castEntity(objectList, StudentDTO.class);
            List<StudentDTO> pageList = (List<StudentDTO>) PageList.pageBySubList(list, page_Size, current_Page);
            return Response.data(pageList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.empty();
    }
}
