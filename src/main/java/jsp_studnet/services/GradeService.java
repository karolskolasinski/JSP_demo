package jsp_studnet.services;

import jsp_studnet.database.EntityDao;
import jsp_studnet.model.Grade;
import jsp_studnet.model.GradeSubject;
import jsp_studnet.model.Student;

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
