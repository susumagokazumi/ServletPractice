package com.alphacmc.alphasweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alphacmc.alphasweb.bean.UserBean;
import com.alphacmc.alphasweb.dao.UserDao;
import com.alphacmc.alphasweb.form.UserForm;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    // DAO
    private UserDao userDao = null;

    public LoginServlet() {
        userDao = new UserDao();
    }
    /**
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // パラメータ取得 & Formセット
        UserForm input = new UserForm();
        input.setUserId(request.getParameter("user_id"));
        input.setPassWord(request.getParameter("password"));

        // 読み込む
        final String SQL = "SELECT user_id, password, user_name FROM users WHERE user_id= '" + input.getUserId() +"'";
        
        UserBean user = userDao.getResult(SQL);
        
        System.out.println(user.getPassWord());
        if(user==null||!user.getPassWord().equals(input.getPassWord())) {
            String message = "ユーザ名またはパスワードに誤りがあります。";
            request.setAttribute("message", message);
            // 画面遷移
           request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // request.setAttribute()と同じ要領
            // 画面遷移
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }


    /**
     *
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
