package construccion4.construccion4.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	//@ManyToOne // relacionde clave foranea de muchoa a uno adonde cedula es elemento de otra
	// tabla,al hacer el registro valida en otra clase y si no hay revienta


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(name = "cedula")   //@Id   @Column(name = "cedula_persona") 	
private int cedula;
@Column(name = "Concepto")
private String concepto;
@Column(name = "Monto")
private double monto;
@Column(name = "MontoPagado")
private double montoPagado;





public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getCedula() {
	return cedula;
}
public void setCedula(int cedula) {
	this.cedula = cedula;
}
public String getConcepto() {
	return concepto;
}
public void setConcepto(String concepto) {
	this.concepto = concepto;
}
public double getMonto() {
	return monto;
}
public void setMonto(double monto) {
	this.monto = monto;
}
public double getMontoPagado() {
	return montoPagado;
}
public void setMontoPagado(double montoPagado) {
	this.montoPagado = montoPagado;
}

	
public String mostrarDatos() {
	return "\n nombre: " + this.getId() +
			"\n cedula: " + this.getCedula() +
			"\n fondos: " + this.getConcepto() +
			"\n tipsuscripcion: " + this.getMonto();
	

	
	
}


	
}