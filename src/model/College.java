package model;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class College {
    //Relationships
    private Auditorium[] auditoriums;
    private ArrayList<Event> events;

    //Methods
    public College() {
        auditoriums = new Auditorium[8];
        createAuditoriums();
        events = new ArrayList<Event>();
    }

    /**
     * Creates the auditoriums and adds them to the array of type Auditorium called auditoriums 
     */
    public void createAuditoriums() {
        auditoriums[0] = new Auditorium("Manuelita", "building M");
        auditoriums[1] = new Auditorium("Google", "building A");
        auditoriums[2] = new Auditorium("Varela", "building D");
        auditoriums[3] = new Auditorium("Apple", "building A");
        auditoriums[4] = new Auditorium("Microsoft", "building F");
        auditoriums[5] = new Auditorium("Amazon", "building B");
        auditoriums[6] = new Auditorium("Carvajal", "building C");
        auditoriums[7] = new Auditorium("Softbank", "building E");
    }

    /**
     * Creates the seats and saves them into a matrix of type Seat called seats
     * @return a message
     */
    public String createSeats() {
        for(int i = 0; i < auditoriums.length; i++) {
            Seat[][] seats = auditoriums[i].getSeats();
            for(int j = 0; j < seats.length; j++) {
                for(int k = 0; k < seats[0].length; k++) {
                    seats[j][k] = new Seat();
                }
            }
            auditoriums[i].setSeats(seats);
        }
        return "The seats of each auditorium have been created";
    }

    /**
     * Shows a matrix with the location of each seat
     * @param j
     * @return a message with the seat locations
     */
    public String showSeats(int j) {
        String msg = "";
        Seat[][] seats = auditoriums[j].getSeats();
        String[][] seatsPos = new String[seats.length][seats[0].length];
        char row = 'A';
        for(int i = 0; i < seats.length; i++) {
            for(int k = 0; k < seats[0].length; k++) {
                seatsPos[i][k] = row + Integer.toString(k + 1);
                msg += seatsPos[i][k] + " ";
            }
            row++;
            msg += "\n";
        }
        return msg;
    }

    /**
     * <p>Changes the state of a seat</p>
     * @param j
     * @param rowChar
     * @param column
     * @return a message
     */
    public String brokenSeat(int j, char rowChar, int column) {
        String msg = "";
        int row = rowChar - 'A';
        if(row < auditoriums[j].rows() && column < auditoriums[j].columns()) {
            auditoriums[j].getSeat(row, column).setState(Seat.STATE_DEFECTIVE);
            msg = "The seat has been reported successfully as defective";
        }
        else
            msg = "The seat does not exist";
        return msg;
    }

    /**
     * <p>Calculates the percent of defective seats</p>
     * @param j
     * @return a message with the percent of defective seats
     */
    public String defectiveSeats(int j) {
        int defectSeats = 0;
        Seat[][] seats = auditoriums[j].getSeats();
        for(int i = 0; i < seats.length; i++) {
            for(int k = 0; k < seats[0].length; k++) {
                if(seats[i][k].getState().equals(Seat.STATE_DEFECTIVE)) {
                    defectSeats++;
                }
            }
        }
        double percent = (double)defectSeats / (auditoriums[j].rows() * auditoriums[j].columns());
        percent *= 100;
        return percent + "% of the seats are defective";
    }
    
    /**
     * <p>Create an event and add it to the ArrayList of events</p>
     * <b>pre:</b> the ArrayList events is created, events != null
     * @param name
     * @param eventDate
     * @param startingTime
     * @param endingTime
     * @param professor
     * @param faculty
     * @param attendees
     * @param option
     */
    public String addEvent(String name, String eventDate, String startingTime, String endingTime, String professor, String faculty, int attendees, int option) {
        String msg = "";
        LocalTime limitTime1 = LocalTime.parse("06:59");
        LocalTime limitTime2 = LocalTime.parse("20:01");
        LocalTime startingTime2 = LocalTime.parse(startingTime);
        LocalTime endingTime2 = LocalTime.parse(endingTime);
        if(startingTime2.isAfter(limitTime1) && startingTime2.isBefore(limitTime2) && endingTime2.isAfter(limitTime1) && endingTime2.isBefore(limitTime2)) {
            if(startingTime2.until(endingTime2, ChronoUnit.MINUTES) <= 720 && startingTime2.until(endingTime2, ChronoUnit.MINUTES) >= 120) {
                if(endingTime2.isAfter(startingTime2)) {
                    if(attendees <= auditoriums[option].rows() * auditoriums[option].columns()) {
                        events.add(new Event(name, eventDate, startingTime, endingTime, professor, faculty, attendees, auditoriums[option]));
                        msg = "The event has been added successfully";
                    }
                    else {
                        msg = "The attendees are more than the capacity of the auditorium";
                    }
                }
                else {
                    msg = "The ending time must be after the starting time";
                }
            }
            else {
                msg = "The event must have a duration of at least 2 hours and the max duration is 12 hours";
            }
        }
        else
            msg = "The event does not happen between 7:00 and 20:00";
        return msg;
    }

    /**
     * <p>Deletes an event</p>
     * <b>pre:</b> the ArrayList events is created, events != null
     * @param name of the event to delete
     * @return a message
     */
    public String deleteEvent(String name) {
        String msg = "";
        for(int i = 0; i < events.size(); i++) {
            if(events.get(i).getName().equals(name)) {
                events.remove(i);
                msg = "The event was removed";
            }
        }
        return msg;
    }
}