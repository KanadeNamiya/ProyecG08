package modelo;

import java.sql.*;

import javax.swing.JOptionPane;

import controlador.conexion;

public class ProductoDAO {
	
	conexion cn= new conexion();
	Connection cnn=cn.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ProductoDTO usdto=null;
	
	public boolean insertarproductos(ProductoDTO us) {
		int c;
		boolean d=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO productos VALUES(?,?,?,?,?,?)");
			ps.setLong(1,us.getCodproducto());
			ps.setDouble(2,us.getIva());
			ps.setLong(3,us.getNit());
			ps.setString(4,us.getNombrep());
			ps.setDouble(5,us.getCompra());
			ps.setDouble(6,us.getVenta());
			c=ps.executeUpdate();
			if (c>0) {
				d=true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	public ProductoDTO consultarproducto(ProductoDTO us) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos where codigo_producto=? ");
			ps.setLong(1, us.getCodproducto());
			rs=ps.executeQuery();
			if(rs.next()) {
				usdto= new ProductoDTO(rs.getLong(1),rs.getLong(2),rs.getLong(3),rs.getString(4),rs.getLong(5),rs.getLong(6));
			}
			else {
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usdto;
	}
	public int actualizarproducto(ProductoDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("UPDATE productos SET ivacompra=?,nombre_producto=?,precio_compra=?,precio_venta=? WHERE codigo_producto=?");
			ps.setDouble(1,us.getIva());
			
			ps.setString(2,us.getNombrep());
			ps.setDouble(3,us.getCompra());
			ps.setDouble(4,us.getVenta());
			ps.setLong(5,us.getCodproducto());
			x=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	public int eliminarproducto(ProductoDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM productos WHERE codigo_producto=?");
			ps.setLong(1, us.getCodproducto());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;

	}
	
	public boolean cargarproducto(String Url) {
		JOptionPane.showMessageDialog(null, "en dao"+Url);
		boolean resul=false;
		try {
			
			ps=cnn.prepareStatement("load data infile '"+Url+"' into table productos fields terminated by ';' lines terminated by '\r\n';");
			resul=ps.executeUpdate()>0;
		
		}catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, "datos no cargados el archivo"+ e);	
		}
		return resul;
	}
	

}