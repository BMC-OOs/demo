package cn.lemon.service.impl;

import cn.lemon.repository.impl.StudentScoreRepositoryImpl;
import cn.lemon.dto.AllStuScoreDTO;
import cn.lemon.dto.StuByNameScoreDTO;
import cn.lemon.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-06 22:14
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentScoreRepositoryImpl studentDao;
    @Override
    public List<AllStuScoreDTO> findAllStudentScore(Integer current_Page, Integer page_Size) {
        List<AllStuScoreDTO> list = studentDao.findAllStudentScore(current_Page, page_Size);
        return list;
    }

    @Override
    public List<StuByNameScoreDTO> findStuScoreByName(String name) {
        List<StuByNameScoreDTO> list = studentDao.findStudentScoreByName(name);
        return list;
    }
}
