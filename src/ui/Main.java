package ui;
import model.College;
import java.util.Scanner;
public class Main {
    private College icesi;
    private Scanner input1;
    private Scanner input2;

    public static void main(String[] args) {
        Main obj = new Main();
        boolean x = true;
        boolean sentinel = false;
        boolean sentinel2 = false;
        while(x) {
            System.out.println("Menu");
            System.out.println("1. Create seats \n2. Report defective seats \n3. Percent of defective seats \n4. Add event \n5. Delete event \n6. Exit");
            int option = obj.input2.nextInt();
            switch(option) {
                case 1:
                    System.out.println(obj.icesi.createSeats());
                    sentinel = true;
                    break;
                case 2:
                    if(sentinel) {
                        obj.brokenSeatMain();
                    }
                    else
                        System.out.println("First you have to create the seats");
                    break;
                case 3:
                    if(sentinel) {
                        obj.defectiveSeatsMain();
                    }
                    else
                        System.out.println("First you have to report the defective seats");
                    break;
                case 4:
                    if(sentinel) {
                        obj.addEvent();
                        sentinel2 = true;
                    }
                    else
                        System.out.println("First you have to create the seats");
                    break;
                case 5:
                    if(sentinel2) {
                        obj.deleteEvent();
                    }
                    else
                        System.out.println("First you have to add an event");
                    break;
                case 6:
                    x = false;
                    break;
                default:
                    System.out.println("Error! type a valid option");
                    break;
            }
        }
    }

    public Main() {
        icesi = new College();
        input1 = new Scanner(System.in);
        input2 = new Scanner(System.in);
    }

    public void brokenSeatMain() {
        System.out.println("Select the auditorium");
        System.out.println("1. Manuelita \n2. Google \n3. Varela \n4. Apple \n5. Microsoft \n6. Amazon \n7. Carvajal \n8. Softbank");
        int j = input2.nextInt() - 1;
        System.out.println("How many seats do you want to report?");
        int amount = input2.nextInt();
        for(int i = 0; i < amount; i++) {
            System.out.println(icesi.showSeats(j));
            System.out.println("Write the letter of the seat row");
            String text = input1.nextLine().toUpperCase();
            char row = text.charAt(0);
            System.out.println("Digit the number of the seat");
            int column = input2.nextInt() - 1;
            System.out.println(icesi.brokenSeat(j, row, column));
        }
    }

    public void defectiveSeatsMain() {
        System.out.println("Select the auditorium");
        System.out.println("1. Manuelita \n2. Google \n3. Varela \n4. Apple \n5. Microsoft \n6. Amazon \n7. Carvajal \n8. Softbank");
        int j = input2.nextInt() - 1;
        System.out.println(icesi.defectiveSeats(j));
    }

    public void addEvent() {
        System.out.println("Write the name of the event");
        String name = input1.nextLine().toUpperCase();
        System.out.println("Write the date with the format YYYY-MM-DD");
        String eventDate = input1.nextLine().toUpperCase();
        System.out.println("Write the starting time with the format 24hrs HH:MM");
        String startingTime = input1.nextLine().toUpperCase();
        System.out.println("Write the ending time with the format 24hrs HH:MM");
        String endingTime = input1.nextLine().toUpperCase();
        System.out.println("Write the name of the professor in charge");
        String professor = input1.nextLine().toUpperCase();
        System.out.println("Write the faculty responsible for the event");
        String faculty = input1.nextLine().toUpperCase();
        System.out.println("Type the number of attendees");
        int attendees = input2.nextInt();
        System.out.println("Type the auditorium where the event takes place");
        System.out.println("1. Manuelita \n2. Google \n3. Varela \n4. Apple \n5. Microsoft \n6. Amazon \n7. Carvajal \n8. Softbank");
        int option = input2.nextInt() - 1;
        System.out.println(icesi.addEvent(name, eventDate, startingTime, endingTime, professor, faculty, attendees, option));
    }

    public void deleteEvent() {
        System.out.println("Write the name of the event you want to delete");
        String name = input1.nextLine().toUpperCase();
        System.out.println(icesi.deleteEvent(name));
    }
}