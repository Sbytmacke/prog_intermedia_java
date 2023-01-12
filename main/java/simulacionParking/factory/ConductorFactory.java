package simulacionParking.factory;

import simulacionParking.models.Conductor;
import simulacionParking.models.Vehiculo;

import java.util.Random;

public class ConductorFactory {

    // Contador ID de los distintos conductores creados
    // ============================================
    private final int id;

    public ConductorFactory() {
        id = IdGenerator.getNextId();
    }

    // ============================================
    public static Conductor createConductor() {
        String nombre = generarNombre();
        String DNI = generacionDNI();
        Vehiculo[] ownerVehicles = VehiculoFactory.generacionAlmacenVehiculos();

        // Lo único por defecto es la cantidad de coches aparcados que iremos incrementando después
        Conductor conductorAleatorio = new Conductor(IdGenerator.getNextId(), nombre, DNI, ownerVehicles, 0);
        return conductorAleatorio;
    }

    private static String generarNombre() {
        Random r = new Random();
        int num = r.nextInt(7);
        String[] catalogoNombres = {"Pedro", "Alexandra", "Angel", "José", "Elena", "Ricardo", "Domingo", "Patricia"};
        return catalogoNombres[num];
    }

    private static String generacionDNI() {
        String alfabetoDNI = "TRWAGMYFPDXBNJZSQVHLCKE";

        // DNI completo
        StringBuilder DNI = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            // Genera un número entre 0 y 22 (incluidos)
            Random r = new Random();
            int num = r.nextInt(9);
            DNI.append(num);
        }

        Random r = new Random();
        int num = r.nextInt(23);
        DNI.append(alfabetoDNI.charAt(num));

        return DNI.toString();
    }

    // Contador ID de los distintos conductores creados
    // ============================================
    public int getId() {
        return id;
    }

    public class IdGenerator {
        private static int nextId = 1;

        public static int getNextId() {
            return nextId++;
        }
    }
    // ============================================
}
