package org.example.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.example.repositories.UserRepositoryImpl;
import org.example.services.UserService;
import org.example.services.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
      //  ServletContext context = config.getServletContext();
     ////   SessionFactory sessionFactory = (SessionFactory) context.getAttribute("sf");
     //   UserRepository repository = new UserRepositoryImpl(sessionFactory);
      //  this.userService = new UserServiceImpl(repository);

        ClassPathXmlApplicationContext contextSpring=new ClassPathXmlApplicationContext
                ("applicationContext.xml");

        this.userService=contextSpring.getBean("userServiceImpl",UserServiceImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder().login(req.getParameter("login")).
                name(req.getParameter("name")).
                surname(req.getParameter("surname")).
                email(req.getParameter("email")).
                password(req.getParameter("password")).
                build();
        userService.signUp(user);
        req.getRequestDispatcher("signUpDone.jsp").forward(req, resp);
    }
}
