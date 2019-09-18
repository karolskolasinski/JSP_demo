package JSP_demo.controller;

import JSP_demo.model.Student;
import JSP_demo.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student-add")
public class StudentAddServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/student-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("student_name");
        String surname = req.getParameter("student_last_name");
        int age = Integer.parseInt(req.getParameter("student_age"));
        String alive = req.getParameter("student_isAlive");
        boolean isAlive = (alive != null && alive.equalsIgnoreCase("on"));

        studentService.addStudent(name, surname, age, isAlive);

        resp.sendRedirect("/student-list");
    }
}
