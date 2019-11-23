package model;
public class Event {
    //Attributes
    private String name;
    private String date;
    private String startingTime;
    private String endingTime;
    private String professor;
    private String faculty;
    private int attendees;
    
    //Relationships
    private Auditorium[] reservations;

    //Methods
    /**
     * @param name
     * @param date
     * @param startingTime
     * @param endingTime
     * @param professor
     * @param faculty
     * @param attendees
     * @param auditorium
     */
    public Event(String name, String date, String startingTime, String endingTime, String professor, String faculty, int attendees, Auditorium auditorium) {
        reservations = new Auditorium[8];
        this.name = name;
        this.date = date;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.professor = professor;
        this.faculty = faculty;
        this.attendees = attendees;
        reservations[0] = auditorium;
        reservations[0].setState(Auditorium.STATE_OCCUPIED);
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the startingTime
     */
    public String getStartingTime() {
        return startingTime;
    }

    /**
     * @param startingTime the startingTime to set
     */
    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    /**
     * @return the endingTime
     */
    public String getEndingTime() {
        return endingTime;
    }

    /**
     * @param endingTime the endingTime to set
     */
    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    /**
     * @return the professor
     */
    public String getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    /**
     * @return the faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the attendees
     */
    public int getAttendees() {
        return attendees;
    }

    /**
     * @param attendees the attendees to set
     */
    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    /**
     * @return the reservations
     */
    public String getReservations() {
        String reservation = "";
        for (int i = 0; i < reservations.length; i++) {
            if(reservations[i] != null) {
                reservation += reservations[i].toString();
            }
        }
        return reservation;
    }

    /**
     * @param reservations the reservations to set
     */
    public void setReservations(Auditorium[] reservations) {
        this.reservations = reservations;
    }
}