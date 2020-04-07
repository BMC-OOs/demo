package cn.bmc.service;

import cn.bmc.dao.StudentDao;
import cn.bmc.dto.StudentDTO;
import com.nhsoft.provider.common.Response;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-06 19:17
 */
public interface StudentService {
    /**
     * 学生查询自己平均分，最高，最低分
     * @param name
     * @return
     */
    Response<List<StudentDTO>> findStudentScoreByName(String name, Integer page_Size, Integer current_Page);
}
