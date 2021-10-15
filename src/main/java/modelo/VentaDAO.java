package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.conexion;

public class VentaDAO {
	
	conexion cn= new conexion();
	Connection cnn=cn.conexionbd();
	PreparedStatement ps=null;
	ResultSet rs=null;
	VentaDTO ven;
	
	
	
	public boolean insertarventa(VentaDTO ven) {
		
		boolean resultado=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO ventas(cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) VALUE(?,?,?,?,?)");
			ps.setLong(1,ven.getCedulacliente());
			ps.setLong(2,ven.getCedulausuario());
			ps.setDouble(3,ven.getIva());
			ps.setDouble(4,ven.getTotalventa());
			ps.setDouble(5,ven.getValorventa());
			resultado=ps.executeUpdate()>0;
			
			}catch(SQLException ex){
			 JOptionPane.showMessageDialog(null, "Error al Insertar: " +ex);
			}
			return resultado;
			} 
			
	public  VentaDTO consultarcodventa() {
		try {
			ps=cnn.prepareStatement("SELECT MAX(codigo_venta),cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta AS id FROM ventas");
			rs=ps.executeQuery();
			if(rs.next()) {
				
				JOptionPane.showMessageDialog(null, "En el if");
				 ven=new VentaDTO(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ven;
	
	}}
