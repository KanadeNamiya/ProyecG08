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
	PreparedStatement ps;
	ResultSet rs;
	VentaDTO usdto=null;
	
	
	
	public boolean insertarventa(VentaDTO us) {
		int c;
		boolean d=false;
		
		try {
			ps=cnn.prepareStatement("INSERT INTO ventas VALUES(?,?,?,?,?,?)");
			ps.setLong(1, us.getCodigoventa());
			ps.setDouble(2,us.getCedulacliente());
			ps.setLong(3,us.getCedulausuario());
			ps.setDouble(4,us.getIva());
			ps.setDouble(5,us.getTotalventa());
			ps.setDouble(6,us.getValorventa());
			c=ps.executeUpdate();
			if (c>0) {
				d=true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	
	}}
