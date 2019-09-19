package JSP_demo.services;

import JSP_demo.database.EntityDao;
import JSP_demo.model.Grade;
import JSP_demo.model.GradeSubject;
import JSP_demo.model.Student;

import java.util.List;

public class GradeService {
    private EntityDao entityDao = new EntityDao();

    public GradeService() {
    }

    public List<Grade> findAll() {
        return entityDao.getAll(Grade.class);
    }

    public void addGrade(Student student, Double value, GradeSubject gradeSubject) {
        Grade grade = new Grade(gradeSubject, value);
        grade.setStudent(student);
        entityDao.saveOrUpdate(grade);
    }
}
