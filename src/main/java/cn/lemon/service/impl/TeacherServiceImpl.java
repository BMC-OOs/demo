package cn.lemon.service.impl;

import cn.lemon.constrant.CommonConstrants;
import cn.lemon.repository.TeacherDao;
import cn.lemon.repository.impl.TeacherScoreRepositoryImpl;
import cn.lemon.dto.AllTeachScoreDTO;
import cn.lemon.dto.TeachByNameScoreDTO;
import cn.lemon.model.Teacher;
import cn.lemon.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author BMC
 * @date 2020-04-12 14:27
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherScoreRepositoryImpl teacherScoreDao;
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<AllTeachScoreDTO> findAllTeacherScore(Integer current_Page, Integer page_Size) {
        List<AllTeachScoreDTO> list = teacherScoreDao.findAllTeacherScore( current_Page, page_Size);
        return list;
    }

    @Override
    public Boolean isPermission(Integer id) {
        Teacher teacher = teacherDao.getOne(id);
        String teachPosition = teacher.getTeachPosition();
        if (teachPosition.equals(CommonConstrants.POSITION)){
            return true;
        }
        return false;
    }

    @Override
    public List<TeachByNameScoreDTO> findTeacherScoreByName(String name) {
        List<TeachByNameScoreDTO> list = teacherScoreDao.findTeacherScoreByName(name);
        return list;
    }
}
