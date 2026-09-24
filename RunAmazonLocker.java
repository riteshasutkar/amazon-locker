import entities.AccessTokens;
import entities.Compartment;
import entities.Locker;
import lockerProvider.LockerProvider;
import services.DeliveryAndCollectionService;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RunAmazonLocker {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // create 2 new lockers with different zip codes and sizes
        // create compartments for each locker
        // add compartments to lockers
        HashMap<String, List<Compartment>> compartmentMapBySize1 = new HashMap<>();
        compartmentMapBySize1.put("small", List.of(new Compartment("compartment1", "small"), new Compartment("compartment2", "small")));
        compartmentMapBySize1.put("medium", List.of(new Compartment("compartment3", "medium"), new Compartment("compartment4", "medium")));
        compartmentMapBySize1.put("large", List.of(new Compartment("compartment5", "large")));

        HashMap<String, List<Compartment>> compartmentMapBySize2 = new HashMap<>();
        compartmentMapBySize2.put("small", List.of(new Compartment("compartment1", "small")));
        compartmentMapBySize2.put("medium", List.of(new Compartment("compartment3", "medium")));

        Locker locker1 = new Locker("locker1", "12345", compartmentMapBySize1);
        Locker locker2 = new Locker("locker2", "67890", compartmentMapBySize2);

        // create a locker provider and add lockers to it
        LockerProvider lockerProvider = new LockerProvider(List.of(locker1, locker2));

        //press R to reserve a compartment in a locker and mark it as occupied
        System.out.println("Press R to reserve a compartment in a locker and mark it as occupied");
        String input = s.nextLine();
        if (!input.equalsIgnoreCase("R")) {
            System.out.println("Invalid input. Exiting.");
            return;
        }

        // try to reserve a compartment in a locker and mark it as occupied
        Compartment reservedCompartment = lockerProvider.getCompartment("12345", "small");

        // then assign a package to the reserved compartment
        // create a deadline for the package and an access token for the package
        // send the access token to the user and let them know the deadline for pickup
        // then deliver the package
        DeliveryAndCollectionService delAndColService = new DeliveryAndCollectionService();
        AccessTokens accessToken = delAndColService.generateAccessToken(reservedCompartment);
        // then remove the package from the compartment and mark it as unoccupied

        System.out.println("Press C to collect the package from the reserved compartment and mark it as unoccupied");
        input = s.nextLine();
        if (!input.equalsIgnoreCase("C")) {
            System.out.println("Invalid input. Exiting.");
            return;
        }
        delAndColService.collectPackage(accessToken, reservedCompartment);
        // then try to reserve a compartment in a locker again
        // then assign a package to the reserved compartment and mark it as occupied
        // then deliver the package
        // then let the deadline pass and empty the compartment and mark it as unoccupied

        // handle exceptions for compartment size not found etc.
        // try with incorrect access token and handle exceptions

    }
}
