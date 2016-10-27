package com.hafsa.controller.Admin;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.SiparisDao;
import com.hafsa.model.Kargo;
import com.hafsa.model.Siparis;
import com.hafsa.model.SiparisDurum;


@WebServlet("/GuncelleSiparis")
public class GuncelleSiparis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		SiparisDurum siparisDurum = new SiparisDurum(Integer.parseInt(request.getParameter("siparisDurum")));
		Kargo kargo = new Kargo(Integer.parseInt(request.getParameter("kargo")));
		Siparis siparis = new Siparis();
		siparis.setTeslimtarih(Timestamp.valueOf(request.getParameter("teslimtarih")));
		siparis.setSiparisid(Integer.parseInt(request.getParameter("siparisid")));
		siparis.setSiparisdurumid(siparisDurum);
		siparis.setKargoid(kargo);
		boolean state = false;
		try {
			state = SiparisDao.siparisguncelle(siparis);
			String message;
			if (state == true) {
				message = "Sipariþ bilgileri güncellendi.";
			} else {
				message = "Ýþlem sýrasýnda bir hata oluþtu";
			}
			request.setAttribute("stateGuncelleme", message);
			request.getRequestDispatcher("siparis").forward(request, response);
		 } catch (SQLException e) {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
