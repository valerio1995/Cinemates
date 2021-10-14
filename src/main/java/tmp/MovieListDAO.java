package tmp;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public interface MovieListDAO {
    MovieList getFavouriteList(String username);
    MovieList getToSeeList(String username);
    MovieList getMovieListObject(int idList);
    void updateMovieListObject(MovieList movieList);
    void addQuickOpinionToMovieList(String username, int idList, boolean opinion);
    List<Float> getAllRates(int idList);
    void addRateToMovieList(String username, int idList, float rate);
    AtomicBoolean getUserQuickOpinionToMovieList(String username, int idList);
    Float getUserRate(String username, int idList);
    void updateUserQuickOpinionToList(String username, int idList, boolean opinion);
    void updateUserRate(String username, int idList, float rate);
}
