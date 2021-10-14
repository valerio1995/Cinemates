package mvp;

import java.util.List;

public interface ExternalMovieDAO {
	public List<Movie> searchMovie(String title, String filmDirector, String actor, String genre, int year);
}
