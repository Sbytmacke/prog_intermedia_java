package simulacionParking.models;

import simulacionParking.enums.TipoVehiculo;

public record Vehiculo(String id, String matricula, String anno, TipoVehiculo tipo) {

}
