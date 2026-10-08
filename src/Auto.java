public class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto(String marca, int modelo, double precio, String placa, int numeroPuertas) {
        super(marca, modelo, precio, placa); // Llama al constructor de Vehiculo
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.printf("AUTO - Placa: %s | Marca: %s | Modelo: %d | Puertas: %d | Precio: $%.2f%n",
                getPlaca(), getMarca(), getModelo(), numeroPuertas, getPrecio());
    }
}