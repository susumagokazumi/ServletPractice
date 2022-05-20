package com.alphacmc.alphasweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alphacmc.alphasweb.bean.ProdBean;
import com.alphacmc.alphasweb.dao.ProdDao;
import com.alphacmc.alphasweb.form.ProdForm;

@WebServlet("/prodSave")
public class ProdSaveServlet extends HttpServlet {

	// DAO
	private ProdDao prodDao = null;

	public ProdSaveServlet() {
		prodDao = new ProdDao();
	}

	/**
	 *
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// パラメータ取得 & Formセット
		ProdForm prodForm = new ProdForm();
		prodForm.setProdId(request.getParameter("prodId"));
		prodForm.setProdName(request.getParameter("prodName"));
		prodForm.setPrice(request.getParameter("price"));
		
		
		System.out.println(prodForm.getProdId());
		System.out.println(prodForm.getProdName());

		// 読み込む
		final String qureySQL = "SELECT prod_id, prod_name, price FROM prod WHERE prod_id = " + prodForm.getProdId();
		ProdBean prod = prodDao.getResult(qureySQL);

		final String updateSQL;
		if (prod == null) {
			updateSQL = "INSERT INTO prod(prod_id, prod_name, price) VALUES(" + prodForm.getProdId() + ", '" +  prodForm.getProdName() + "', " + prodForm.getPrice() + ")";
		} else {
			updateSQL = "UPDATE prod SET prod_name = '" + prodForm.getProdName() + "', price = " + prodForm.getPrice()  + " WHERE prod_id = " + prodForm.getProdId();
		}
		prodDao.executeSQL(updateSQL);

		// 画面遷移
		response.sendRedirect("/alphasweb/prodList");
	}

	/**
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}



}