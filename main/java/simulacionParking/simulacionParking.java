package simulacionParking;

import simulacionParking.factory.ConductorFactory;
import simulacionParking.models.Conductor;

public class simulacionParking {
    public static void main(String[] args) {
        Conductor c1 = ConductorFactory.createConductor();
        Conductor c2 = ConductorFactory.createConductor();

        System.out.println(c1);
        System.out.println();
        System.out.println(c2);

    }
}
