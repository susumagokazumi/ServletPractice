package com.alphacmc.alphasweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.alphacmc.alphasweb.bean.OrderBean;

public class OrderDao  extends BaseDao<OrderBean>{

    @Override
    protected	OrderBean setBean(ResultSet rset) {
          OrderBean order = new OrderBean();
            try {
                order.setOrderId(rset.getInt("order_id"));
                order.setOrderDate(rset.getTimestamp("order_date"));
                order.setCustomerName(rset.getString("customer_name"));
                order.setProdName(rset.getString("prod_name"));
                order.setPrice(rset.getInt("price"));
                order.setQty(rset.getInt("qty"));
            } catch (SQLException ex) {
                ex.printStackTrace();
                order = null;
            }
            return order;
    }

}
