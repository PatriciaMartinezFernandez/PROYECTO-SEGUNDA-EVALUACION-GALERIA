package galeria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean salir = false;
		int menu = 0;
		Galeria galeria = new Galeria();

		do {

			try {

				System.out.println("\n======= GALERIA =======");
				System.out.println("1) Gestión de artículos");
				System.out.println("2) Listar artículos");
				System.out.println("3) Iniciar subasta");
				System.out.println("4) Salir");
				System.out.println("=======================");
				menu = sc.nextInt();
				sc.nextLine();

				switch (menu) {

				default:
					System.out.println("Opción inválida");
					break;

				case 1:
					System.out.println("======= GESTIÓN =======");
					System.out.println("1) Añadir artículo");
					System.out.println("2) Eliminar artículo");
					System.out.println("3) Editar artículo");
					System.out.println("4) Almacenar artículo");
					System.out.println("5) Exponer artículo");
					System.out.println("6) Volver");
					System.out.println("=======================");
					menu = sc.nextInt();
					sc.nextLine();

					switch (menu) {

					default:
						System.out.println("Opción inválida");
						break;

					case 1:
						galeria.aniadirArticulo();
						break;

					case 2:
						galeria.eliminarArticulo();
						break;

					case 3:
						galeria.editarArticulo();
						break;

					case 4:
						galeria.almacenarArticulo();
						break;

					case 5:
						galeria.exponerArticulo();
						break;

					case 6:
						break;

					}
					break;
				case 2:
					System.out.println("======= LISTADO =======");
					System.out.println("1) Listar desordenado");
					System.out.println("2) Listar ordenado por nombre");
					System.out.println("3) Listar ordenado por año");
					System.out.println("4) Listar ordenado por autor");
					System.out.println("5) Listar artículos guardados en almacén");
					System.out.println("6) Listar artículos expuestos en galería");
					System.out.println("7) Listar artículos vendidos en subastas");
					System.out.println("8) Listar artículos subastables");
					System.out.println("9) Volver");
					System.out.println("=======================");
					menu = sc.nextInt();
					sc.nextLine();

					switch (menu) {

					default:
						System.out.println("Opción inválida");
						break;

					case 1:
						galeria.listarDesordenado();
						break;

					case 2:
						galeria.listarOrdenadoPorNombre();
						break;

					case 3:
						galeria.listarOrdenadoPorAnio();
						break;

					case 4:
						galeria.listarOrdenadoPorAutor();
						break;

					case 5:
						galeria.listarAlmacen();
						break;

					case 6:
						galeria.listarExposicion();
						break;

					case 7:
						galeria.listarVendidos();
						break;

					case 8:
						galeria.listarSubastables();
						break;

					case 9:
						break;

					}
					break;

				case 3:
					galeria.iniciarSubasta();
					break;

				case 4:
					System.out.println("Cerrando programa...");
					salir = true;
					break;

				}

			} catch (InputMismatchException e) {
				System.out.println("Carácter inválido");
				sc.next();
			}
		} while (!salir);

	}

}
