package com.hafsa.controller.Admin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.hafsa.dao.UrunDao;
import com.hafsa.model.Kategori;
import com.hafsa.model.Urun;




@WebServlet("/GuncelleUrun")
public class GuncelleUrun extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		Hashtable<String, String> rqParams = new Hashtable<String, String>();
		@SuppressWarnings("unused")
		String fileName = null;
		InputStream streamImg = null;
		try {
			List<FileItem> formItems = upload.parseRequest(request);
			if (formItems != null && formItems.size() > 0) {
				for (FileItem item : formItems) {
					if (!item.isFormField()) {
						fileName = item.getName().replace(" ", "-");
						streamImg = item.getInputStream();

					}
					if (item.isFormField()) {
						InputStream stream = item.getInputStream();
						rqParams.put(item.getFieldName(), Streams.asString(stream, "utf-8"));
					}
				}
			}

		} catch (Exception ex) {
			request.setAttribute("message", "There was an error: " + ex.getMessage());
		}

		Urun urun = new Urun();
		urun.setKategoriid(new Kategori(Integer.parseInt(rqParams.get("kategori"))));	
		urun.setUrunad(rqParams.get("urunad"));
		urun.setAciklama(rqParams.get("aciklama"));
		urun.setFiyat(Integer.parseInt(rqParams.get("fiyat")));
		urun.setStok(Integer.parseInt(rqParams.get("stok")));
		urun.setUrunid(Integer.parseInt(rqParams.get("urunid")));
		urun.setStreamImg(streamImg);
		boolean state = false;
		try {
			state = UrunDao.urunguncelle(urun);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message;
		if (state == true) {
			message = "Yeni ürün baþarýyla güncellendi";
		} else {
			message = "Ýþlem sýrasýnda bir hata oluþtu";
		}
		request.setAttribute("stateGuncelleme", message);
		request.getRequestDispatcher("urun").forward(request, response);
	}
}

