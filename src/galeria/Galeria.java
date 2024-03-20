package galeria;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * La clase Galeria representa una galería de arte que gestiona una colección de
 * artículos. Permite realizar diversas operaciones como añadir, eliminar,
 * editar, almacenar, exponer y listar artículos. También puede iniciar subastas
 * con artículos subastables.
 */

public class Galeria {

	static Scanner sc = new Scanner(System.in);

	// Variable

	private Articulo[] articulos = new Articulo[0];

	// Constructor

	/**
	 * Constructor vacío.
	 */

	public Galeria() {
		this.articulos = new Articulo[0];
	}

	// Getters y setters

	/**
	 * Devuelve el array de artículos.
	 * 
	 * @return el array de artículos.
	 */

	public Articulo[] getArticulos() {
		return articulos;
	}

	/**
	 * Estable el array de artículos.
	 * 
	 * @param articulos El array de artículos.
	 */

	public void setArticulos(Articulo[] articulos) {
		this.articulos = articulos;
	}

	// Métodos

	/**
	 * Método que permite al usuario añadir un nuevo artículo a la galería. Se
	 * solicita al usuario que seleccione el tipo de artículo que desea añadir
	 * (Cuadro o Escultura), luego se recopilan los datos necesarios según el tipo
	 * de artículo seleccionado. Una vez recopilados los datos, se crea una
	 * instancia del artículo correspondiente y se añade a la lista de artículos.
	 */

	public void aniadirArticulo() {

		int menu = 0, anio = 0;
		String nombre, autor, descripcion;
		double precio = 0;
		Tecnica tecnica = null;
		Material material = null;
		Cuadro cuadro = new Cuadro();
		Escultura escultura = new Escultura();

		// Menú para elegir tipo de artículo
		System.out.println("=======================");
		System.out.println("¿Qué tipo de artículo?: ");
		System.out.println("1) Cuadro");
		System.out.println("2) Escultura");
		System.out.println("=======================");
		try {
			menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {
				// Recopilar datos de un cuadro
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

				// Añadir el cuadro a la lista de artículos
				Articulo[] temp = articulos;
				articulos = new Articulo[articulos.length + 1];

				for (int i = 0; i < temp.length; i++) {
					articulos[i] = temp[i];
				}

				articulos[articulos.length - 1] = new Cuadro(nombre, autor, anio, descripcion, precio, tecnica);

				articulos[articulos.length - 1].setSubastable(cuadro.articuloSubastable());

				System.out.println("=======================");

			} else if (menu == 2) {
				// Recopilar datos de una escultura
				System.out.print("Nombre de la escultura: ");
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
					System.out.println("Opción no válida");
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

				// Añadir la escultura a la lista de artículos
				Articulo[] temp = articulos;
				articulos = new Articulo[articulos.length + 1];

				for (int i = 0; i < temp.length; i++) {
					articulos[i] = temp[i];
				}

				articulos[articulos.length - 1] = new Escultura(nombre, autor, anio, descripcion, precio, material);

				articulos[articulos.length - 1].setSubastable(escultura.articuloSubastable());

				System.out.println("=======================");

			} else {
				System.out.println("Opción inválida");
				System.out.println("=======================");
			}
		} catch (InputMismatchException e) {
			System.out.println("Respuesta inválida. Introduce un número");
			sc.nextLine();
		}
	}

	/**
	 * Método que permite al usuario eliminar un artículo de la galería. Se solicita
	 * al usuario que ingrese el nombre del artículo que desea eliminar. Si el
	 * artículo existe en la galería, se elimina de la lista de artículos. Si el
	 * artículo no se encuentra, se muestra un mensaje indicando que no existe.
	 */

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
				// Busca el artículo por su nombre
				if (articulos[i].getNombre().equals(nombre)) {
					encontrado = true;
					// Eliminar el artículo de la lista
					for (int j = i; j < articulos.length - 1; j++) {
						// Desplaza los elementos hacia la izquierda para llenar el espacio del artículo
						// eliminado
						articulos[j] = articulos[j + 1];
					}
					// Crea una nueva matriz de artículos con un tamaño menor para almacenar los
					// artículos restantes
					Articulo[] temp = new Articulo[articulos.length - 1];
					for (int k = 0; k < temp.length; k++) {
						temp[k] = articulos[k];
					}
					articulos = temp;
				} else {
					i++; // Si el artículo actual no es el buscado, avanza al siguiente índice
				}

			}
			// Continúa el bucle mientras haya elementos en la lista y no se haya encontrado
			// el artículo
			while (i < articulos.length && !encontrado);
		}

		// Mostrar si el artículo se ha eliminado o si no existe
		if (!encontrado) {
			System.out.println("Ese artículo no existe");
		} else {
			System.out.println("Artículo eliminado correctamente");
		}
	}

	/**
	 * Método que permite editar los atributos de un artículo existente en la
	 * galería. El usuario ingresa el nombre del artículo que desea editar y luego
	 * selecciona qué atributo editar. Los atributos que se pueden editar son:
	 * nombre, autor, año, descripción, precio y subastable. Si el artículo no se
	 * encuentra en la galería, se muestra un mensaje de error.
	 */

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
				// Busca el artículo por su nombre
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
					try {
						menu = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Respuesta inválida. Introduce un número");
						sc.nextLine();
						continue;
					}
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
						try {
							anio = sc.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("Respuesta inválida. Introduce un número");
							sc.nextLine();
							continue;
						}
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
						try {
							precio = sc.nextDouble();
						} catch (InputMismatchException e) {
							System.out.println("Respuesta inválida. Introduce un número");
							sc.nextLine();
							continue;
						}
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

			}
			// Continúa el bucle mientras no se haya encontrado el artículo y haya más
			// artículos en la lista
			while (!encontrado && i < articulos.length);

			// Si el artículo no se encuentra en la galería, muestra un mensaje de error
			if (!encontrado) {
				System.out.println("Ese artículo no existe");
			}
		}
	}

	/**
	 * Método que permite almacenar un artículo que se encuentra en la galería. El
	 * usuario ingresa el nombre del artículo que desea almacenar. Si el artículo no
	 * se encuentra en la galería, se muestra un mensaje de error. Si el artículo ya
	 * está en el almacén o ha sido vendido en subasta, se muestra un mensaje
	 * correspondiente. Si el artículo se encuentra en la galería y no está en el
	 * almacén ni ha sido vendido, se cambia su estado a EN_ALMACEN.
	 */

	public void almacenarArticulo() {

		String nombre;
		boolean encontrado = false;
		int i = 0;

		// Verifica si hay artículos en la galería
		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {
			System.out.print("¿Qué artículo quieres almacenar? Introduce su nombre: ");
			nombre = sc.nextLine();

			do {
				// Busca el artículo por su nombre
				if (articulos[i].getNombre().equals(nombre)) {

					encontrado = true;

					// Verifica el estado del artículo
					if (articulos[i].getEstado() == Estado.EN_ALMACEN) {
						System.out.println("Este artículo ya está en el almacén");
					} else if (articulos[i].getEstado() == Estado.VENDIDO) {
						System.out.println("Este artículo ha sido vendido en subasta");
					} else {
						// Cambia el estado del artículo a EN_ALMACEN
						articulos[i].setEstado(Estado.EN_ALMACEN);
						System.out.println("El artículo ha sido almacenado");
					}

				} else {
					i++;
				}

			}
			// Continúa el bucle mientras no se haya encontrado el artículo y haya más
			// artículos en la lista
			while (!encontrado && i < articulos.length);

			// Si el artículo no se encuentra en la galería, muestra un mensaje de error
			if (!encontrado) {
				System.out.println("Ese artículo no existe");
			}

		}

	}

	/**
	 * Método que permite exponer un artículo que se encuentra en la galería. El
	 * usuario ingresa el nombre del artículo que desea exponer. Si el artículo no
	 * se encuentra en la galería, se muestra un mensaje de error. Si el artículo ya
	 * está en exposición o ha sido vendido en subasta, se muestra un mensaje
	 * correspondiente. Si el artículo se encuentra en la galería y no está en
	 * exposición ni ha sido vendido, se cambia su estado a EN_EXPOSICION.
	 */

	public void exponerArticulo() {

		String nombre;
		boolean encontrado = false;
		int i = 0;

		// Verifica si hay artículos en la galería
		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {
			System.out.print("¿Qué artículo quieres exponer? Introduce su nombre: ");
			nombre = sc.nextLine();

			do {
				// Busca el artículo por su nombre
				if (articulos[i].getNombre().equals(nombre)) {

					encontrado = true;

					// Verifica el estado del artículo
					if (articulos[i].getEstado() == Estado.EN_EXPOSICION) {
						System.out.println("Este artículo ya está en exposición");
					} else if (articulos[i].getEstado() == Estado.VENDIDO) {
						System.out.println("Este artículo ha sido vendido en subasta");
					} else {
						// Cambia el estado del artículo a EN_EXPOSICION
						articulos[i].setEstado(Estado.EN_EXPOSICION);
						System.out.println("El artículo ahora está expuesto en la galería");
					}

				} else {
					i++;
				}

			}
			// Continúa el bucle mientras no se haya encontrado el artículo y haya más
			// artículos en la lista
			while (!encontrado && i < articulos.length);

			// Si el artículo no se encuentra en la galería, muestra un mensaje de error
			if (!encontrado) {
				System.out.println("Ese artículo no existe");
			}

		}

	}

	/**
	 * Método que muestra la lista de artículos en la galería sin ningún orden en
	 * particular. Imprime en consola la representación de cada artículo. Si no hay
	 * artículos en la galería, muestra un mensaje indicando que no hay artículos.
	 */

	public void listarDesordenado() {

		System.out.println("====== ARTICULOS ======");

		// Verifica si hay artículos en la galería
		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {

			// Itera sobre cada artículo en la galería
			for (Articulo articulo : articulos) {
				// Verifica si el artículo es un Cuadro o una Escultura y muestra su
				// representación
				if (articulo instanceof Cuadro) {
					System.out.println(((Cuadro) articulo).toString());
				} else {
					System.out.println(((Escultura) articulo).toString());
				}
			}
		}
	}

	/**
	 * Método que muestra la lista de artículos en la galería ordenados por nombre
	 * de manera ascendente o descendente, según la opción seleccionada por el
	 * usuario. Llama al método correspondiente para ordenar la lista y mostrarla en
	 * consola. Si no hay artículos en la galería, muestra un mensaje indicando que
	 * no hay artículos.
	 */

	public void listarOrdenadoPorNombre() {

		int menu = 0;

		// Verifica si hay artículos en la galería
		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {

			// Solicita al usuario que elija el orden de la lista (ascendente o descendente)
			System.out.println("=======================");
			System.out.println("1) Ascendentemente");
			System.out.println("2) Descendentemente");
			System.out.println("=======================");
			menu = sc.nextInt();
			sc.nextLine();

			// Verifica la opción seleccionada por el usuario y llama al método
			// correspondiente
			if (menu == 1) {
				ordenadoAscendente();
			} else if (menu == 2) {
				ordenadoDescendente();
			} else {
				System.out.println("Opción inválida");
			}
		}

	}

	/**
	 * Método que ordena los artículos en orden ascendente según el nombre. Se crea
	 * una copia de la lista de artículos para no modificar la original. Luego, se
	 * recorre la lista y se compara cada elemento con el siguiente,
	 * intercambiándolos si es necesario para que estén en orden alfabético
	 * ascendente según el nombre. Finalmente, se imprime la lista ordenada en
	 * consola.
	 */

	private void ordenadoAscendente() {

		// Se crea una copia de la lista de artículos para no modificar la original
		Articulo[] ascendente = articulos;

		// Bucle externo para recorrer el array
		for (int i = 0; i < ascendente.length - 1; i++) {
			// Bucle interno para comparar cada elemento con el siguiente
			for (int j = 0; j < ascendente.length - i - 1; j++) {
				// Se compara el nombre de dos artículos adyacentes
				if (ascendente[j].getNombre().compareTo(ascendente[j + 1].getNombre()) > 0) {
					// Si el nombre del elemento actual es mayor que el siguiente, se intercambian
					Articulo temp = ascendente[j];
					ascendente[j] = ascendente[j + 1];
					ascendente[j + 1] = temp;
				}
			}
		}
		// Imprime la lista ordenada en consola
		for (Articulo articulo : ascendente) {
			System.out.println(articulo);
		}

	}

	/**
	 * Método que ordena los artículos en orden descendente según el nombre. Se crea
	 * una copia de la lista de artículos para no modificar la original. Luego, se
	 * recorre la lista y se compara cada elemento con el siguiente,
	 * intercambiándolos si es necesario para que estén en orden alfabético
	 * descendente según el nombre. Finalmente, se imprime la lista ordenada en
	 * consola.
	 */

	private void ordenadoDescendente() {

		// Se crea una copia de la lista de artículos para no modificar la original
		Articulo[] descendente = articulos;

		// Bucle externo para recorrer el array
		for (int i = 0; i < descendente.length - 1; i++) {
			// Bucle interno para comparar cada elemento con el siguiente
			for (int j = 0; j < descendente.length - i - 1; j++) {
				// Se compara el nombre de dos artículos adyacentes
				if (descendente[j].getNombre().compareTo(descendente[j + 1].getNombre()) < 0) {
					// Si el nombre del elemento actual es menor que el siguiente, se intercambian
					Articulo temp = descendente[j];
					descendente[j] = descendente[j + 1];
					descendente[j + 1] = temp;
				}
			}
		}
		// Imprime la lista ordenada en consola
		for (Articulo articulo : descendente) {
			System.out.println(articulo);

		}
	}

	/**
	 * Método que ordena y lista los artículos según su año de publicación en orden
	 * ascendente. Si no hay artículos en la lista, imprime un mensaje indicando que
	 * no hay artículos.
	 */

	public void listarOrdenadoPorAnio() {

		// Se crea una copia de la lista de artículos para no modificar la original
		Articulo[] ordenado = articulos;

		// Verifica si la lista de artículos está vacía
		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {

			// Bucle externo para recorrer el array
			for (int i = 0; i < ordenado.length - 1; i++) {
				// Bucle interno para comparar cada elemento con el siguiente
				for (int j = 0; j < ordenado.length - i - 1; j++) {
					// Si el año de publicación del artículo actual es mayor que el siguiente, se
					// intercambian
					if (ordenado[j].getAnio() > ordenado[j + 1].getAnio()) {
						// Intercambia los elementos si están en el orden incorrecto
						Articulo temp = ordenado[j];
						ordenado[j] = ordenado[j + 1];
						ordenado[j + 1] = temp;
					}
				}
			}

			// Imprime la lista ordenada en consola
			for (Articulo articulo : ordenado) {
				System.out.println(articulo);
			}
		}
	}

	/**
	 * Método que ordena y lista los artículos según su autor en orden ascendente.
	 * Si no hay artículos en la lista, imprime un mensaje indicando que no hay
	 * artículos.
	 */

	public void listarOrdenadoPorAutor() {

		// Se crea una copia de la lista de artículos para no modificar la original
		Articulo[] ordenado = articulos;

		// Verifica si la lista de artículos está vacía
		if (articulos.length == 0) {
			System.out.println("No hay artículos");
		} else {

			// Bucle externo para recorrer el array
			for (int i = 0; i < ordenado.length - 1; i++) {
				// Bucle interno para comparar cada elemento con el siguiente
				for (int j = 0; j < ordenado.length - i - 1; j++) {
					// Si el nombre del autor del artículo actual es menor que el siguiente, se
					// intercambian
					if (ordenado[j].getAutor().compareTo(ordenado[j + 1].getAutor()) < 0) {
						// Intercambia los elementos si están en el orden incorrecto
						Articulo temp = ordenado[j];
						ordenado[j] = ordenado[j + 1];
						ordenado[j + 1] = temp;
					}
				}
			}
			// Imprime la lista ordenada en consola
			for (Articulo articulo : ordenado) {
				System.out.println(articulo);

			}
		}
	}

	/**
	 * Método que lista los artículos que están en el almacén.
	 */

	public void listarAlmacen() {
		int contadorAlmacen = 0;

		// Itera sobre la lista de artículos para contar cuántos están en el almacén
		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_ALMACEN)) {
				contadorAlmacen++;
			}
		}

		// Crea un nuevo array para almacenar los artículos en el almacén
		Articulo[] almacen = new Articulo[contadorAlmacen];

		int indiceAlmacen = 0;

		// Itera sobre la lista de artículos y copia aquellos que están en el almacén al
		// array almacen
		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_ALMACEN)) {
				almacen[indiceAlmacen] = articulo;
				indiceAlmacen++;
			}
		}

		// Verifica si no hay artículos en el almacén
		if (contadorAlmacen == 0) {
			System.out.println("No hay artículos en el almacén");
		} else {
			// Imprime los artículos que están en el almacén
			System.out.println("Artículos en el almacén:");
			for (Articulo articulo : almacen) {
				System.out.println(articulo);
			}
		}
	}

	/**
	 * Método que lista los artículos que están en exposición
	 */

	public void listarExposicion() {

		int contadorExposicion = 0;

		// Itera sobre la lista de artículos para contar cuántos están en exposición
		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_EXPOSICION)) {
				contadorExposicion++;
			}
		}

		// Crea un nuevo array para almacenar los artículos en exposición
		Articulo[] exposicion = new Articulo[contadorExposicion];

		int indiceExposicion = 0;

		// Itera sobre la lista de artículos y copia aquellos que están en exposición al
		// array exposicion
		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.EN_EXPOSICION)) {
				exposicion[indiceExposicion] = articulo;
				indiceExposicion++;
			}
		}

		// Verifica si no hay artículos en exposición
		if (contadorExposicion == 0) {
			System.out.println("No hay artículos en la exposición");
		} else {
			// Imprime los artículos que están en exposición
			System.out.println("Artículos en la exposición:");
			for (Articulo articulo : exposicion) {
				System.out.println(articulo);
			}
		}

	}

	/**
	 * Método que lista los artículos que han sido vendidos en una subasta.
	 */

	public void listarVendidos() {

		int contadorVendidos = 0;

		// Itera sobre la lista de artículos para contar cuántos han sido vendidos
		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.VENDIDO)) {
				contadorVendidos++;
			}
		}

		// Crea un nuevo array para almacenar los artículos vendidos
		Articulo[] vendidos = new Articulo[contadorVendidos];

		int indiceVendidos = 0;

		// Itera sobre la lista de artículos y copia aquellos que han sido vendidos al
		// array vendidos
		for (Articulo articulo : articulos) {
			if (articulo.getEstado().equals(Estado.VENDIDO)) {
				vendidos[indiceVendidos] = articulo;
				indiceVendidos++;
			}
		}

		// Verifica si no hay artículos vendidos
		if (contadorVendidos == 0) {
			System.out.println("No hay artículos vendidos");
		} else {
			// Imprime los artículos que han sido vendidos
			System.out.println("Artículos que han sido vendidos en una subasta:");
			for (Articulo articulo : vendidos) {
				System.out.println(articulo);
			}
		}

	}

	/**
	 * Método que lista los artículos que son subastables.
	 */

	public void listarSubastables() {

		int contadorSubastables = 0;

		// Itera sobre la lista de artículos para contar cuántos son subastables
		for (Articulo articulo : articulos) {
			if (articulo.isSubastable() == true) {
				contadorSubastables++;
			}
		}

		// Crea un nuevo array para almacenar los artículos subastables
		Articulo[] subastables = new Articulo[contadorSubastables];

		int indiceSubastables = 0;

		// Itera sobre la lista de artículos y copia aquellos que son subastables al
		// array subastables
		for (Articulo articulo : articulos) {
			if (articulo.isSubastable() == true) {
				subastables[indiceSubastables] = articulo;
				indiceSubastables++;
			}
		}

		// Verifica si no hay artículos subastables
		if (contadorSubastables == 0) {
			System.out.println("No hay artículos subastables");
		} else {
			// Imprime los artículos subastables
			System.out.println("Artículos subastables:");
			for (Articulo articulo : subastables) {
				System.out.println(articulo);
			}
		}

	}

	/**
	 * Método que cuenta el número de artículos subastables.
	 * 
	 * @return El número de artículos subastables.
	 */

	private int contarSubastables() {

		int contadorSubastables = 0;

		// Itera sobre la lista de artículos para contar los subastables
		for (Articulo articulo : articulos) {
			// Verifica si el artículo es subastable
			if (articulo.isSubastable() == true) {
				contadorSubastables++;
			}
		}
		// Devuelve el número total de artículos subastables
		return contadorSubastables;

	}

	/**
	 * Método que inicia una subasta seleccionando aleatoriamente 5 artículos
	 * subastables no vendidos. Se elige un artículo ganador de forma aleatoria
	 * entre los seleccionados. El artículo ganador se marca como vendido y se
	 * establece la fecha de venta como la fecha actual.
	 */

	public void iniciarSubasta() {

		// Verifica si hay artículos subastables disponibles
		if (contarSubastables() == 0) {
			System.out.println("No hay artículos subastables");
		} else {
			// Crea un array para almacenar los índices de los artículos subastables no
			// vendidos
			int[] indicesSubastablesNoVendidos = new int[contarSubastables()];
			int contador = 0;

			// Itera sobre todos los artículos para encontrar los subastables no vendidos
			for (int i = 0; i < articulos.length; i++) {
				if (articulos[i].isSubastable() && !articulos[i].getEstado().equals(Estado.VENDIDO)) {
					indicesSubastablesNoVendidos[contador] = i;
					contador++;
				}
			}

			// Verifica si hay al menos 5 artículos subastables no vendidos para iniciar la
			// subasta
			if (contador >= 5) {
				Random random = new Random();

				// Crea un array para almacenar los artículos seleccionados para la subasta
				Articulo[] articulosEnSubasta = new Articulo[5];
				boolean[] seleccionados = new boolean[contador];

				System.out.println("=== ARTICULOS EN SUBASTA ===");

				// Selecciona aleatoriamente 5 artículos subastables no vendidos
				for (int i = 0; i < 5; i++) {
					int indiceAleatorio;
					do {
						indiceAleatorio = random.nextInt(contador);
					} while (seleccionados[indiceAleatorio]); // Evita seleccionar el mismo artículo dos veces

					seleccionados[indiceAleatorio] = true; // Marca el artículo como seleccionado

					// Obtiene el artículo seleccionado y lo agrega al array de artículos en subasta
					int indiceArticuloSeleccionado = indicesSubastablesNoVendidos[indiceAleatorio];
					Articulo articuloSeleccionado = articulos[indiceArticuloSeleccionado];
					articulosEnSubasta[i] = articuloSeleccionado;

					// Imprime el nombre del artículo seleccionado
					System.out.println("Artículo " + (i + 1) + ": " + articuloSeleccionado.getNombre());
				}

				// Elige aleatoriamente un artículo ganador entre los seleccionados
				int indiceGanador = random.nextInt(5);
				Articulo articuloVendido = articulosEnSubasta[indiceGanador];
				// Marca el artículo ganador como vendido y establece la fecha de venta como la
				// fecha actual
				articuloVendido.setEstado(Estado.VENDIDO);
				articuloVendido.setFechaVenta(LocalDate.now());

				// Imprime el nombre del artículo vendido
				System.out.println("============================");
				System.out.println("El artículo vendido es: " + articuloVendido.getNombre());
				System.out.println("============================");
			} else {
				// Informa que no hay suficientes artículos para iniciar la subasta
				System.out.println("No hay suficientes artículos para iniciar la subasta. Necesarios 5 artículos subastables");
			}
		}
	}

}
