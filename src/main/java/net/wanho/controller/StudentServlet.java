package net.wanho.controller;

import net.wanho.pojo.Student;
import net.wanho.service.StudentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Jerk on 2019/5/29.
 */
@WebServlet("/selectAllStu")
@Controller
public class StudentServlet extends HttpServlet {

    @Autowired
    private StudentServiceI studentServiceI;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
                    HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            studentServiceI.addStu();
        doPost(request, response);
    }
    protected void getAllEmployee(HttpServletRequest request, HttpServletResponse response) {
                List<Student> studentList=studentServiceI.selectAllStudent();
                request.setAttribute("studentList",studentList);
        try {
            request.getRequestDispatcher("/WEB-INF/manage/ADUS.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        //application 获取IOC容器的引用
        ServletContext servletContext = getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        studentServiceI = ctx.getBean(StudentServiceI.class);
    }
}
