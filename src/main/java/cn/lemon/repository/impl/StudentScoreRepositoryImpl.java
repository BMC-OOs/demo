package cn.lemon.repository.impl;

import cn.lemon.dto.AllStuScoreDTO;
import cn.lemon.dto.StuByNameScoreDTO;
import cn.lemon.model.Student;
import cn.lemon.repository.StudentScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * @author BMC
 * @date 2020-04-06 18:18
 */
@Repository
public class StudentScoreRepositoryImpl implements StudentScoreRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<AllStuScoreDTO> findAllStudentScore(Integer current_Page, Integer page_Size){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AllStuScoreDTO> query = criteriaBuilder.createQuery(AllStuScoreDTO.class);
        Root<Student> root = query.from(Student.class);
        Join<Object, Object> stuScoresJoin = root.join("stuScores", JoinType.LEFT);
        Join<Object, Object> courseJoin = stuScoresJoin.join("course", JoinType.LEFT);
        query.multiselect(
            root.get("stuName").as(String.class),
            courseJoin.get("courseName").as(String.class),
            criteriaBuilder.avg(stuScoresJoin.get("scores").as(BigDecimal.class)),
            criteriaBuilder.max(stuScoresJoin.get("scores").as(Integer.class)),
            criteriaBuilder.min(stuScoresJoin.get("scores").as(Integer.class)),
            stuScoresJoin.get("scoreDate").as(Date.class)
        );
        query.groupBy(
                root.get("stuName").as(String.class),
                courseJoin.get("courseName").as(String.class),
                stuScoresJoin.get("scoreDate").as(Date.class)
        );
        TypedQuery<AllStuScoreDTO> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(current_Page);
        typedQuery.setMaxResults(page_Size);

        List<AllStuScoreDTO> list = typedQuery.getResultList();
        return list;
    }


    @Override
    public List<StuByNameScoreDTO> findStudentScoreByName(String name){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StuByNameScoreDTO> query = criteriaBuilder.createQuery(StuByNameScoreDTO.class);

        Root<Student> root = query.from(Student.class);
        Join<Object, Object> stuScoresJoin = root.join("stuScores", JoinType.LEFT);
        Join<Object, Object> courseJoin = stuScoresJoin.join("course", JoinType.LEFT);
        query.multiselect(
                root.get("stuName").as(String.class),
                courseJoin.get("courseName").as(String.class),
                stuScoresJoin.get("scores").as(Integer.class),
                stuScoresJoin.get("scoreDate").as(Date.class)
        );

        Predicate predicate = criteriaBuilder.equal(root.get("stuName"), name);
        query.where(predicate);

        TypedQuery<StuByNameScoreDTO> typedQuery = entityManager.createQuery(query);
        List<StuByNameScoreDTO> list = typedQuery.getResultList();
        return list;
    }
}
