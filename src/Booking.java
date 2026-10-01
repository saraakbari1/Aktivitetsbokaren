public class Booking {
    // Instance variables
    private int activityNumber;
    private int participants;
    private double totalPrice;

    // Constructor
    public Booking(int activityNumber, int numberOfPeople, double totalPrice) {
        this.activityNumber = activityNumber;
        this.participants = numberOfPeople;
        this.totalPrice = totalPrice;
    }
//Getters(hämtmetoder)

    public int getActivityNumber() {
        return activityNumber;
    }

    public int getNumberOfPeople() {
        return participants;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Returns a text description of the booking
    public String getDescription() {
        String activityName;
        switch (this.activityNumber) {
            case 1:
                activityName = "Programmeringsworkshop";
                break;
            case 2:
                activityName = "Matlagningskurs";
                break;
            case 3:
                activityName = "Träningspass";
                break;
            default:
                activityName = "Okänd aktivitet";
        }
        return activityName + ", " + participants + " deltagare, " + (int) totalPrice + " kr";
    }
}


