package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductoDAO;

/**
 * Servlet implementation class Achivos
 */
@WebServlet("/Achivos")
@MultipartConfig
public class Achivos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Achivos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part archivo= request.getPart("archivo");
		String Url="C:\\\\Users\\\\apoyo.contabilidad\\\\eclipse-workspace\\\\ProyecG08\\\\src\\\\main\\\\webapp\\\\documentos\\\\";
		
		if(request.getParameter("cargar")!=null) {
			
			try {
				
				InputStream file= archivo.getInputStream();
				File copia= new File(Url+"archivo01.csv");
				FileOutputStream escribir= new FileOutputStream(copia);
				int num=file.read();
				while(num !=-1) {
					escribir.write(num);
					num=file.read();
				}
				file.close();
				escribir.close();
				
				JOptionPane.showMessageDialog(null, "Se cargo el archivo 1");
				
				boolean x;
				ProductoDAO prodao=new ProductoDAO();
				x=prodao.cargarproducto(Url+"archivo01.csv");
				if(x) {
					JOptionPane.showMessageDialog(null, "datos cargados el archivo");
					response.sendRedirect("PaginaProductos.jsp");
				}
				else {
					JOptionPane.showMessageDialog(null, "datos no cargados el archivo");
					response.sendRedirect("PaginaProductos.jsp");
				}
				
			}catch (Exception e) {
			
				JOptionPane.showMessageDialog(null, "error al cargar");
			
		} 
	
	}

}
}
