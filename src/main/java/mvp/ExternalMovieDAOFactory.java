package mvp;

public class ExternalMovieDAOFactory {
	public ExternalMovieDAO getExternalFilmDAO() {
		OpenMovieAPI openMovieAPI = new OpenMovieAPI();

        return openMovieAPI;
	}
}
