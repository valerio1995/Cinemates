package tmp;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public interface MovieDAO {
    void deleteMovie(Movie movie);
    AtomicBoolean saveMovie(Movie movie);
    List<Movie> getAllMovies(int idList);
}
