package entities;

import java.util.HashMap;
import java.util.List;

public class Locker {

    String zipCode;
    HashMap<String, List<Compartment>> compartmentMapBySize = new HashMap<>(); // only put the enum Size

    public Compartment getCompartmentBySize(String size){

    }
}
