import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Concesionario {
    private static final Path ARCHIVO_VENTAS = Path.of("ventas.txt");
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String nombre;
    private List<Vehiculo> inventario;

    public Concesionario(String nombre) {
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    // 1. Agregar un vehículo al inventario
    public void agregarVehiculo(Vehiculo v) {
        // Verificar si la placa ya existe para evitar duplicados
        if (buscarPorPlaca(v.getPlaca()) != null) {
            System.out.println("❌ Error: Ya existe un vehículo con la placa " + v.getPlaca());
            return;
        }
        inventario.add(v);
        System.out.println("✅ Vehículo agregado correctamente: " + v.getMarca() + " (" + v.getPlaca() + ")");
    }

    // 2. Vender (eliminar) un vehículo por placa
    public boolean venderVehiculo(String placa) {
        Vehiculo vehiculoEncontrado = buscarPorPlaca(placa);
        if (vehiculoEncontrado != null) {
            if (!registrarVenta(vehiculoEncontrado)) {
                System.out.println("❌ No se pudo registrar la venta. El vehículo sigue en el inventario.");
                return false;
            }
            inventario.remove(vehiculoEncontrado);
            System.out.println("🎉 ¡Vehículo vendido con éxito! Placa: " + placa + " por $" + vehiculoEncontrado.getPrecio());
            return true;
        }
        System.out.println("⚠️ No se encontró ningún vehículo con la placa: " + placa);
        return false;
    }

    private boolean registrarVenta(Vehiculo vehiculo) {
        String registro = String.format(
                "%s | Tipo: %s | Placa: %s | Marca: %s | Modelo: %d | Precio: $%.2f%n",
                LocalDateTime.now().format(FORMATO_FECHA),
                vehiculo.getClass().getSimpleName(),
                vehiculo.getPlaca(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getPrecio());

        try {
            Files.writeString(
                    ARCHIVO_VENTAS,
                    registro,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            System.out.println("❌ Error al escribir el archivo de ventas: " + e.getMessage());
            return false;
        }
    }

    // 3. Listar todos los vehículos registrados
    public void listarVehiculos() {
        if (inventario.isEmpty()) {
            System.out.println("\n--- El inventario del concesionario está vacío ---");
            return;
        }

        System.out.println("\n========== INVENTARIO DE " + nombre.toUpperCase() + " ==========");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.print((i + 1) + ". ");
            inventario.get(i).mostrarInformacion(); // Aplica Polimorfismo
        }
        System.out.println("=================================================");
    }

    // Método auxiliar para buscar un vehículo por su placa
    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : inventario) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }
}