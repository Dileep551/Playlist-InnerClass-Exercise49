public class Song {

    private String title;
    private double duration;

    public double getDuration() {
        return duration;
    }

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "title : " + title + " duration : " + duration;
    }
}
