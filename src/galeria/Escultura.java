package galeria;

/**
 * La clase Escultura representa una escultura que puede ser exhibida en una
 * galería, almacenada en un almacén o vendida en una subasta. Esta clase
 * extiende de Articulo e implementa la interfaz Subastable.
 */

public class Escultura extends Articulo implements Subastable {

	// Variable

	private Material material;

	// Constructores

	/**
	 * Constructor vacío.
	 */

	public Escultura() {
	}

	/**
	 * Constructor con parámetros.
	 * 
	 * @param nombre      El nombre de la escultura.
	 * @param autor       El autor de la escultura.
	 * @param anio        El año que fue hecha la escultura.
	 * @param descripcion La descripción de la escultura.
	 * @param precio      El precio de la escultura.
	 * @param material    El material de la escultura.
	 */

	public Escultura(String nombre, String autor, int anio, String descripcion, double precio, Material material) {
		super(nombre, autor, anio, descripcion, precio);
		this.material = material;
	}

	// Métodos

	/**
	 * Método para determinar si la escultura es subastable o no.
	 * 
	 * @return true si la escultura es subastable, false si no lo es.
	 */

	@Override
	public boolean articuloSubastable() {
		String respuesta = "";

		boolean entradaValida = false;
		do {
			System.out.print("¿Esta escultura es subastable? (y/n): ");
			respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("y")) {
				subastable = true;
				System.out.println("Esta escultura ahora es subastable");
			} else if (respuesta.equalsIgnoreCase("n")) {
				subastable = false;
				System.out.println("Esta escultura no se subastará");
			} else {
				System.out.println("Respuesta inválida. Por favor, responda con 'y' o 'n'.");
				continue;
			}
			entradaValida = true;
		} while (!entradaValida);

		return subastable;
	}

	/**
	 * Método para imprimir los datos de la escultura.
	 * 
	 * @return Una cadena que representa la escultura.
	 */

	@Override
	public String toString() {
		return "\n===== ESCULTURA =====\n" + super.toString() + "\nMaterial: " + material + "\n=====================";
	}

}
