package lockerProvider;

import entities.Locker;

import java.util.HashMap;
import java.util.List;

public class LockerProvider {

    HashMap<String, List<Locker>> lockerMap = new HashMap<>();

    public LockerProvider() {

    }

    private Locker getLocker(String zipCode, String size) {
        List<Locker> lockersAtZipCode = lockerMap.get(zipCode);

        if (lockersAtZipCode == null) {
            return null;
        }

        return lockersAtZipCode.stream().filter(locker -> locker.getCompartmentBySize(size) != null).findFirst().orElse(null);
    }

}
