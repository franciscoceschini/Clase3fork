package edu.uca;

import picocli.CommandLine;

import java.util.Scanner;

@CommandLine.Command(name = "tienda", mixinStandardHelpOptions = true, version = "1.0",
        description = "sistema de manejo interactivo del stock de la tienda")
public class Main implements Runnable {
    private Tienda tienda = new Tienda();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }

    @Override
    public void run() {
        System.out.println("Bienvendo al sistema de manejo interactivo del stock de la tienda");
        while (true) {
            System.out.println("\nElija una opción:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Salir");
            System.out.print("> ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    tienda.mostrarInventario();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }

    private void agregarProducto() {
        System.out.print("\nIngrese el ID del producto: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el nombre del producto: ");
        String name = scanner.nextLine();

        System.out.print("Es un articulo de ropa? (si/no) ");
        String ropa = scanner.nextLine();

        String size = "No aplica";
        String material = "No aplica";
        double warranty = 0;

        String electrodomestico = "Hola";

        System.out.print("Ingrese el precio del producto: ");
        double price = Double.parseDouble(scanner.nextLine());

        if (ropa.equals("si")) {
            System.out.print("Ingrese el tamaño del producto: ");
            size = scanner.nextLine();

            System.out.print("Ingrese el material del producto: ");
            material = scanner.nextLine();

            if (material.equals("algodon")) {
                price = price * 0.8;
            }

        }

        else {
            System.out.print("Es un electrodomestico? (si/no) ");
            electrodomestico = scanner.nextLine();

            if (electrodomestico.equals("si")){
                System.out.print("Cuantos años de garantia tiene?: ");
                warranty = Double.parseDouble(scanner.nextLine());

                price = price * 1.1;

            }

        }

        Producto producto = new Producto(id, name, price, size, material, ropa, warranty, electrodomestico);
        tienda.agregarProducto(producto);
    }
}