package simulacionCine.models;

import simulacionCine.enums.EstadoTicket;

// Clase que representa un cliente una vez realice una reserva o compra
public class Cliente{
    private String nombre;
    private  String apellido;
    public String dni;
    private String telefono;
    public String email;
    private String tarjetaCredito;
    public Ticket informacionTicket;

    public Cliente(String nombre, String apellido, String dni, String telefono, String email, String tarjetaCredito, Ticket informacionTicket) {
    }

    /**
     * Devuelve el ID de la sala asociada al ticket del cliente.
     *
     * @return ID de la sala asociada al ticket del cliente.
     */
    public String getIDsalaAsociadaCliente() {
        return informacionTicket.salaID;
    }

    /**
     * Establece la tarjeta de crédito del cliente.
     *
     * @param tarjetaCliente Tarjeta de crédito del cliente.
     */
    public void setTarjetaCredito(String tarjetaCliente) {
        this.tarjetaCredito = tarjetaCliente;
    }

    /**
     * Establece el estado del ticket asociado al cliente.
     *
     * @param estadoTicket Estado del ticket asociado al cliente.
     */
    public void setEstadoTicketAsociado(EstadoTicket estadoTicket) {
        this.informacionTicket.estado = estadoTicket;
    }

    /**
     * Devuelve una cadena con información del cliente.
     *
     * @return Cadena con información del cliente.
     */
     @Override
     public String toString() {
        return "Cliente/Usuario -> (nombre='$nombre', apellido='$apellido', dni='$dni', telefono='$telefono', email='$email', tarjetaCredito='$tarjetaCredito',ticketID='${informacionTicket.ticketIDstring()}')";
    }
}
