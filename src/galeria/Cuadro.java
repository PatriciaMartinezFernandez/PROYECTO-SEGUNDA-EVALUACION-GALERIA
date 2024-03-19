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

		String respuesta = "";

		System.out.print("¿Este cuadro es subastable? (y/n): ");
		respuesta = sc.nextLine();

		if (respuesta.equalsIgnoreCase("y")) {

			this.subastable = true;
			System.out.println("Este cuadro ahora es subastable");

		} else {

			this.subastable = false;
			System.out.println("Este cuadro no se subastará");
		}

		return subastable;
	}

	@Override
	public String toString() {
		return "\n======= CUADRO =======\n" + super.toString() + "\nTécnica: " + tecnica + "\n=======================";
	}

}
