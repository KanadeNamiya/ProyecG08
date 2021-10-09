package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;
import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

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
		long codproduc,nit;
		double iva,compra,venta;
		String nompro;
		ProductoDAO prodao;
		ProductoDTO prodto;
		ProductoDTO proregistro;
		
		//Insertar
		
		if (request.getParameter("btninsp")!=null) {
			codproduc=Long.parseLong(request.getParameter("codproduc"));
			iva=Long.parseLong(request.getParameter("iva"));
			nit=Long.parseLong(request.getParameter("nit"));
			nompro=request.getParameter("nompro");
			compra=Long.parseLong(request.getParameter("compra"));
			venta=Long.parseLong(request.getParameter("venta"));
			prodto= new ProductoDTO(codproduc, iva, nit, nompro, compra, venta);
			prodao= new ProductoDAO();
			x=prodao.insertarproductos(prodto);
			if (x==true) {
				JOptionPane.showMessageDialog(null, "El producto fue insertado");
				response.sendRedirect("PaginaProductos.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Proveedor no encontrado");
				response.sendRedirect("PaginaProductos.jsp");
			}
		}
		
		 //Consultar
		if(request.getParameter("btncrsp")!=null) {
			codproduc=Long.parseLong(request.getParameter("codproduc"));
			prodto= new ProductoDTO(codproduc);
			prodao= new ProductoDAO();
			proregistro=prodao.consultarproducto(prodto);
			
			if (proregistro!=null) {
			codproduc=proregistro.getCodproducto();
			iva=proregistro.getIva();
			nit=proregistro.getNit();
			nompro=proregistro.getNombrep();
			compra=proregistro.getCompra();
			venta=proregistro.getVenta();
		
			response.sendRedirect("PaginaProductos.jsp?ni="+codproduc+"&&ci="+iva+"&&di="+nit+"&&no="+nompro+"&&te="+compra+"&&to="+venta);
			}
			else {
				JOptionPane.showMessageDialog(null,"No existen datos");
			}
		}
		
		//Actualizar
		if(request.getParameter("btnacsp")!=null) {
			int dat;
			codproduc=Long.parseLong(request.getParameter("codproduc"));
			iva=Double.parseDouble(request.getParameter("iva"));
			nit=Long.parseLong(request.getParameter("nit"));
			nompro=request.getParameter("nompro");
			compra=Double.parseDouble(request.getParameter("compra"));
			venta=Double.parseDouble(request.getParameter("venta"));
			prodto= new ProductoDTO(codproduc, iva, nit, nompro, compra, venta);
			prodao= new ProductoDAO();
			dat=prodao.actualizarproducto(prodto);
			JOptionPane.showMessageDialog(null, "Registro actualizado3");
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "Registro actualizado");
				response.sendRedirect("PaginaProductos.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Registro no actualizado");
				response.sendRedirect("PaginaProductos.jsp");
			}
			
		}
		
		//Eliminar
		if(request.getParameter("btnelsp")!=null) {
			int dat;
			codproduc=Long.parseLong(request.getParameter("codproduc"));
			prodto=new ProductoDTO(codproduc);
			prodao=new ProductoDAO();
			dat=prodao.eliminarproducto(prodto);
			if (dat>0) {
				JOptionPane.showMessageDialog(null, "Registro eliminado");
				response.sendRedirect("PaginaUsuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Registro no eliminado");
				response.sendRedirect("PaginaUsuario.jsp");
			}
		}
		
	}

}
