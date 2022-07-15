package model;


public class Series {
    private int idcines;
    private String nombre;
    private String director;
    private int cantMinutos;
    private double precio;
    private int capitulos;

    public Series(int idcines, String nombre, String director, int cantMinutos, double precio, int capitulos) {
        this.idcines = idcines;
        this.nombre = nombre;
        this.director = director;
        this.cantMinutos = cantMinutos;
        this.precio = precio;
        this.capitulos = capitulos;
    }

    public Series(String nombre, String director, int cantMinutos, double precio, int capitulos) {
        this.nombre = nombre;
        this.director = director;
        this.cantMinutos = cantMinutos;
        this.precio = precio;
        this.capitulos = capitulos;
    }

    public int getIdcines() {
        return idcines;
    }

    public void setIdcines(int idcines) {
        this.idcines = idcines;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getCantMinutos() {
        return cantMinutos;
    }

    public void setCantMinutos(int cantMinutos) {
        this.cantMinutos = cantMinutos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString() {
        return "Serie{" + "nombre=" + nombre + ", director=" + director + ", cantMinutos=" + cantMinutos + ", precio=" + precio + ", capitulos=" + capitulos + '}';
    }
    
    
}
