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

	@Override
	public String toString() {
		return "\n======= CUADRO =======\n" + super.toString() + "\nTécnica: " + tecnica + "\n=======================";
	}

}
