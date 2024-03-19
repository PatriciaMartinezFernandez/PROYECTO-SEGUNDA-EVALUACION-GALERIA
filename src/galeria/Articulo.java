package galeria;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Articulo {

	static Scanner sc = new Scanner(System.in);

	protected String nombre;
	protected String autor;
	protected int anio;
	protected String descripcion;
	protected double precio;
	protected boolean subastable;
	protected Estado estado;
	protected LocalDate fechaVenta;

	public Articulo() {
	}

	public Articulo(String nombre, String autor, int anio, String descripcion, double precio) {
		this.nombre = nombre;
		this.autor = autor;
		this.anio = anio;
		this.descripcion = descripcion;
		this.precio = precio;
		this.estado = Estado.EN_ALMACEN;
		this.fechaVenta = null;
		this.subastable = false;
	}

	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isSubastable() {
		return subastable;
	}

	public void setSubastable(boolean subastable) {
		this.subastable = subastable;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nAutor: " + autor + "\nAño de creación: " + anio + "\nPrecio: "
				+ precio + "€\nDescripción: " + descripcion + "\nSubastable: " + subastable + "\nEstado: " + estado
				+ "\nFecha de Venta: " + fechaVenta;
	}

}
