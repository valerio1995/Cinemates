package tmp;

import java.util.Date;

public class Movie {
    private int idListContainer;
    private String title;
    private Date releaseDate;
    private String director;

    public int getIdListContainer() {
        return idListContainer;
    }

    public void setIdListContainer(int idListContainer) {
        this.idListContainer = idListContainer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Movie))
            return false;
        Movie f = (Movie) object;
        return (this.title).equals(f.title) && (this.director).equals(f.director) &&
                (this.releaseDate).equals(f.releaseDate);
    }
}

