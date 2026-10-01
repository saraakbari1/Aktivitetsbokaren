import java.util.ArrayList; // Added by Person 3 to handle storage
import java.util.Scanner;


public class Main {


    static Scanner scanner = new Scanner(System.in);



    private static ArrayList<Booking> bookings = new ArrayList<>();


    public static void main(String[] args) {
        boolean running = true;


        while (running) {
            showMenu();
            int choice = readInt("Välj ett alternativ: ");


            switch (choice) {
                case 1:
                    registerBooking();
                    break;
                case 2:
                    showAllBookings();
                    break;
                case 3:
                    showSummary();
                    break;
                case 4:
                    System.out.println("Programmet avslutas.");
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt menyval. Försök igen.");
                    break;
            }
        }


        scanner.close();
    }






    public static void showMenu() {
        System.out.println();
        System.out.println("AKTIVITETSBOKAREN");
        System.out.println("1. Registrera bokning");
        System.out.println("2. Visa alla bokningar");
        System.out.println("3. Visa sammanställning");
        System.out.println("4. Avsluta");
    }


    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning. Ange ett heltal.");
            }
        }
    }






    public static String activityName(int activityNumber) {
        if (activityNumber == 1) {
            return "Programmeringsworkshop";
        } else if (activityNumber == 2) {
            return "Matlagningskurs";
        } else if (activityNumber == 3) {
            return "Träningspass";
        } else {
            return "t" +
                    "Träningspass";
        }
    }


    public static double calculatePrice(int activityNumber, int participants) {
        double pricePerParticipant;


        if (activityNumber == 1) {
            pricePerParticipant = 200;
        } else if (activityNumber == 2) {
            pricePerParticipant = 300;
        } else if (activityNumber == 3) {
            pricePerParticipant = 150;
        } else {
            pricePerParticipant = 0;
        }


        return pricePerParticipant * participants;
    }


    public static void registerBooking() {
        int activityNumber = readInt(
                "Välj aktivitet (1=Programmeringsworkshop, 2=Matlagningskurs, 3=Träningspass): "
        );


        if (activityNumber != 1 && activityNumber != 2 && activityNumber != 3) {
            System.out.println("Ogiltigt aktivitetsnummer. Bokningen avbryts.");
            return;
        }


        int participants = readInt("Ange antal deltagare: ");


        if (participants <= 0) {
            System.out.println("Antal deltagare måste vara positivt. Bokningen avbryts.");
            return;
        }


        double totalPrice = calculatePrice(activityNumber, participants);


        System.out.println(
                "Bokning registrerad: " + activityName(activityNumber)
                        + ", " + participants + " deltagare, "
                        + (int) totalPrice + " kr"
        );


        Booking newBooking = new Booking(activityNumber, participants, totalPrice);
        bookings.add(newBooking);
    }


    public static void showAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("Det finns inga registrerade bokningar ännu.");
            return;
        }


        System.out.println("\n--- ALLA REGISTRERADE BOKNINGAR ---");
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println("Bokning " + (i + 1) + ": " + bookings.get(i).getDescription());
        }
    }


    public static void showSummary() {
        int totalBookings = bookings.size();
        double totalValue = 0;
        int workshopCount = 0;
        int cookingCount = 0;
        int trainingCount = 0;


        for (Booking b : bookings) {
            totalValue += b.getTotalPrice();


            if (b.getActivityNumber() == 1) {
                workshopCount++;
            } else if (b.getActivityNumber() == 2) {
                cookingCount++;
            } else if (b.getActivityNumber() == 3) {
                trainingCount++;
            }
        }
        System.out.println("\n--- SAMMANSTÄLLNING ---");
        System.out.println("Totalt antal registrerade bokningar: " + totalBookings);
        System.out.println("Sammanlagt värde för alla bokningar: " + (int)totalValue + " kr");
        System.out.println("Antal bokningar för Programmeringsworkshop: " + workshopCount);
        System.out.println("Antal bokningar för Matlagningskurs: " + cookingCount);
        System.out.println("Antal bokningar för Träningspass: " + trainingCount);
    }
}


