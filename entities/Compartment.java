package entities;

public class Compartment {

    String id;
    String lockerName;
    String size;
    boolean isOccupied;

    public Compartment(String id, String size) {
        this.id = id;
        this.size = size;
        this.isOccupied = false;
    }

    public String getId() {
        return id;
    }

    public String getLockerName() {
        return lockerName;
    }

    public String getSize() {
        return size;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
