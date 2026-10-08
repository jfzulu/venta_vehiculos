import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concesionario concesionario = new Concesionario("AutoMotor Central");

        int opcion = 0;

        do {
            System.out.println("\n==========================================");
            System.out.println("   SISTEMA DE GESTIÓN - " + concesionario.getNombre().toUpperCase());
            System.out.println("==========================================");
            System.out.println("1. Registrar Auto");
            System.out.println("2. Registrar Moto");
            System.out.println("3. Listar Inventario");
            System.out.println("4. Vender Vehículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR AUTO ---");
                    System.out.print("Marca: ");
                    String marcaAuto = scanner.nextLine();
                    System.out.print("Modelo (Año): ");
                    int modeloAuto = Integer.parseInt(scanner.nextLine());
                    System.out.print("Precio: ");
                    double precioAuto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Placa: ");
                    String placaAuto = scanner.nextLine();
                    System.out.print("Número de puertas: ");
                    int puertas = Integer.parseInt(scanner.nextLine());

                    Auto auto = new Auto(marcaAuto, modeloAuto, precioAuto, placaAuto, puertas);
                    concesionario.agregarVehiculo(auto);
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR MOTO ---");
                    System.out.print("Marca: ");
                    String marcaMoto = scanner.nextLine();
                    System.out.print("Modelo (Año): ");
                    int modeloMoto = Integer.parseInt(scanner.nextLine());
                    System.out.print("Precio: ");
                    double precioMoto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Placa: ");
                    String placaMoto = scanner.nextLine();
                    System.out.print("Cilindraje (cc): ");
                    int cilindraje = Integer.parseInt(scanner.nextLine());

                    Moto moto = new Moto(marcaMoto, modeloMoto, precioMoto, placaMoto, cilindraje);
                    concesionario.agregarVehiculo(moto);
                    break;

                case 3:
                    concesionario.listarVehiculos();
                    break;

                case 4:
                    System.out.println("\n--- VENDER VEHÍCULO ---");
                    System.out.print("Ingrese la placa del vehículo a vender: ");
                    String placaVenta = scanner.nextLine();
                    concesionario.venderVehiculo(placaVenta);
                    break;

                case 5:
                    System.out.println("\nSaliendo del sistema... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("❌ Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}