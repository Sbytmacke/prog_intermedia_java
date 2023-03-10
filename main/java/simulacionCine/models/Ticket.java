package simulacionCine.models;

import simulacionCine.enums.EstadoTicket;

import java.util.UUID;

// Clase que representa un ticket de compra o reserva para una película.
public class Ticket {
    public EstadoTicket estado;
    public String salaID;
    public Butaca[] butacas;
    String cantidadEntradas;
    String pelicula;
    private final UUID id = UUID.randomUUID();

    // Constructor para un UUID
    public Ticket(EstadoTicket estado, String salaID, String cantidadEntradas, String pelicula, Butaca[] butacas) {
        this.estado = estado;
        this.salaID = salaID;
        this.cantidadEntradas = cantidadEntradas;
        this.pelicula = pelicula;
        this.butacas = butacas;
    }


    /**
     * Devuelve la cantidad de entradas compradas.
     *
     * @return Cantidad de entradas compradas.
     */
    public String getCantidadEntradas() {
        return cantidadEntradas;
    }

    /**
     * Devuelve el identificador del ticket como una cadena.
     *
     * @return Identificador del ticket en formato de cadena.
     */
    public String ticketIDstring() {
        return id.toString();
    }

    /**
     * Devuelve una cadena con la información de las butacas asignadas al cliente.
     *
     * @return Cadena con la información de las butacas asignadas al cliente.
     */
    private String imprimirButacasCliente() {
        StringBuilder cadenaButacas = new StringBuilder();

        for (int i = 0; i <= butacas.length - 1; i++) {
            cadenaButacas.append(butacas[i].getPosicionCompletaButaca());
            if (butacas[i].getBooleanButacaVip()) {
                cadenaButacas.append("(VIP)");
            }
            if (!butacas[i].getBooleanButacaVip()) {
                cadenaButacas.append("(ESTÁNDAR)");
            }
            cadenaButacas.append(" ");

        }

        return "Butacas -> " + cadenaButacas;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto ticket.
     *
     * @return Representación en forma de cadena del objeto ticket.
     */
    @Override
    public String toString() {
        return "Ticket -> (id=$id, estado=$estado, sala='$salaID', cantidadEntradas='$cantidadEntradas', película='$pelicula')]" +
                "\n${imprimirButacasCliente()}";
    }
}
