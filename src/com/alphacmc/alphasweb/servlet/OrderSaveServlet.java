package com.alphacmc.alphasweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alphacmc.alphasweb.bean.CustomerBean;
import com.alphacmc.alphasweb.bean.OrderBaseBean;
import com.alphacmc.alphasweb.bean.ProdBean;
import com.alphacmc.alphasweb.dao.CustomerDao;
import com.alphacmc.alphasweb.dao.OrderBaseDao;
import com.alphacmc.alphasweb.dao.ProdDao;
import com.alphacmc.alphasweb.form.OrderForm;

@WebServlet("/orderSave")
public class OrderSaveServlet extends HttpServlet {

    // DAO
    private OrderBaseDao orderBaseDao = null;
    private ProdDao prodDao = null;
    private CustomerDao customerDao = null; 

    public OrderSaveServlet() {
        orderBaseDao = new OrderBaseDao();
        prodDao = new ProdDao();
        customerDao = new CustomerDao();
    }

    /**
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // パラメータ取得 & Formセット
        // 処理タイプ
        String procType = request.getParameter("procType");  
        OrderForm orderForm = new OrderForm();    
        orderForm.setOrderId((request.getParameter("orderId")));
        orderForm.setCustomerId(request.getParameter("customerId"));
        orderForm.setProdId(request.getParameter("prodId"));
        orderForm.setQty(request.getParameter("qty"));
        
        //顧客リスト
        List<CustomerBean> customerList = customerDao.getResultList("SELECT customer_id, customer_name FROM customer ORDER BY customer_id");
        request.setAttribute("customerList", customerList);
        //商品リスト
        List<ProdBean> prodList = prodDao.getResultList("SELECT prod_id, prod_name, price FROM prod ORDER BY prod_id");       
        request.setAttribute("prodList", prodList);


//        System.out.println(orderForm.getOrderId());
//        System.out.println(orderForm.getOrderDate());
//        System.out.println(orderForm.getCustomerId());
//        System.out.println(orderForm.getProdId());
//        System.out.println(orderForm.getPrice());
//        System.out.println(orderForm.getQty());
//        System.out.println(orderForm.getAmount());

         //読み込む
        String qureySQL = "SELECT order_id, order_date, customer_id, prod_id, qty "
                + "FROM orders "
               + "WHERE order_id= " + orderForm.getOrderId();
        
        OrderBaseBean order = orderBaseDao.getResult(qureySQL);
        
        final String updateSQL;
        if (order == null) {
            updateSQL = "INSERT INTO orders(order_id, order_date, customer_id, prod_id, qty) VALUES(" + orderForm.getOrderId() 
            + ", current_timestamp, " + orderForm.getCustomerId() + ","
            + orderForm.getProdId() +","+ orderForm.getQty() + ")";
            
        } else {
            updateSQL = "UPDATE orders SET customer_id = " + orderForm.getCustomerId()+ ",prod_id= " + orderForm.getProdId()  + ", qty = " + orderForm.getQty() +"WHERE order_id = " +  orderForm.getOrderId();
           }
        orderBaseDao.executeSQL(updateSQL);

        // 画面遷移
        response.sendRedirect("/alphasweb/orderList");
    }

    /**
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
