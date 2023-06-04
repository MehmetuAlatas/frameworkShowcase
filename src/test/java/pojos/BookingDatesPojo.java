package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {

    //1)Create private variables for every key
    private String checkin;
    private String checkout;

    //2)Create constructor with all parameters, and without any parameter
    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
    public BookingDatesPojo() {
    }

    //3)Create getters and setters
    public String getCheckin() {
        return checkin;
    }
    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
    public String getCheckout() {
        return checkout;
    }
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //4)Create toString() method
    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}