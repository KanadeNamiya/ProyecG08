package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		String u,c;
		String password,usuario;
		UsuariosDTO usudto;
		UsuariosDAO usudao;
		UsuariosDTO registro;
		
		
		//salir
		if(request.getParameter("btnsal")!=null) {
			response.sendRedirect("Login.jsp");
			
			
		}
		//login
		if(request.getParameter("BtnLoging")!=null) {
		
			u=request.getParameter("user");
			c=request.getParameter("password");
			if (u.equals("admininicial")&& c.equals("admin123456")) {
				JOptionPane.showMessageDialog(null, "Bienvenido");
				response.sendRedirect("PaginaInicio.jsp");
			}
			
			else {
				
				usuario=request.getParameter("user");
				password=request.getParameter("password");
				usudto=new UsuariosDTO(usuario,password);
				usudao=new UsuariosDAO();
				registro=usudao.loginUno(usudto);
				
					if(registro!=null) {
				response.sendRedirect("PaginaInicio.jsp");
					}
				
				else {
										
					//JOptionPane.showMessageDialog(null, "Dato no encontrado usuario");
					response.sendRedirect("Login.jsp");
				}
				
				
			}
			
			
			
			
		}
		
		
	}

}
