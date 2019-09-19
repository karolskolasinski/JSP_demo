package JSP_demo.services;

import JSP_demo.database.EntityDao;
import JSP_demo.model.Student;

import java.util.List;
import java.util.Optional;

public class StudentService {
//    private List<Student> studentList = new ArrayList<>();
//
//    public StudentService() {
//        studentList.add(new Student(1L, "pawel", "gawel", 25, true));
//        studentList.add(new Student(2L, "marian", "c", 35, true));
//        studentList.add(new Student(3L, "juzek", "b", 26, true));
//        studentList.add(new Student(4L, "rafau", "a", 27, false));
//    }

    private EntityDao entityDao = new EntityDao();

    public StudentService() {
    }

    public List<Student> findAll() {
        return entityDao.getAll(Student.class);
    }

    public void addStudent(String name, String surname, int age, boolean isAlive) {
        entityDao.saveOrUpdate(new Student(name, surname, age, isAlive));
    }

    public void removeStudentById(Long studentToRemoveId) {
        entityDao.delete(Student.class, studentToRemoveId);
    }

    public Optional<Student> getStudentById(Long studentToEditId) {
        return entityDao.getById(Student.class, studentToEditId);
    }

    public void update(Student studentEdited) {
        entityDao.saveOrUpdate(studentEdited);
    }
}
