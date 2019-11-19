package jsp_studnet.controller;

import jsp_studnet.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student-delete")
public class StudentDeleteServlet extends HttpServlet {
    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long studentToRemoveId = Long.parseLong(req.getParameter("studentId"));
        studentService.removeStudentById(studentToRemoveId);
        resp.sendRedirect("student-list");
    }
}
