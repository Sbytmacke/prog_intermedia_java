package simulacionParking.factory;

import simulacionParking.enums.TipoVehiculo;
import simulacionParking.models.Vehiculo;

import java.util.Random;

public class VehiculoFactory {
    private static String matricula;
    private static String year;
    private static TipoVehiculo tipo;

    // Contador ID de los distintos conductores creados
    // ============================================
    private final int id;

    public VehiculoFactory() {
        id = ConductorFactory.IdGenerator.getNextId();
    }

    // ============================================

    public static Vehiculo create() {
        // Se pueden filtrar las generaciones aleatorias como precisemos, en este caso solo he filtrado en función
        // del annoFabrica, si es menos del 2015, no puede ser patinete al generar el tipo de Vehículo
        String matricula = generarMatricula();
        String annoFabrica = generarAnnoFabrica();
        TipoVehiculo tipo = generarTipoVehiculo(annoFabrica);
        String id_AUTO = "*" + IdGenerator.getNextId() + "*";

        Vehiculo vehiculo = new Vehiculo(id_AUTO, matricula, annoFabrica, tipo);
        return vehiculo;
    }

    private static TipoVehiculo generarTipoVehiculo(String annoFabrica) {
        while (true) {
            Random r = new Random();
            int num = r.nextInt(5);
            if (num == 0) {
                return TipoVehiculo.CAMION;
            }
            if (num == 1) {
                return TipoVehiculo.COCHE;
            }
            if (num == 2) {
                return TipoVehiculo.MOTO;
            }
            if (num == 3) {
                return TipoVehiculo.BICI;
            }
            if (num == 4 && Integer.parseInt(annoFabrica) >= 2015) {
                return TipoVehiculo.PATINETE;
            }
        }
    }

    private static String generarAnnoFabrica() {
        int indiceAlmacen = 0;
        // Almacén desde el 1990 hasta el 2019 = 29 años
        String[] almacenAnnos = new String[30];
        for (int i = 0; i < 10; i++) {
            String anno = "199" + i;
            almacenAnnos[indiceAlmacen] = anno;
            indiceAlmacen++;
        }
        for (int i = 0; i < 10; i++) {
            String anno = "200" + i;
            almacenAnnos[indiceAlmacen] = anno;
            indiceAlmacen++;
        }
        for (int i = 0; i < 10; i++) {
            String anno = "201" + i;
            almacenAnnos[indiceAlmacen] = anno;
            indiceAlmacen++;
        }
        Random r = new Random();
        int num = r.nextInt(30);
        return almacenAnnos[num];
    }

    private static String generarMatricula() {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "1234567890";

        Random r = new Random();
        StringBuilder matriculaFinal = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            int sorteoAlfabeto = r.nextInt(26);
            matriculaFinal.append(alfabeto.charAt(sorteoAlfabeto));
        }
        matriculaFinal.append("-");
        for (int i = 0; i < 4; i++) {
            int sorteoNumeros = r.nextInt(10);
            matriculaFinal.append(numeros.charAt(sorteoNumeros));
        }
        return matriculaFinal.toString();
    }

    // Genera un almacén de vehículos
    static Vehiculo[] generacionAlmacenVehiculos() {
        // Genero aleatoriamente los vehículos que tenga un conductor, entre 1 y 6 vehículos
        Random r = new Random();
        int num = r.nextInt(5) + 1;

        Vehiculo[] vehiculosDeConductor = new Vehiculo[num];

        for (int i = 0; i < num; i++) {
            vehiculosDeConductor[i] = VehiculoFactory.create();
        }

        return vehiculosDeConductor;
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
