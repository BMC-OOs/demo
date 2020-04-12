package cn.lemon.repository.impl;

import cn.lemon.dto.AllTeachScoreDTO;
import cn.lemon.dto.TeachByNameScoreDTO;
import cn.lemon.model.Teacher;
import cn.lemon.repository.TeacherScoreRepository;
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
 * @date 2020-04-11 14:58
 */
@Repository
public class TeacherScoreRepositoryImpl implements TeacherScoreRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<AllTeachScoreDTO> findAllTeacherScore(Integer current_Page, Integer page_Size){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AllTeachScoreDTO> query = criteriaBuilder.createQuery(AllTeachScoreDTO.class);
        Root<Teacher> root = query.from(Teacher.class);
        Join<Object, Object> teacherJoin = root.join("teacherScore", JoinType.LEFT);
        Join<Object, Object> courseJoin = teacherJoin.join("course", JoinType.LEFT);
        query.multiselect(
                root.get("teachName").as(String.class),
                courseJoin.get("courseName").as(String.class),
                criteriaBuilder.avg(teacherJoin.get("scores").as(BigDecimal.class)),
                criteriaBuilder.max(teacherJoin.get("scores").as(Integer.class)),
                criteriaBuilder.min(teacherJoin.get("scores").as(Integer.class)),
                teacherJoin.get("scoreDate").as(Date.class)
        );
        query.groupBy(
                root.get("teachName").as(String.class),
                courseJoin.get("courseName").as(String.class),
                teacherJoin.get("scoreDate").as(Date.class)
        );

        TypedQuery<AllTeachScoreDTO> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(current_Page);
        typedQuery.setMaxResults(page_Size);
        List<AllTeachScoreDTO> list = typedQuery.getResultList();
        return list;

    }
    @Override
    public List<TeachByNameScoreDTO> findTeacherScoreByName(String name){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TeachByNameScoreDTO> query = criteriaBuilder.createQuery(TeachByNameScoreDTO.class);
        Root<Teacher> root = query.from(Teacher.class);
        Join<Object, Object> teacherJoin = root.join("teacherScore", JoinType.LEFT);
        Join<Object, Object> courseJoin = teacherJoin.join("course", JoinType.LEFT);
        query.multiselect(
                root.get("teachName").as(String.class),
                courseJoin.get("courseName").as(String.class),
                criteriaBuilder.avg(teacherJoin.get("scores").as(BigDecimal.class)),
                criteriaBuilder.max(teacherJoin.get("scores").as(Integer.class)),
                criteriaBuilder.min(teacherJoin.get("scores").as(Integer.class)),
                teacherJoin.get("scoreDate").as(Date.class)
        );
        Predicate predicate = criteriaBuilder.equal(root.get("teachName"), name);
        query.where(predicate);

        query.groupBy(
                root.get("teachName").as(String.class),
                courseJoin.get("courseName").as(String.class),
                teacherJoin.get("scoreDate").as(Date.class)
        );

        TypedQuery<TeachByNameScoreDTO> typedQuery = entityManager.createQuery(query);
        List<TeachByNameScoreDTO> list = typedQuery.getResultList();
        return list;
    }
}
