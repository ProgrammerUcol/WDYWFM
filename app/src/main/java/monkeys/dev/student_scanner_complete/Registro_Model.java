package monkeys.dev.student_scanner_complete;

public class Registro_Model {
    String id;
    String fecha;
    String entrada;
    String salida;


    public Registro_Model(String id, String fecha, String entrada, String salida) {
        this.id = id;
        this.fecha = fecha;
        this.entrada = entrada;
        this.salida = salida;
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEntrada() {
        return entrada;
    }

    public String getSalida() {
        return salida;
    }
}
