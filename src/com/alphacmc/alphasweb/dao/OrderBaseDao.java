package com.alphacmc.alphasweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.alphacmc.alphasweb.bean.OrderBaseBean;

public class OrderBaseDao extends BaseDao<OrderBaseBean>{
    
    @Override
      protected	OrderBaseBean setBean(ResultSet rset) {
              OrderBaseBean orderBean = new OrderBaseBean();
              
                try {
                    orderBean.setOrderId(rset.getInt("order_id"));
                    orderBean.setOrderDate(rset.getTimestamp("order_date"));
                    orderBean.setCustomerId(rset.getInt("customer_id"));
                    orderBean.setProdId(rset.getInt("prod_Id"));
                    orderBean.setQty(rset.getInt("qty"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    orderBean = null;
                }
                return orderBean;
        }

}
