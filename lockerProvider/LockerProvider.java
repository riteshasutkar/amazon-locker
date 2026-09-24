package lockerProvider;

import entities.Compartment;
import entities.Locker;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LockerProvider {

    HashMap<String, List<Locker>> lockerMap = new HashMap<>();

    public LockerProvider(List<Locker> lockers) {
        for (Locker locker : lockers) {
            lockerMap.computeIfAbsent(locker.getZipCode(), k -> new java.util.ArrayList<>()).add(locker);
        }
    }

    public Compartment getCompartment(String zipCode, String size) {
        List<Locker> lockersAtZipCode = lockerMap.get(zipCode);

        if (lockersAtZipCode == null) {
            return null;
        }
        // mark the compartment as occupied and return the compartment as soon as we find one that is not occupied
        return lockersAtZipCode.stream()
                .map(locker -> locker.getAndOccupyCompartmentBySize(size))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);

    }

}
