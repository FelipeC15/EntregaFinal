package construccion4.construccion4.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="autorizado")
public class Autorizado extends Socio {
	
	@JoinColumn(name = "SocioPrincipal")
    private int socioPrincipal;
	
	@Id
	@Column(name = "cedula")
	private int cedula;
	@Column(name = "nombre")
	private String nombre;
	
	
  	 
  	public int getSocioPrincipal() {
		return socioPrincipal;
	}
	public void setSocioPrincipal(int socioPrincipal) {
		this.socioPrincipal = socioPrincipal;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
