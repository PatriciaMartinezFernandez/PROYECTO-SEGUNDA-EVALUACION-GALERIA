package galeria;


public class Escultura extends Articulo implements Subastable {

	// Variable
	private Material material;

	// Constructores
	public Escultura() {
	}

	public Escultura(String nombre, String autor, int anio, String descripcion, double precio, Material material) {
		super(nombre, autor, anio, descripcion, precio);
		this.material = material;
	}

	// Métodos
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

	@Override
	public String toString() {
		return "\n===== ESCULTURA =====\n" + super.toString() + "\nMaterial: " + material + "\n=====================";
	}

}
