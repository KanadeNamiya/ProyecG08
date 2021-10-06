package modelo;

public class ProductoDTO {
	private long codproducto;
	private double iva;
	private long nit;
	private String nombrep;
	private double compra;
	private double venta;
	
	
	public ProductoDTO(long codproducto, double iva, long nit, String nombrep, double compra, double venta) {
		super();
		this.codproducto = codproducto;
		this.iva = iva;
		this.nit = nit;
		this.nombrep = nombrep;
		this.compra = compra;
		this.venta = venta;
	}
	

	public ProductoDTO(long codproducto) {
		super();
		this.codproducto = codproducto;
	}




	public long getCodproducto() {
		return codproducto;
	}


	public void setCodproducto(long codproducto) {
		this.codproducto = codproducto;
	}


	public double getIva() {
		return iva;
	}


	public void setIva(double iva) {
		this.iva = iva;
	}


	public long getNit() {
		return nit;
	}


	public void setNit(long nit) {
		this.nit = nit;
	}


	public String getNombrep() {
		return nombrep;
	}


	public void setNombrep(String nombrep) {
		this.nombrep = nombrep;
	}


	public double getCompra() {
		return compra;
	}


	public void setCompra(double compra) {
		this.compra = compra;
	}


	public double getVenta() {
		return venta;
	}


	public void setVenta(double venta) {
		this.venta = venta;
	}
	
	
	
	
	
	
}
