package galeria;

import java.util.Scanner;

public class Galeria {

	static Scanner sc = new Scanner(System.in);

	// Variable
	private Articulo[] articulos = new Articulo[0];

	// Constructor
	public Galeria() {
		this.articulos = new Articulo[0];
	}

	// Getters y setters
	public Articulo[] getArticulos() {
		return articulos;
	}

	public void setArticulos(Articulo[] articulos) {
		this.articulos = articulos;
	}

	// Métodos
	public void aniadirArticulo() {

		int menu = 0, anio = 0;
		String nombre, autor, descripcion;
		double precio = 0;
		Tecnica tecnica = null;
		Material material = null;
		Cuadro cuadro = new Cuadro();
		Escultura escultura = new Escultura();

		System.out.println("=======================");
		System.out.println("¿Qué tipo de artículo?: ");
		System.out.println("1) Cuadro");
		System.out.println("2) Escultura");
		System.out.println("=======================");
		menu = sc.nextInt();
		sc.nextLine();

		if (menu == 1) {

			System.out.print("Nombre del cuadro: ");
			nombre = sc.nextLine();
			System.out.print("Autor del cuadro: ");
			autor = sc.nextLine();
			System.out.print("Año del cuadro: ");
			anio = sc.nextInt();
			sc.nextLine();
			System.out.println("Descripción del cuadro: ");
			descripcion = sc.nextLine();
			System.out.print("Precio del cuadro: ");
			precio = sc.nextDouble();
			sc.nextLine();
			System.out.println("Técnica del cuadro: ");
			System.out.println("1) Acrilico");
			System.out.println("2) Oleo");
			System.out.println("3) Acuarela");
			System.out.println("4) Gouache");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			default:
				System.out.println("Opción no válida.");
				break;

			case 1:
				tecnica = Tecnica.ACRILICO;
				break;

			case 2:
				tecnica = Tecnica.OLEO;
				break;

			case 3:
				tecnica = Tecnica.ACUARELA;
				break;

			case 4:
				tecnica = Tecnica.GOUACHE;
				break;

			}

			Articulo[] temp = articulos;
			articulos = new Articulo[articulos.length + 1];

			for (int i = 0; i < temp.length; i++) {
				articulos[i] = temp[i];
			}

			articulos[articulos.length - 1] = new Cuadro(nombre, autor, anio, descripcion, precio, tecnica);

			articulos[articulos.length - 1].setSubastable(cuadro.articuloSubastable());

			System.out.println("=======================");

		} else if (menu == 2) {

			System.out.print("Nombre de la escultura: ");
			nombre = sc.nextLine();
			nombre = sc.nextLine();
			System.out.print("Autor de la escultura: ");
			autor = sc.nextLine();
			System.out.print("Año de la escultura: ");
			anio = sc.nextInt();
			sc.nextLine();
			System.out.println("Descripción de la escultura: ");
			descripcion = sc.nextLine();
			System.out.print("Precio de la escultura: ");
			precio = sc.nextDouble();
			sc.nextLine();
			System.out.println("Material de la escultura: ");
			System.out.println("1) Arcilla");
			System.out.println("2) Piedra");
			System.out.println("3) Madera");
			System.out.println("4) Marfil");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {

			default:
				System.out.println("Opción no válida.");
				break;

			case 1:
				material = Material.ARCILLA;
				break;

			case 2:
				material = Material.PIEDRA;
				;
				break;

			case 3:
				material = Material.MADERA;
				break;

			case 4:
				material = Material.MARFIL;
				break;

			}

			Articulo[] temp = articulos;
			articulos = new Articulo[articulos.length + 1];

			for (int i = 0; i < temp.length; i++) {
				articulos[i] = temp[i];
			}

			articulos[articulos.length - 1] = new Escultura(nombre, autor, anio, descripcion, precio, material);

			articulos[articulos.length - 1].setSubastable(escultura.articuloSubastable());

			System.out.println("=======================");

		} else {
			System.out.println("Opción inválida.");
			System.out.println("=======================");

		}

	}

	public void eliminarArticulo() {
		String nombre;
		boolean encontrado = false;
		int i = 0;

		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {
			System.out.print("¿Qué artículo quieres eliminar? Introduce su nombre: ");
			nombre = sc.nextLine();

			do {
				if (articulos[i].getNombre().equals(nombre)) {
					encontrado = true;
					for (int j = i; j < articulos.length - 1; j++) {
						articulos[j] = articulos[j + 1];
					}
					Articulo[] temp = new Articulo[articulos.length - 1];
					for (int k = 0; k < temp.length; k++) {
						temp[k] = articulos[k];
					}
					articulos = temp;
				} else {
					i++;
				}
			} while (i < articulos.length && !encontrado);
		}

		if (!encontrado) {
			System.out.println("Ese artículo no existe");
		} else {
			System.out.println("Artículo eliminado correctamente");
		}
	}

	public void editarArticulo() {

		String nombre, autor, descripcion;
		boolean encontrado = false;
		int i = 0, menu = 0, anio = 0;
		double precio = 0;

		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {
			System.out.print("¿Qué artículo quieres editar? Introduce su nombre: ");
			nombre = sc.nextLine();

			do {

				if (articulos[i].getNombre().equals(nombre)) {

					encontrado = true;

					System.out.println("=====================");
					System.out.println("¿Qué quieres editar?");
					System.out.println("=====================");
					System.out.println("1) Nombre");
					System.out.println("2) Autor");
					System.out.println("3) Año");
					System.out.println("4) Descripción");
					System.out.println("5) Precio");
					System.out.println("6) Subastable");
					System.out.println("=====================");
					menu = sc.nextInt();
					sc.nextLine();

					switch (menu) {

					default:
						System.out.println("Opción inválida");
						break;

					case 1:
						System.out.print("Introduce nuevo nombre: ");
						nombre = sc.nextLine();
						articulos[i].setNombre(nombre);
						System.out.println("Nombre cambiado");
						break;

					case 2:
						System.out.print("Introduce nuevo autor: ");
						autor = sc.nextLine();
						articulos[i].setAutor(autor);
						System.out.println("Autor cambiado");
						break;

					case 3:
						System.out.print("Introduce nuevo año: ");
						anio = sc.nextInt();
						sc.nextLine();
						articulos[i].setAnio(anio);
						System.out.println("Año cambiado");
						break;

					case 4:
						System.out.print("Introduce nueva descripción: ");
						descripcion = sc.nextLine();
						articulos[i].setDescripcion(descripcion);
						System.out.println("Descripción cambiada");
						break;

					case 5:
						System.out.print("Introduce nuevo precio: ");
						precio = sc.nextDouble();
						sc.nextLine();
						articulos[i].setPrecio(precio);
						System.out.println("Precio cambiado");
						break;

					case 6:
						if (articulos[i] instanceof Cuadro) {
							System.out.println(((Cuadro) articulos[i]).articuloSubastable());
						} else {
							System.out.println(((Escultura) articulos[i]).articuloSubastable());
						}
						break;
					}

				} else {
					i++;
				}

			} while (!encontrado && i < articulos.length);

			if (encontrado == false) {
				System.out.println("Ese artículo no existe.");
			}
		}
	}

	public void almacenarArticulo() {

		String nombre;
		boolean encontrado = false;
		int i = 0;

		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {
			System.out.print("¿Qué artículo quieres almacenar? Introduce su nombre: ");
			nombre = sc.nextLine();

			do {

				if (articulos[i].getNombre().equals(nombre)) {

					encontrado = true;

					if (articulos[i].getEstado() == Estado.EN_ALMACEN) {
						System.out.println("Este artículo ya está en el almacén");
					} else if (articulos[i].getEstado() == Estado.VENDIDO) {
						System.out.println("Este artículo ha sido vendido en subasta");
					} else {
						articulos[i].setEstado(Estado.EN_ALMACEN);
						System.out.println("El artículo ha sido almacenado");
					}

				} else {
					i++;
				}

			} while (!encontrado && i < articulos.length);

			if (!encontrado) {
				System.out.println("Ese artículo no existe");
			}

		}

	}

	public void exponerArticulo() {

		String nombre;
		boolean encontrado = false;
		int i = 0;

		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {
			System.out.print("¿Qué artículo quieres exponer? Introduce su nombre: ");
			nombre = sc.nextLine();

			do {

				if (articulos[i].getNombre().equals(nombre)) {

					encontrado = true;

					if (articulos[i].getEstado() == Estado.EN_EXPOSICION) {
						System.out.println("Este artículo ya está en exposición");
					} else if (articulos[i].getEstado() == Estado.VENDIDO) {
						System.out.println("Este artículo ha sido vendido en subasta");
					} else {
						articulos[i].setEstado(Estado.EN_EXPOSICION);
						System.out.println("El artículo ahora está expuesto en la galería");
					}

				} else {
					i++;
				}

			} while (!encontrado && i < articulos.length);

			if (!encontrado) {
				System.out.println("Ese artículo no existe");
			}

		}

	}

	public void listarDesordenado() {

		System.out.println("====== ARTICULOS ======");

		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {

			for (Articulo articulo : articulos) {

				if (articulo instanceof Cuadro) {
					System.out.println(((Cuadro) articulo).toString());
				} else {
					System.out.println(((Escultura) articulo).toString());
				}
			}
		}

	}

	public void listarOrdenadoPorNombre() {

		int menu = 0;

		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {

			System.out.println("=======================");
			System.out.println("1) Ascendentemente");
			System.out.println("2) Descendentemente");
			System.out.println("=======================");
			menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {
				ordenadoAscendente();
			} else if (menu == 2) {
				ordenadoDescendente();
			} else {
				System.out.println("Opción inválida");
			}
		}

	}

	private void ordenadoAscendente() {

		Articulo[] ascendente = articulos;

		for (int i = 0; i < ascendente.length - 1; i++) {
			for (int j = 0; j < ascendente.length - i - 1; j++) {
				if (ascendente[j].getNombre().compareTo(ascendente[j + 1].getNombre()) > 0) {
					Articulo temp = ascendente[j];
					ascendente[j] = ascendente[j + 1];
					ascendente[j + 1] = temp;
				}
			}
		}
		for (Articulo articulo : ascendente) {
			System.out.println(articulo);
		}

	}

	private void ordenadoDescendente() {

		Articulo[] descendente = articulos;

		for (int i = 0; i < descendente.length - 1; i++) {
			for (int j = 0; j < descendente.length - i - 1; j++) {
				if (descendente[j].getNombre().compareTo(descendente[j + 1].getNombre()) < 0) {
					Articulo temp = descendente[j];
					descendente[j] = descendente[j + 1];
					descendente[j + 1] = temp;
				}
			}
		}
		for (Articulo articulo : descendente) {
			System.out.println(articulo);

		}
	}

	public void listarOrdenadoPorAnio() {

		Articulo[] ordenado = articulos;

		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {

			for (int i = 0; i < ordenado.length - 1; i++) {
				for (int j = 0; j < ordenado.length - i - 1; j++) {
					if (ordenado[j].getAnio() > ordenado[j + 1].getAnio()) {
						Articulo temp = ordenado[j];
						ordenado[j] = ordenado[j + 1];
						ordenado[j + 1] = temp;
					}
				}
			}
			for (Articulo articulo : ordenado) {
				System.out.println(articulo);
			}
		}
	}

	public void listarOrdenadoPorAutor() {

		Articulo[] ordenado = articulos;

		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {

			for (int i = 0; i < ordenado.length - 1; i++) {
				for (int j = 0; j < ordenado.length - i - 1; j++) {
					if (ordenado[j].getAutor().compareTo(ordenado[j + 1].getAutor()) < 0) {
						Articulo temp = ordenado[j];
						ordenado[j] = ordenado[j + 1];
						ordenado[j + 1] = temp;
					}
				}
			}
			for (Articulo articulo : ordenado) {
				System.out.println(articulo);

			}
		}
	}

	public void listarAlmacen() {
		int contadorAlmacen = 0;

		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_ALMACEN)) {
				contadorAlmacen++;
			}
		}

		Articulo[] almacen = new Articulo[contadorAlmacen];

		int indiceAlmacen = 0;

		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_ALMACEN)) {
				almacen[indiceAlmacen] = articulo;
				indiceAlmacen++;
			}
		}

		if (contadorAlmacen == 0) {
			System.out.println("No hay artículos en el almacén");
		} else {
			System.out.println("Artículos en el almacén:");
			for (Articulo articulo : almacen) {
				System.out.println(articulo);
			}
		}
	}

	public void listarExposicion() {

		int contadorExposicion = 0;

		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_EXPOSICION)) {
				contadorExposicion++;
			}
		}

		Articulo[] exposicion = new Articulo[contadorExposicion];

		int indiceExposicion = 0;

		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_EXPOSICION)) {
				exposicion[indiceExposicion] = articulo;
				indiceExposicion++;
			}
		}

		if (contadorExposicion == 0) {
			System.out.println("No hay artículos en la exposición");
		} else {
			System.out.println("Artículos en la exposición:");
			for (Articulo articulo : exposicion) {
				System.out.println(articulo);
			}
		}

	}

	public void listarVendidos() {

		int contadorVendidos = 0;

		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_EXPOSICION)) {
				contadorVendidos++;
			}
		}

		Articulo[] vendidos = new Articulo[contadorVendidos];

		int indiceVendidos = 0;

		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_EXPOSICION)) {
				vendidos[indiceVendidos] = articulo;
				indiceVendidos++;
			}
		}

		if (contadorVendidos == 0) {
			System.out.println("No hay artículos vendidos");
		} else {
			System.out.println("Artículos que han sido vendidos en una subasta:");
			for (Articulo articulo : vendidos) {
				System.out.println(articulo);
			}
		}

	}

	public void listarSubastables() {

		int contadorSubastables = 0;

		for (Articulo articulo : articulos) {
			if (articulo.isSubastable() == true) {
				contadorSubastables++;
			}
		}

		Articulo[] subastables = new Articulo[contadorSubastables];

		int indiceSubastables = 0;

		for (Articulo articulo : articulos) {
			if (articulo.isSubastable() == true) {
				subastables[indiceSubastables] = articulo;
				indiceSubastables++;
			}
		}

		if (contadorSubastables == 0) {
			System.out.println("No hay artículos subastables");
		} else {
			System.out.println("Artículos son subastables:");
			for (Articulo articulo : subastables) {
				System.out.println(articulo);
			}
		}

	}

}
