package clases;



public class Direccion {
	protected int id;
	protected int idUsuario;
	protected String nombre;
	protected String calle;
	protected String municipio;
	protected int portal;
	protected String pisoPuerta;
	protected int codigoPostal;
	
	
	public Direccion(String nombre, int idUsuario, String calle, String municipio, int portal, String pisoPuerta, int codigoPostal) {
		super();
		this.nombre =  nombre;
		this.idUsuario = idUsuario;
		this.calle =  calle;
		this.municipio =  municipio;
		this.portal =  portal;
		this.pisoPuerta =  pisoPuerta;
		this.codigoPostal =  codigoPostal;
	}
	
	public Direccion() {
		super();
		this.nombre =  "";
		this.idUsuario = 0;
		this.calle =  "";
		this.municipio =  "";
		this.portal =  0;
		this.pisoPuerta =  "";
		this.codigoPostal =  0;
	}
	
	public String getCalle() {
		return calle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}



	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getPortal() {
		return portal;
	}

	public void setPortal(int portal) {
		this.portal = portal;
	}

	public String getPisoPuerta() {
		return pisoPuerta;
	}

	public void setPisoPuerta(String pisoPuerta) {
		this.pisoPuerta = pisoPuerta;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre + ": " + municipio + " (" + codigoPostal + ") " + " / " + calle + " / " + portal + " / " + pisoPuerta;
	}

	public Object getDireccion() {
		return null;
	}

	
	
	
}
