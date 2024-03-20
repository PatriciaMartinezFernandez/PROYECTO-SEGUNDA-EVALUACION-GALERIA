package galeria;

/**
 * La clase Cuadro representa un cuadro que puede ser exhibido en una galería,
 * almacenado en un almacén o vendido en una subasta. Esta clase extiende de
 * Articulo e implementa la interfaz Subastable.
 */

public class Cuadro extends Articulo implements Subastable {

	// Variable

	private Tecnica tecnica;

	// Constructores

	/**
	 * Constructor vacío.
	 */

	public Cuadro() {
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param nombre      El nombre del cuadro.
	 * @param autor       El autor del cuadro.
	 * @param anio        El año que fue pintado el cuadro.
	 * @param descripcion La descripción del cuadro.
	 * @param precio      El precio del cuadro.
	 * @param tecnica     La técnica utilizada para pintar el cuadro.
	 */

	public Cuadro(String nombre, String autor, int anio, String descripcion, double precio, Tecnica tecnica) {
		super(nombre, autor, anio, descripcion, precio);
		this.tecnica = tecnica;
	}

	// Métodos

	/**
	 * Método para determinar si el cuadro es subastable o no.
	 * 
	 * @return true si el cuadro es subastable, false si no lo es.
	 */

	@Override
	public boolean articuloSubastable() {
		String respuesta = "";

		boolean entradaValida = false;
		do {
			System.out.print("¿Este cuadro es subastable? (y/n): ");
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("y")) {
				subastable = true;
				System.out.println("Este cuadro ahora es subastable");
			} else if (respuesta.equalsIgnoreCase("n")) {
				subastable = false;
				System.out.println("Este cuadro no se subastará");
			} else {
				System.out.println("Respuesta inválida. Por favor, responda con 'y' o 'n'.");
				continue;
			}
			entradaValida = true;
		} while (!entradaValida);

		return subastable;
	}

	/**
	 * Método para imprimir los datos del cuadro.
	 * 
	 * @return Una cadena que representa el cuadro.
	 */

	@Override
	public String toString() {
		return "\n======= CUADRO =======\n" + super.toString() + "\nTécnica: " + tecnica + "\n=======================";
	}

}
