package com.alphacmc.alphasweb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alphacmc.alphasweb.bean.CustomerBean;
import com.alphacmc.alphasweb.dao.CustomerDao;


/**
 *
 * @author yohira
 *
 */
@WebServlet("/customerList")
public class CustomerListServlet extends HttpServlet {

    public CustomerListServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        // パラメータ取得
        //        Map<String, String[]> paramMap = request.getParameterMap();

        // Customer保存用List
        List<CustomerBean> customerList = new ArrayList<>();


        try {
            // DAOオブジェクト化
            CustomerDao objDao = new CustomerDao();


            //SELECT文の準備
            String sql = "SELECT customer_id, customer_name FROM customer ORDER BY customer_id ";
            
            //結果の取得
            customerList = objDao.getResultList(sql);


        } catch (Exception e){
            e.printStackTrace();
        }


        // リクエストコンテキスト設定
        request.setAttribute("customerList", customerList);

        // 画面遷移
        RequestDispatcher dispatch = request.getRequestDispatcher("/customerList.jsp");
        dispatch.forward(request, response);

    }

    /**
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
