public abstract class Vehiculo {
    private String marca;
    private int modelo;
    private double precio;
    private String placa;

    public Vehiculo(String marca, int modelo, double precio, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.placa = placa;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Método que cada clase hija implementará para mostrar sus detalles
    public abstract void mostrarInformacion();
}