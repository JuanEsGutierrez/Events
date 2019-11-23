package model;
public class Seat {
    //Constants
    public static final String STATE_OPERATIONAL = "Operational";
    public static final String STATE_DEFECTIVE = "Defective";

    //Attributes
    private String state;

    //Methods
    public Seat() {
        state = STATE_OPERATIONAL;
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
}