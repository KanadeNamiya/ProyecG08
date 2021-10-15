package modelo;

public class VentaDTO {
    private long codigoventa;
	private long cedulacliente ;
	private long cedulausuario ;
	private double iva;
	private double totalventa;
    private double valorventa;
    
       
    public VentaDTO(long cedulacliente, long Cedulausuario, double iva, double totalventa, double valorventa) {
    	super();
		this.cedulacliente = cedulacliente;
		cedulausuario = Cedulausuario;
		this.iva = iva;
		this.totalventa = totalventa;
		this.valorventa = valorventa;
	}
    
    public long getCodigoventa() {
		return codigoventa;
	}


	public void setCodigoventa(long codigoventa) {
		this.codigoventa = codigoventa;
	}
	

	public VentaDTO( long codigoventa,long cedulacliente, long Cedulausuario, double iva, double totalventa,
		double valorventa) {
		super();
	    this.codigoventa=codigoventa;
		this.cedulacliente = cedulacliente;
		cedulausuario = Cedulausuario;
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

	
	
	
	