package galeria;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * La clase abstracta Articulo representa un artículo de arte que puede ser
 * exhibido en una galería, almacenado en un almacén o vendido en una subasta.
 * Esta clase proporciona atributos y métodos comunes para todos los tipos de
 * artículos.
 */

public abstract class Articulo {

	static Scanner sc = new Scanner(System.in);

	// Variables

	protected String nombre;
	protected String autor;
	protected int anio;
	protected String descripcion;
	protected double precio;
	protected boolean subastable;
	protected Estado estado;
	protected LocalDate fechaVenta;

	// Constructores

	/**
	 * Constructor vacío.
	 */

	public Articulo() {
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param nombre      El nombre del artículo.
	 * @param autor       El autor del artículo.
	 * @param anio        El año de creación del artículo.
	 * @param descripcion La descripción del artículo.
	 * @param precio      El precio del artículo.
	 */

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

	/**
	 * Devuelve el nombre del artículo.
	 * 
	 * @return el nombre del artículo.
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del artículo.
	 * 
	 * @param nombre El nombre del artículo.
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el autor del artículo.
	 * 
	 * @return el autor del artículo.
	 */

	public String getAutor() {
		return autor;
	}

	/**
	 * Estable el autor del artículo.
	 * 
	 * @param autor El autor del artículo.
	 */

	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * Devuelve el año de creación del artículo.
	 * 
	 * @return el año de creación del artículo.
	 */

	public int getAnio() {
		return anio;
	}

	/**
	 * Establece el año de creación del artículo.
	 * 
	 * @param anio El año de creación del artículo.
	 */

	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * Devuelve la descripción del artículo.
	 * 
	 * @return la descripción del artículo.
	 */

	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del artículo.
	 * 
	 * @param descripcion La descripción del artículo.
	 */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el precio del artículo.
	 * 
	 * @return el precio del artículo.
	 */

	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del artículo.
	 * 
	 * @param precio El precio del artículo.
	 */

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Devuelve si es subastable el artículo.
	 * 
	 * @return true si es subastable, false si no.
	 */

	public boolean isSubastable() {
		return subastable;
	}

	/**
	 * Establece si el artículo es subastable.
	 * 
	 * @param subastable true si es subastable, false si no.
	 */

	public void setSubastable(boolean subastable) {
		this.subastable = subastable;
	}

	/**
	 * Devuelve el estado del artículo.
	 * 
	 * @return el estado del artículo.
	 */

	public Estado getEstado() {
		return estado;
	}

	/**
	 * Establece el estado del artículo.
	 * 
	 * @param estado El estado del artículo.
	 */

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * Devuelve la fecha de venta del artículo.
	 * 
	 * @return la fecha de venta del artículo.
	 */

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * Establece la fecha de venta del artículo.
	 * 
	 * @param fechaVenta La fecha de venta del artículo.
	 */

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * Método para imprimir los datos del artículo.
	 * 
	 * @return Una cadena que representa el artículo.
	 */

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nAutor: " + autor + "\nAño de creación: " + anio + "\nPrecio: " + precio
				+ "€\nDescripción: " + descripcion + "\nSubastable: " + subastable + "\nEstado: " + estado
				+ "\nFecha de Venta: " + fechaVenta;
	}

}
