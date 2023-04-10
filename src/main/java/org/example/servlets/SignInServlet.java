package org.example.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.repositories.UserRepository;
import org.example.repositories.UserRepositoryImpl;
import org.example.services.UserService;
import org.example.services.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
    //    ServletContext context = config.getServletContext();
    //    SessionFactory sessionFactory = (SessionFactory) context.getAttribute("sf");
     //    UserRepository repository = new UserRepositoryImpl(sessionFactory);
     //   this.userService = new UserServiceImpl(repository);
         ClassPathXmlApplicationContext contextSpring=new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        this.userService=contextSpring.getBean("userServiceImpl",UserServiceImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String login=req.getParameter("login");
String password=req.getParameter("password");
if(userService.signIn(login,password)){
    req.getRequestDispatcher("signInDone.jsp").forward(req,resp);
}
else{
    req.getRequestDispatcher("signInWrong.jsp").forward(req,resp);
}
    }
}
