package aidev.com.androiddesigns;

public class Initialiser {

    private String username , bio;

    public Initialiser(){

    }

    public Initialiser(String username, String bio) {
        this.username = username;
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
