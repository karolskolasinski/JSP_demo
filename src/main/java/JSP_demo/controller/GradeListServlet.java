package JSP_demo.controller;

import JSP_demo.model.Grade;
import JSP_demo.model.Student;
import JSP_demo.services.GradeService;
import JSP_demo.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/grade-list")
public class GradeListServlet extends HttpServlet {
    private final GradeService gradeService = new GradeService();
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("studentId") != null) {
            Long studentId = Long.parseLong(req.getParameter("studentId"));
            Optional<Student> studentOptional = studentService.getStudentById(studentId);
            if (studentOptional.isPresent()) {
                Student student = studentOptional.get();
                req.setAttribute("my_lovely_grade_list", student.getGradeList());
            }
            req.getRequestDispatcher("/grade-list.jsp").forward(req, resp);
        } else {
            List<Grade> gradeList = gradeService.findAll();
            req.setAttribute("my_lovely_grade_list", gradeList);
            req.getRequestDispatcher("/grade-list.jsp").forward(req, resp);
        }
    }
}
