package galeria;

public class Cuadro extends Articulo implements Subastable {

	// Variable
	private Tecnica tecnica;

	// Constructores
	public Cuadro() {
	}

	public Cuadro(String nombre, String autor, int anio, String descripcion, double precio, Tecnica tecnica) {
		super(nombre, autor, anio, descripcion, precio);
		this.tecnica = tecnica;
	}

	// Métodos
	@Override
	public boolean articuloSubastable() {

		String respuesta = null;

		System.out.print("¿Este cuadro es subastable? (y/n): ");
		respuesta = sc.nextLine();

		if (respuesta.equalsIgnoreCase("y")) {

			subastable = true;
			System.out.println("Este cuadro ahora es subastable");

		} else {

			subastable = false;
			System.out.println("Este cuadro no se subastará");
		}

		return subastable;
	}

	@Override
	public String toString() {
		return "- Cuadro    | " + super.toString() + "Técnica: " + tecnica;
	}

}
