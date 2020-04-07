package cn.bmc.demojpa;

import cn.bmc.DemoJpaApplication;
import cn.bmc.dao.CourseDao;
import cn.bmc.dao.StudentDao;
import cn.bmc.dao.TeacherDao;
import cn.bmc.dto.StudentDTO;
import cn.bmc.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = DemoJpaApplication.class)
class DemoJpaApplicationTests {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    @Test
    @Transactional
    void  contextLoads() {
        Specification<Student> specification = new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> stuName = root.get("stuName");
                Predicate pre = criteriaBuilder.equal(stuName, "张三");
                return pre;
            }
        };
        Pageable pageable = PageRequest.of(0,1);
        Page<Student> page = studentDao.findAll(specification, pageable);
        List<Student> list = page.getContent();
        System.out.println(list.size());
        System.out.println(list);

    }

}
