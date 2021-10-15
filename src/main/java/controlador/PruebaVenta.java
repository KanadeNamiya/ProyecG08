package controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.DetalleVentaDAO;
import modelo.DetalleVentaDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.VentaDAO;
import modelo.VentaDTO;



/**
 * Servlet implementation class PruebaVenta
 */
@WebServlet("/PruebaVenta")
public class PruebaVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva,iva1,iva2;   
	int  cant1,cant2,cant3;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaVenta() {
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
		if(request.getParameter("enviarcel")!=null) {
		long cedula,ced;
		String nom;
	
		
		ClienteDTO listado;
		cedula=Long.parseLong(request.getParameter("cedulacliente"));
		ClienteDAO clidao=new ClienteDAO();
		ClienteDTO clidto=new ClienteDTO(cedula);
		listado=clidao.consultarcliente(clidto);
		
		 sesion.setAttribute("cliente",listado);
		
		 request.getRequestDispatcher("PaginaVentas.jsp").forward(request, response);
		}
		
		
		
		if(request.getParameter("consultarProducto1")!=null) {
			
			long codpro;
			ProductoDTO listapro;
			codpro=Long.parseLong(request.getParameter("codigoproducto1"));
			ProductoDTO podto=new ProductoDTO(codpro);
			ProductoDAO prodao=new ProductoDAO();
			listapro=prodao.consultarproducto(podto);
			iva= listapro.getIva() ;
			sesion.setAttribute("cp",listapro);
			request.getRequestDispatcher("PaginaVentas.jsp").forward(request, response);
			
			
			
		} 
		
		if(request.getParameter("consultarProducto2")!=null) {
			long codpro;
			ProductoDTO listapro1;
			codpro=Long.parseLong(request.getParameter("codigoproducto2"));
			ProductoDTO podto=new ProductoDTO(codpro);
			ProductoDAO prodao=new ProductoDAO();
			listapro1=prodao.consultarproducto(podto);
			iva1= listapro1.getIva() ;
			sesion.setAttribute("cp2",listapro1);
			request.getRequestDispatcher("PaginaVentas.jsp").forward(request, response);
			
			
			
		} 
		if(request.getParameter("consultarProducto3")!=null) {
			long codpro;
			ProductoDTO listapro2;
			codpro=Long.parseLong(request.getParameter("codigoproducto3"));
			ProductoDTO podto=new ProductoDTO(codpro);
			ProductoDAO prodao=new ProductoDAO();
			listapro2=prodao.consultarproducto(podto);
			iva2= listapro2.getIva() ;
			
			sesion.setAttribute("cp3",listapro2);
			request.getRequestDispatcher("PaginaVentas.jsp").forward(request, response);
			
			
			
		} 
		double tot,tot1,tot2,res,res1,res2,totalsiniva,totaliva,totaldesiva;
		
	
		
		
		if(request.getParameter("EnviarV")!=null) {
		   double total1,total2,total3;
		   JOptionPane.showMessageDialog(null, "Prueva 1");
		  
			cant1=Integer.parseInt(request.getParameter("cantidad1"));
			cant2=Integer.parseInt(request.getParameter("cantidad2"));
			cant3=Integer.parseInt(request.getParameter("cantidad3"));
			JOptionPane.showMessageDialog(null, "Prueva 2");
			tot=Double.parseDouble(request.getParameter("precioproducto1"));
			tot1=Double.parseDouble(request.getParameter("precioproducto2"));
			tot2=Double.parseDouble(request.getParameter("precioproducto3"));
			
			JOptionPane.showMessageDialog(null, "Prueva 3");
			res=cant1*tot;
			res1=cant2*tot1;
			res2=cant3*tot2;
			total1=res*iva/100;
			total2=res1*iva1/100;
			total3=res2*iva2/100;
			totalsiniva=res+res1+res2;
			totaliva=total1+total2+total3;
			totaldesiva=totalsiniva+totaliva;
			
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n");
			//JOptionPane.showMessageDialog(null,"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n");
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n");
		    
			int i=JOptionPane.showConfirmDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n" );
		     JOptionPane.showMessageDialog(null, "impriendo la i: "+i);
		    if(i==0) {
			    String cedcli,cedusu;
			    long cc,cu;
			    double iva,tv,vv;
			    boolean ress;
			    cedcli=(request.getParameter("cedulacliente"));
			    cedusu=(request.getParameter("codigone"));
			    iva=totaliva;
			    tv=totalsiniva;
			    vv=totaldesiva;
			    cc=Long.parseLong(cedcli);
			    cu=Long.parseLong(cedusu);
			    VentaDTO ven=new VentaDTO(cc, cu, iva, tv,vv);
			    VentaDAO vendao=new VentaDAO();
			    ress=vendao.insertarventa(ven);
			    JOptionPane.showMessageDialog(null, "Prueba 4");
			    
			    if(ress) {
			    JOptionPane.showMessageDialog(null, "Venta registrada");
			    int can;
			    long cv;
			    double iv,dtv,dvv;
			    boolean x;
			    VentaDTO venn;
			    DetalleVentaDTO dd;
			    DetalleVentaDAO dedao;
			    long codpro=Long.parseLong(request.getParameter("codigoproducto1"));
			    VentaDAO vend=new VentaDAO();
			    venn=vend.consultarcodventa();
			  
			     can=cant1;
			     if(can>0) {
			   
				    cv=venn.getCodigoventa();
				    iv=ven.getIva();
				    dtv=ven.getTotalventa();
				    dvv=ven.getValorventa();
				    dd=new DetalleVentaDTO(can, cv, codpro, total3, iva, iva);
				    dedao=new DetalleVentaDAO();
				    x=dedao.Inserta_Cliente(dd);
				    	if(x) {
				    		JOptionPane.showMessageDialog(null, "detalle insertado");
				    	}
			     }
			     
			     
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     can=cant2;
			     if(can>0) {
					   
					    cv=venn.getCodigoventa();
					    iv=ven.getIva();
					    dtv=ven.getTotalventa();
					    dvv=ven.getValorventa();
					    dd=new DetalleVentaDTO(can, cv, codpro, total3, iva, iva);
					    dedao=new DetalleVentaDAO();
					    x=dedao.Inserta_Cliente(dd);
					    	if(x) {
					    		JOptionPane.showMessageDialog(null, "detalle insertado");
					    	}
					     }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     can=cant3;
			     if(can>0) {
					   
					    cv=venn.getCodigoventa();
					    iv=ven.getIva();
					    dtv=ven.getTotalventa();
					    dvv=ven.getValorventa();
					    dd=new DetalleVentaDTO(can, cv, codpro, total3, iva, iva);
					    dedao=new DetalleVentaDAO();
					    x=dedao.Inserta_Cliente(dd);
					    if(x) {
					    	JOptionPane.showMessageDialog(null, "detalle insertado");
					    	response.sendRedirect("PaginaInicio.jsp");
					    }
				 }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     
			     
			     
			    }
			    
			    else {
			    	JOptionPane.showMessageDialog(null, "Venta NO registrada");
			    	response.sendRedirect("PaginaVentas.jsp");
			    }
			    	
		  }
		    else {
		    	JOptionPane.showMessageDialog(null, "Error en boton");  
		    
		}		    
	}
		
	}
	 
}
