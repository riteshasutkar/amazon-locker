package entities;

import java.util.HashMap;
import java.util.List;

public class Locker {

    String id;
    String zipCode;
    HashMap<String, List<Compartment>> compartmentMapBySize; // only put the enum Size

    public Locker(String id, String zipCode, HashMap<String, List<Compartment>> compartmentMapBySize) {
        this.id = id;
        this.zipCode = zipCode;
        this.compartmentMapBySize = compartmentMapBySize;
    }

    public Compartment getAndOccupyCompartmentBySize(String size){
        return compartmentMapBySize.get(size.toLowerCase()).stream()
                .filter(compartment -> !compartment.isOccupied())
                .findFirst()
                .map(compartment -> {
                    compartment.isOccupied = true;
                    System.out.println("Compartment " + compartment.getId() + " in locker " + this.id + " is now occupied.");
                    return compartment;
                }).orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }
}
