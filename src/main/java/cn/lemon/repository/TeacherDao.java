package cn.lemon.repository;

import cn.lemon.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BMC
 * @date 2020-04-12 14:44
 */
public interface TeacherDao extends JpaRepository<Teacher,Integer> {
}
