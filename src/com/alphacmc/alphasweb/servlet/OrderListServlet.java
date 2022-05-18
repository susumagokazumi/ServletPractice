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

import com.alphacmc.alphasweb.bean.OrderBean;
import com.alphacmc.alphasweb.dao.OrderDao;

/**
 *
 * @author yohira
 *
 */
@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {

    public OrderListServlet() {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // Customer保存用List
        List<OrderBean> orderList = new ArrayList<>();


        try {
            //DAOオブジェクト化
            OrderDao objDao = new OrderDao();
            //SELECT文の準備
            String sql = "SELECT order_id, order_date, c.customer_name, p.prod_name, p.price, qty, (qty * p.price) AS amount "
                       + "FROM orders o "
                       + "LEFT OUTER JOIN customer c "
                       + "ON o.customer_id = c.customer_id "
                       + "LEFT OUTER JOIN prod p "
                       + "ON o.prod_id = p.prod_id "
                       + "ORDER BY order_id ";
            //結果の取得
            orderList = objDao.getResultList(sql);
//            Collections.sort(orderList, new Comparator<Object>(){
//                public int compare(Object o1, Object o2){
//                    return ((OrderBean)o1).getOrderId().compareTo(((OrderBean)o2).getOrderId());
//                }
//            });
//            

        } catch (Exception e){
                e.printStackTrace();
        }
      

        // リクエストコンテキスト設定
        request.setAttribute("orderList", orderList);

        // 画面遷移
        RequestDispatcher dispatch = request.getRequestDispatcher("/orderList.jsp");
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
