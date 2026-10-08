public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String marca, int modelo, double precio, String placa, int cilindraje) {
        super(marca, modelo, precio, placa); // Llama al constructor de Vehiculo
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public void mostrarInformacion() {
        System.out.printf("MOTO - Placa: %s | Marca: %s | Modelo: %d | Cilindraje: %d cc | Precio: $%.2f%n",
                getPlaca(), getMarca(), getModelo(), cilindraje, getPrecio());
    }
}