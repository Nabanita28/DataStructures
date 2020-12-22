package practise;

public class Movie {

    double rating;
    boolean starred;
    String title;

    public Movie(String title, double rating, boolean starred){
        this.title = title;
        this.rating = rating;
        this.starred = starred;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", starred=" + starred +
                ", title='" + title + '\'' +
                '}';
    }
}
