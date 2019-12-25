package aidev.com.androiddesigns;

public class Initialiser {

    private String timing ,date, timezone;

    public Initialiser(){
    }

    public Initialiser(String timing, String date, String timezone) {
        this.timing = timing;
        this.date = date;
        this.timezone = timezone;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
