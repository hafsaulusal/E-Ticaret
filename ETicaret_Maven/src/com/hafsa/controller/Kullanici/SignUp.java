package com.hafsa.controller.Kullanici;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hafsa.dao.KullaniciDao;
import com.hafsa.model.Kullanici;
import com.hafsa.model.Yetki;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String kullaniciad=request.getParameter("kullaniciad");
				String kullanicisoyad=request.getParameter("kullanicisoyad");
				String tcno=request.getParameter("tcno");
				String eposta=request.getParameter("eposta");
				String parola=request.getParameter("parola");
				String cepno=request.getParameter("cepno");
				String adres=request.getParameter("adres");
				
				if(kullaniciad!=null && kullanicisoyad!=null && eposta!=null && parola!=null &&tcno!=null&&cepno!=null&&adres!=null
						&& !kullaniciad.equals("")&& !kullanicisoyad.equals("")&& !eposta.equals("")&& !parola.equals("")
						&&!tcno.equals("")&&!cepno.equals("")&&!adres.equals("")){
				
					Kullanici kullanici=new Kullanici();
					kullanici.setKullaniciad(kullaniciad);
					kullanici.setKullanicisoyad(kullanicisoyad);
					kullanici.setTcno(tcno);
					kullanici.setEposta(eposta);
					kullanici.setParola(parola);
					kullanici.setCepno(cepno);
					kullanici.setAdres(adres);
					kullanici.setYetkino(new Yetki(2));
					if(KullaniciDao.kullaniciekle(kullanici)!=false){
						HttpSession session=request.getSession();
						session.setAttribute("kullanici",kullanici);
						System.out.println(kullanici.toString());
						response.sendRedirect("index");
					}
					else{
						request.setAttribute("state", "Üye iþleminiz sýrasýnda bir hata oluþmuþtur!");
						request.getRequestDispatcher("musterikayit").forward(request, response);
				}
	}

	}
}
