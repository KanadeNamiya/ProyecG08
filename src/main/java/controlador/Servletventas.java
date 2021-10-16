package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.UsuariosDAO;
import modelo.UsuariosDTO;
import modelo.VentaDAO;
import modelo.VentaDTO;

/**
 * Servlet implementation class Servletventas
 */
@WebServlet("/Servletventas")
public class Servletventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva1,iva2,iva3;
	int cantidad1,cantidad2,cantidad3,contador=1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletventas() {
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
		
		HttpSession sesion=request.getSession();
		PrintWriter out=response.getWriter();
		long cedulacliente ;
		String direccioncliente;
		String emailcliente;
		String nombrecliente;
		String telefonocliente;
		ClienteDAO clidao;
		ClienteDTO clidto;
		ClienteDTO cliregistro;
		
		
		//Consultar cliente
		if(request.getParameter("enviarcel")!=null) {
			cedulacliente=Long.parseLong(request.getParameter("cedulacliente"));
			clidto= new ClienteDTO(cedulacliente);
			clidao= new ClienteDAO();
			cliregistro=clidao.consultarcliente(clidto);
			
			if (cliregistro!=null) {
			cedulacliente=cliregistro.getCedulacliente();
			direccioncliente=cliregistro.getDireccioncliente();
			emailcliente=cliregistro.getEmailcliente();
			nombrecliente=cliregistro.getNombrecliente();
			telefonocliente=cliregistro.getTelefonocliente();
	
			response.sendRedirect("PaginaVentas.jsp?ce="+cedulacliente+"&&di="+direccioncliente+"&&em="+emailcliente+"&&nom="+nombrecliente+"&&tel="+telefonocliente);
			sesion.setAttribute("vs", cliregistro);
			
			
			
			}
			else {
				JOptionPane.showMessageDialog(null,"No existen datos");
				response.sendRedirect("PaginaVentas.jsp");
			}
		}
		
		long codproduc,nit;
		double compra,venta;
		String nompro;
		ProductoDAO prodao;
		ProductoDTO prodto;
		ProductoDTO proregistro;
		
		 //Consultar1
		if(request.getParameter("consultarProducto1")!=null) {
			codproduc=Long.parseLong(request.getParameter("codigoproducto1"));
			prodto= new ProductoDTO(codproduc);
			prodao= new ProductoDAO();
			proregistro=prodao.consultarproducto(prodto);
			
			if (proregistro!=null) {
			codproduc=proregistro.getCodproducto();
			iva1=proregistro.getIva();
			nit=proregistro.getNit();
			nompro=proregistro.getNombrep();
			compra=proregistro.getCompra();
			venta=proregistro.getVenta();
		
			response.sendRedirect("PaginaVentas.jsp?ni="+codproduc+"&&ci="+nit+"&&no="+nompro+"&&te="+compra+"&&to="+venta);
			sesion.setAttribute("cp", proregistro);
			
			
			}
			
			else {
				JOptionPane.showMessageDialog(null,"No existen datos");
			}
		}
		
		
		//Consultar2
				if(request.getParameter("consultarProducto2")!=null) {
					codproduc=Long.parseLong(request.getParameter("codigoproducto2"));
					prodto= new ProductoDTO(codproduc);
					prodao= new ProductoDAO();
					proregistro=prodao.consultarproducto(prodto);
					
					if (proregistro!=null) {
					codproduc=proregistro.getCodproducto();
					iva2=proregistro.getIva();
					nit=proregistro.getNit();
					nompro=proregistro.getNombrep();
					compra=proregistro.getCompra();
					venta=proregistro.getVenta();
				
					response.sendRedirect("PaginaVentas.jsp?ni="+codproduc+"&&ci="+"&&di="+nit+"&&no="+nompro+"&&te="+compra+"&&to="+venta);
					sesion.setAttribute("cp2", proregistro);
					}
					else {
						JOptionPane.showMessageDialog(null,"No existen datos");
					}
				}
				//Consultar3
				if(request.getParameter("consultarProducto3")!=null) {
					codproduc=Long.parseLong(request.getParameter("codigoproducto3"));
					prodto= new ProductoDTO(codproduc);
					prodao= new ProductoDAO();
					proregistro=prodao.consultarproducto(prodto);
					
					if (proregistro!=null) {
					codproduc=proregistro.getCodproducto();
					iva3=proregistro.getIva();
					nit=proregistro.getNit();
					nompro=proregistro.getNombrep();
					compra=proregistro.getCompra();
					venta=proregistro.getVenta();
				
					response.sendRedirect("PaginaVentas.jsp?ni="+codproduc+"&&ci="+"&&di="+nit+"&&no="+nompro+"&&te="+compra+"&&to="+venta);
					sesion.setAttribute("cp3", proregistro);
					
					}
					else {
						JOptionPane.showMessageDialog(null,"No existen datos");
					}
				}
	double total1,total2,total3,resultado1,resultado2,resultado3,totalsiniva,totalconiva,totaliva;
	
	
	if (request.getParameter("total")!=null) {
		double totaliva1,totaliva2,totaliva3;
		
		cantidad1=Integer.parseInt(request.getParameter("cantidad1"));
		cantidad2=Integer.parseInt(request.getParameter("cantidad2"));
		cantidad3=Integer.parseInt(request.getParameter("cantidad3"));
		
		total1=Double.parseDouble(request.getParameter("precioproducto1"));
		total2=Double.parseDouble(request.getParameter("precioproducto2"));
		total3=Double.parseDouble(request.getParameter("precioproducto3"));
		
		
		resultado1=cantidad1*total1;
		resultado2=cantidad2*total2;
		resultado3=cantidad3*total3;
		
		totaliva1=resultado1*iva1/100;
		totaliva2=resultado2*iva2/100;
		totaliva3=resultado3*iva3/100;
		
		totalsiniva=resultado1+resultado2+resultado3;
		
		totaliva=totaliva1+totaliva2+totaliva3;
		
		totalconiva=totaliva+totalsiniva;
		
		
		
		int i=JOptionPane.showConfirmDialog(null,"precio por su compra sin IVA es de :"+totalsiniva+"\n"+"precio por su compra con IVA es de:"+totalconiva);
		JOptionPane.showMessageDialog(null, i);
		if (i==0) {
		while (i==0) {contador=contador+1;}
			
			
		
			
			String cedulaCliente,cedulausuario;
			long cc,cu;
			double iva,siniva,coniva;
			boolean rees;
			cedulaCliente=(request.getParameter("cedulacliente"));
			cedulausuario=(request.getParameter("cedulausuario"));
			iva=totaliva;
			siniva=totalsiniva;
			coniva=totalconiva;
			cc=Long.parseLong(cedulaCliente);
			cu=Long.parseLong(cedulausuario);
			VentaDTO ven=new VentaDTO(contador,cc,cu,iva,siniva,coniva);
			VentaDAO vendao=new VentaDAO();
			rees=vendao.insertarventa(ven);
			if (rees==true) {JOptionPane.showMessageDialog(null, "Venta fue Registrada");
			response.sendRedirect("PaginaVentas.jsp");
			
			
			
			
			}else {
				JOptionPane.showMessageDialog(null, "El cliente no fue insertado");
				
			}
			
			
		}
		
	}

	 ArrayList<VentaDTO>lista=new ArrayList<>();
	 VentaDAO usudao=new VentaDAO();
	 lista=usudao.consultageneralv();
	 Gson gson=new Gson();
	 out.print(gson.toJson(lista));
		
	
	
	
	}
	}
	
	
	
