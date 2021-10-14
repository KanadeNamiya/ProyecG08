package modelo;

public class VentaDTO {

	private long cedulacliente ;
	private long cedulausuario ;
	private double iva;
	private double totalventa;
    private double valorventa;
	
       
    public VentaDTO( long cedulacliente, long cedulausuario, double iva, double totalventa,
			double valorventa) {
		
	
		this.cedulacliente = cedulacliente;
		this.cedulausuario = cedulausuario;
		this.iva = iva;
		this.totalventa = totalventa;
		this.valorventa = valorventa;
	}
	
	
	public long getCedulacliente() {
		return cedulacliente;
	}
	public void setCedulacliente(long cedulacliente) {
		this.cedulacliente = cedulacliente;
	}
	public long getCedulausuario() {
		return cedulausuario;
	}
	public void setCedulausuario(long cedulausuario) {
		this.cedulausuario = cedulausuario;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotalventa() {
		return totalventa;
	}
	public void setTotalventa(double totalventa) {
		this.totalventa = totalventa;
	}
	
	public double getValorventa() {
		return valorventa;
	}
	public void setValorventa(double valorventa) {
		this.valorventa = valorventa;
	}











}

	
	
	
	