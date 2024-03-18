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

		String respuesta = null;

		System.out.print("¿Esta escultura es subastable? (y/n): ");
		respuesta = sc.nextLine();

		if (respuesta.equalsIgnoreCase("y")) {

			subastable = true;
			System.out.println("Esta escultura ahora es subastable");

		} else {

			subastable = false;
			System.out.println("Esta escultura no se subastará");
		}

		return subastable;
	}

	@Override
	public String toString() {
	return "- Escultura | " + super.toString() + "Material: " + material;
	}

}
