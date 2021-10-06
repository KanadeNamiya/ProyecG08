package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;

/**
 * Servlet implementation class Servletproductos
 */
@WebServlet("/Servletproductos")
public class Servletproductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletproductos() {
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
		boolean x;
		long nit;
		String ciudad;
		String direccion;
		String nombre;
		String telefono;
		ProveedoresDAO prodao;
		ProveedoresDTO prodto;
		ProveedoresDTO proregistro;
		
		//Actualizar
		if(request.getParameter("btnacsu")!=null) {
			int dat;
			nit=Long.parseLong(request.getParameter("nit"));
			ciudad=request.getParameter("ciudad");
			direccion=request.getParameter("direccion");
			nombre=request.getParameter("nombre");
			telefono=request.getParameter("telefono");
			prodto= new ProveedoresDTO(nit, ciudad, direccion, nombre, telefono);
			prodao= new ProveedoresDAO();
			dat=prodao.actualizarproveedor(prodto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "Registro actualizado");
				response.sendRedirect("PaginaProveedores.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Registro no actualizado");
				response.sendRedirect("PaginaProveedores.jsp");
			}
			
		}
		
	}

}
