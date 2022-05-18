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

import com.alphacmc.alphasweb.bean.ProdBean;
import com.alphacmc.alphasweb.dao.ProdDao;

/**
 *
 * @author yohira
 *
 */
@WebServlet("/prodList")
public class ProdListServlet extends HttpServlet {

    public ProdListServlet() {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // パラメータ取得
        //        Map<String, String[]> paramMap = request.getParameterMap();

        // Customer保存用List
        List<ProdBean> prodList  = new ArrayList<>();



        try {
            // DAOオブジェクト化
            ProdDao objDao = new ProdDao();


            //SELECT文の準備
            String sql = "SELECT prod_id, prod_name, price FROM prod ORDER BY prod_id";

            //結果の取得
            prodList = objDao.getResultList(sql);


        } catch (Exception e){
            e.printStackTrace();
        }



        // リクエストコンテキスト設定
        request.setAttribute("prodList", prodList);

        System.out.println("prod size=" + prodList.size());

        // 画面遷移
        RequestDispatcher dispatch = request.getRequestDispatcher("/prodList.jsp");
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
