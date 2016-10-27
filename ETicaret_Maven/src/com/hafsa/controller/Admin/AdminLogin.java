package com.hafsa.controller.Admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hafsa.dao.AdminDao;
import com.hafsa.model.Admin;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String tcno=request.getParameter("tcno");
		String parola=request.getParameter("parola");
		
		if(tcno!=null && parola!=null && !tcno.equals("")&& !parola.equals("")){
			Admin admin=new Admin();
			admin.setTcno(tcno);
			admin.setParola(parola);
			
			if(AdminDao.admincontrol(admin)!=null){
				HttpSession session=request.getSession();
				session.setAttribute("admin",admin);
				System.out.println(admin.toString());
				response.sendRedirect("admin");	
			}else{
				request.setAttribute("state", "Tc No veya parola yanlýþ!");
				request.getRequestDispatcher("adminlogin").forward(request,response);
			}
		}else{
			request.setAttribute("state", "Lütfen boþ alan býrakmayýnýz!");
			request.getRequestDispatcher("adminlogin").forward(request,response);
		}
			
		}	
}
