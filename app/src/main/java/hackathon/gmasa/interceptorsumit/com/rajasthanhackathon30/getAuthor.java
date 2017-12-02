package hackathon.gmasa.interceptorsumit.com.rajasthanhackathon30;

/**
 * Created by sumitghosh on 02/12/17.
 */

public class getAuthor {
    private int Id;
    private String  author_username;
    private String  dept_name;
    private String current_personel;
    private String  previous_personel;
    private String  Image_link;
    private Boolean resolved;
    private int days_to_go;
    private int rating_1to5;
    private int Level;
    private String details;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAuthor_username() {
        return author_username;
    }

    public void setAuthor_username(String author_username) {
        this.author_username = author_username;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getCurrent_personel() {
        return current_personel;
    }

    public void setCurrent_personel(String current_personel) {
        this.current_personel = current_personel;
    }

    public String getPrevious_personel() {
        return previous_personel;
    }

    public void setPrevious_personel(String previous_personel) {
        this.previous_personel = previous_personel;
    }

    public String getImage_link() {
        return Image_link;
    }

    public void setImage_link(String image_link) {
        Image_link = image_link;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public int getDays_to_go() {
        return days_to_go;
    }

    public void setDays_to_go(int days_to_go) {
        this.days_to_go = days_to_go;
    }

    public int getRating_1to5() {
        return rating_1to5;
    }

    public void setRating_1to5(int rating_1to5) {
        this.rating_1to5 = rating_1to5;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}