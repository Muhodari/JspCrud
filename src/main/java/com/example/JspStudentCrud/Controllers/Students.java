package com.example.JspStudentCrud.Controllers;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.example.JspStudentCrud.DB.StudentDaoHbnt;
import com.example.JspStudentCrud.models.Student;

import static java.lang.Long.*;
import static java.lang.Long.valueOf;

/**
 * Servlet implementation class Students
 */
//@WebServlet("/list")
public class Students extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDaoHbnt studentDaoHbnt;
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        studentDaoHbnt = new StudentDaoHbnt();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                case "/viewUser":
                    ViewOneStudent(request,response);
                    break;
                default:
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> listStudent = studentDaoHbnt.getAllStudent();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_student.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long id = valueOf(Integer.parseInt(request.getParameter("id")));
        Student existingStudent = studentDaoHbnt.getStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_student.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);
    }
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        Student newStudent = new Student(firstName, lastName, gender);
        studentDaoHbnt.saveStudent(newStudent);
        response.sendRedirect("list");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id =valueOf(Integer.parseInt(request.getParameter("id")));
        String first_name = request.getParameter("firstName");
        String last_name = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        Student book = new Student(id,first_name, last_name, gender);
        studentDaoHbnt.updateStudent(book);
        response.sendRedirect("list");
    }


    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Long id = valueOf(Integer.parseInt(request.getParameter("id")));
//        Student book = new Student(Long.valueOf(id));
        studentDaoHbnt.deleteStudent(id);
        response.sendRedirect("list");
    }


    private void ViewOneStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Long id =valueOf( Integer.parseInt(request.getParameter("id")));
        Student listStudent = studentDaoHbnt.getStudent(id);
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewOneUser.jsp");
        dispatcher.forward(request, response);

    }


}