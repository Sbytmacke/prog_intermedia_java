package simulacionParking.models;

import simulacionCine.enums.Color;

public record Conductor(int id_AUTO, String nombre, String DNI, Vehiculo[] ownerVehicle, int quantityParking_AUTO) {

    public void imprimirVector() {
        System.out.println(Color.YELLOW_UNDERLINED.get() + "VEHÍCULOS EN PROPIEDAD" + Color.RESET.get());
        for (int i = 0; i < ownerVehicle.length; i++) {
            System.out.print("VEHÍCULO " + (i + 1) + " ");
            System.out.println(ownerVehicle[i]);
        }
    }

    @Override
    public String toString() {
        System.out.println(Color.GREEN_BACKGROUND.get() + "                                                                           " + Color.RESET.get());
        System.out.println(Color.YELLOW_UNDERLINED.get() + "CONDUCTOR" + Color.RESET.get());
        System.out.println("id: " + id_AUTO + ", nombre: " + nombre + ", DNI: " + DNI + ", vehículos aparcados: " + quantityParking_AUTO);
        imprimirVector();

        return Color.GREEN_BACKGROUND.get() + "                                                                           " + Color.RESET.get();
    }
}

