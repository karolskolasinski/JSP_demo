package jsp_studnet.controller;

import jsp_studnet.model.Student;
import jsp_studnet.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/student-edit")
public class StudentEditServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long editedStudentId = Long.parseLong(req.getParameter("student_id"));
        String name = req.getParameter("student_name");
        String surname = req.getParameter("student_last_name");
        int age = Integer.parseInt(req.getParameter("student_age"));
        String alive = req.getParameter("student_is_alive");
        boolean isAlive = (alive != null && alive.equalsIgnoreCase("on"));
        Student studentEdited = new Student(editedStudentId, name, surname, age, isAlive);
        studentService.update(studentEdited);
        resp.sendRedirect("/student-list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long studentToEditId = Long.parseLong(req.getParameter("studentId"));
        Optional<Student> studentToEdit = studentService.getStudentById(studentToEditId);
        if (studentToEdit.isPresent()) {
            Student student = studentToEdit.get();
            req.setAttribute("studentId", student.getId());
            req.setAttribute("studentAge", student.getAge());
            req.setAttribute("studentName", student.getName());
            req.setAttribute("studentSurname", student.getSurname());
            req.setAttribute("studentIsAlive", student.isAlive());
            req.getRequestDispatcher("student-add.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("student-list");
        }


    }
}
