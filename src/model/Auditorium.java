package model;
import java.util.Random;
public class Auditorium {
    //Constants
    public static final String STATE_OCCUPIED = "Occupied";
    public static final String STATE_FREE = "Free";
    
    //Attributes
    private String name;
    private String location;
    private String state;

    //Relationships
    private Seat[][] seats;
    
    //Methods
    /**
     * @param name
     * @param location
     */
    public Auditorium(String name, String location) {
        this.name = name;
        this.location = location;
        state = STATE_FREE;
        seats = new Seat[rows()][columns()];
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * @return the seats
     */
    public Seat[][] getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    /**
     * @param row
     * @param column
     * @return an object type Seat
     */
    public Seat getSeat(int row, int column) {
        return seats[row][column];
    }

    public int rows() {
        Random rand = new Random();
        return rand.nextInt((25 - 10) + 1) + 10;
    }

    public int columns() {
        Random rand = new Random();
        return rand.nextInt((15 - 5) + 1) + 5;
    }
}