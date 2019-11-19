package jsp_studnet.controller;

import jsp_studnet.model.GradeSubject;
import jsp_studnet.model.Student;
import jsp_studnet.services.GradeService;
import jsp_studnet.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/grade-add")
public class GradeAddServlet extends HttpServlet {
    private final GradeService gradeService = new GradeService();
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long studentId = Long.parseLong(req.getParameter("studentId"));
        req.setAttribute("studentId", studentId);
        req.getRequestDispatcher("/grade-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long studentIdentifier = Long.parseLong(req.getParameter("student_to_whom_i_should_give_grade_to"));
        Optional<Student> studentOptional = studentService.getStudentById(studentIdentifier);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            Double value = Double.parseDouble(req.getParameter("value"));
            GradeSubject gradeSubject = GradeSubject.valueOf(req.getParameter("subject"));
            gradeService.addGrade(student, value, gradeSubject);
            resp.sendRedirect("/grade-list");
        }

    }


}
