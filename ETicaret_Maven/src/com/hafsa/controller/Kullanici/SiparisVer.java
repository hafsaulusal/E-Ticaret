package com.hafsa.controller.Kullanici;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafsa.dao.SiparisDao;
import com.hafsa.model.Kargo;
import com.hafsa.model.Kullanici;
import com.hafsa.model.Odeme;
import com.hafsa.model.Siparis;
import com.hafsa.model.SiparisDurum;
import com.hafsa.model.Urun;


@WebServlet("/SiparisVer")
public class SiparisVer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String odemeSecenek = request.getParameter("odemeSecenek");
		String kargoSirket = request.getParameter("kargo");
		String teslimAdresi = request.getParameter("adres");
		String message = "";
		if (odemeSecenek != null && kargoSirket != null && teslimAdresi != null) {
			int odemeSecenekID = 0;
			int kargoSirketID = 0;
			try{
				odemeSecenekID = Integer.parseInt(odemeSecenek);
				kargoSirketID = Integer.parseInt(kargoSirket);
			}catch(NumberFormatException ex){
			}
			Kullanici kullanici = (Kullanici) request.getSession().getAttribute("kullanici");
			@SuppressWarnings("unchecked")
			ArrayList<Urun> musteriUrun = (ArrayList<Urun>) request.getSession().getAttribute("sepet");
			if(odemeSecenekID != 0 && kargoSirketID != 0){
			try {
				for (Urun urun : musteriUrun) {
					Siparis yeniSiparis = new Siparis();
					yeniSiparis.setAdet(1);
					yeniSiparis.setFiyat(urun.getFiyat());
					yeniSiparis.setKargoid(new Kargo(kargoSirketID));
					yeniSiparis.setKullaniciid(kullanici);
					yeniSiparis.setOdemeid(new Odeme(odemeSecenekID));
					yeniSiparis.setAdres(teslimAdresi);
					yeniSiparis.setUrunid(urun);
					yeniSiparis.setSiparisdurumid(new SiparisDurum(7));
					SiparisDao.yenisiparis(yeniSiparis);
				}
				message = "Sipari�iniz ba�ar�yla al�nm��t�r. 2 ila 7 g�n i�erisinde teslim edilecektir!";
				musteriUrun.clear();
			} catch (Exception ex) {
				ex.printStackTrace();
				message = "Sipari�iniz al�namam��t�r. Kart�n�z�n aktif oldu�undan emin olunuz..";
			}
			request.setAttribute("siparisSonuc", message);
			}else{
				message = "L�tfen �deme Tipini ve Tercih etti�iniz kargo �irketini se�ip tekrar sipari� veriniz!";
				request.setAttribute("siparisSonuc", message);
				request.getRequestDispatcher("sepet").forward(request, response);
			}
		}else{
			request.setAttribute("siparisSonuc", "L�tfen gerekli t�m alanlar� doldurunuz!");
		}
		request.getRequestDispatcher("sepet").forward(request, response);
	}

}
