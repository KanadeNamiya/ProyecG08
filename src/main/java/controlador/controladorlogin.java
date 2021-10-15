package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class controladorlogin
 */
@WebServlet("/controladorlogin")
public class controladorlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controladorlogin() {
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
		
		
			
		//login
		if(request.getParameter("BtnLoging")!=null) {
				String u,c;
				UsuariosDTO usudto;
				u=request.getParameter("user");
				c=request.getParameter("password");
				UsuariosDTO lo=new UsuariosDTO(u,c);
				UsuariosDAO lodao=new UsuariosDAO();
				usudto=lodao.loginUno(lo);
				
			
					if(usudto.getUsuario().equals(u) && usudto.getPassword().equals(c)) {
				
						 JOptionPane.showMessageDialog(null, "Datos correctos");
	                     String uss=usudto.getNombreusuario(); 
	                     JOptionPane.showMessageDialog(null, uss);
				
				sesion.setAttribute("llevadato",uss);
				sesion.setAttribute("cedusu",usudto);
				request.getRequestDispatcher("PaginaInicio.jsp").forward(request, response);
				//response.sendRedirect("PaginaInicio.jsp");
					}
				
				else {
										
					//JOptionPane.showMessageDialog(null, "Dato no encontrado usuario");
					response.sendRedirect("Login.jsp");
				}
				
				
			}
			
			
			
			
		
		
		if(request.getParameter("btnsal")!=null) {
			response.sendRedirect("Login.jsp");
			
			
		}
		
		
	}

}
