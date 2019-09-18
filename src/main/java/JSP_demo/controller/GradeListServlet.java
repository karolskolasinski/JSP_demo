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

@WebServlet("/grade-list")
public class GradeListServlet extends HttpServlet {
    private final GradeService gradeService = new GradeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Grade> studentList = gradeService.findAll();
        req.setAttribute("my_lovely_grade_list", studentList);

        req.getRequestDispatcher("/grade-list.jsp").forward(req, resp);
    }
}
