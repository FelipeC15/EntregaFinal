package construccion4.construccion4.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="socio")
public class Socio {
	
	@Id
	@Column(name = "cedula")
	private int cedula;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "TipSuscripcion")
	private String tipSuscripcion;
	@Column(name = "Fondos")
	private double fondos;
	
	
	// NUEVA, se crea para realizar la validacion en el total de facturas
	@Column(name="limite_facturas")
	private int limiteFacturas;
	
	
	public Socio() {
		this.limiteFacturas=10;
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
	public String getTipSuscripcion() {
		return tipSuscripcion;
	}
	public void setTipSuscripcion(String tipSuscripcion) {
		this.tipSuscripcion = tipSuscripcion;
		
	}
	public double getFondos() {
		return fondos;
	}
	public void setFondos(double fondos) {
		this.fondos = fondos;
	}
	
	
	
	public int getLimiteFacturas() {
		return limiteFacturas;
	}
	public void setLimiteFacturas(int limiteFacturas) {
		this.limiteFacturas = limiteFacturas;
	}
	public String mostrarDatos() {
		return "\n nombre: " + this.getNombre() +
				"\n cedula: " + this.getCedula() +
				"\n fondos: " + this.getFondos() +
				"\n tipsuscripcion: " + this.getTipSuscripcion();
				
	}
	
	
	
	
	

}
