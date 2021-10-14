package mvp;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;


public class OpenMovieAPI implements ExternalMovieDAO{
	
	public String searchDirector(String idFilm) {
		String urlDirector = "https://api.themoviedb.org/3/movie/"+idFilm+"/credits?api_key=b115c914f390bfeb9f5349f4d6be4f07";
		
        try{
            URL obj = new URL(urlDirector);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            System.out.println("\nSending 'GET' request to  URL: " + urlDirector);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            in.close();

            JSONObject myResponse = new JSONObject(response.toString());
            JSONArray mineArrayResults = myResponse.getJSONArray("crew");
            
            for(int index=0; index<mineArrayResults.length(); index++) {
            	JSONObject objectResults = mineArrayResults.getJSONObject(index);
            	if(objectResults.getString("job").equals("Director")) {
            		return objectResults.getString("name");
            	}
            }


        }catch (Exception e){
            System.out.println(e);
        }
        
		return "Sconosciuto";
	} //end searchDirecctor
	
	public String searchPosterPath(String title) {
		String urlPosterPath = "https://api.themoviedb.org/3/search/movie?api_key=b115c914f390bfeb9f5349f4d6be4f07&query="+title;
		
        try{
            URL obj = new URL(urlPosterPath);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            System.out.println("\nSending 'GET' request to  URL: " + urlPosterPath);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            in.close();

            JSONObject myResponse = new JSONObject(response.toString());
            System.out.println("RISULTATI: " + myResponse);
            JSONArray mineArrayResults = myResponse.getJSONArray("results");
            for(int index=0; index<mineArrayResults.length(); index++) {
            	JSONObject objectResults = mineArrayResults.getJSONObject(index);
            	return objectResults.getString("poster_path");
            	
            }


        }catch (Exception e){
            System.out.println(e);
        }
        
		return "/NoImage";
	} //end searchPosterPath
	
	public List<Movie> searchMovie(String title, String movieDirector, String actor, String genre, int year) {
		
		 List<Movie> listMovie = new ArrayList<Movie>();

	     TmdbApi tmdbApi = new TmdbApi("b115c914f390bfeb9f5349f4d6be4f07");
	     
	        if(!title.equals("")){ //search by title
	            MovieResultsPage movieResultsPage = tmdbApi.getSearch().searchMovie(title,null,"en",false,1);
	            List<MovieDb> listMovies = movieResultsPage.getResults();
	            for(MovieDb movieDb : listMovies) {
	       		 	Movie movie = new Movie();
	            	movie.setTitle(movieDb.getOriginalTitle());
	            	String plusTitle = movie.getTitle().replaceAll("\\s", "+");
	            	movie.setUrlImage(searchPosterPath(plusTitle));
	            	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            	try {
						movie.setReleaseDate(dateFormat.parse(movieDb.getReleaseDate()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						
					}
	            	movie.setDirector(searchDirector(Integer.toString(movieDb.getId())));
	            	
	            	listMovie.add(movie);
	            }
	            
	        }else if(!movieDirector.equals("")){ //search by director
	            MovieResultsPage movieResultsPage = tmdbApi.getSearch().searchMovie(movieDirector,null,"en",false,1);
	            List<MovieDb> listMovies = movieResultsPage.getResults();
	            for(MovieDb movieDb : listMovies) {
	       		 	Movie movie = new Movie();
	            	movie.setTitle(movieDb.getOriginalTitle());
	            	String plusTitle = movie.getTitle().replaceAll("\\s", "+");
	            	movie.setUrlImage(searchPosterPath(plusTitle));
	            	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	            	try {
						movie.setReleaseDate(dateFormat.parse(movieDb.getReleaseDate()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	movie.setDirector(searchDirector(Integer.toString(movieDb.getId())));
	            	
	            	listMovie.add(movie);
	            }
	        }else if(!actor.equals("")){ //search by actor
	        	MovieResultsPage movieResultsPage = tmdbApi.getSearch().searchMovie(actor,null,"en",false,1);
	            List<MovieDb> listMovies = movieResultsPage.getResults();
	            for(MovieDb movieDb : listMovies) {
	       		 	Movie movie = new Movie();
	            	movie.setTitle(movieDb.getOriginalTitle());
	            	String plusTitle = movie.getTitle().replaceAll("\\s", "+");
	            	movie.setUrlImage(searchPosterPath(plusTitle));
	            	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
	            	try {
						movie.setReleaseDate(dateFormat.parse(movieDb.getReleaseDate()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	            	movie.setDirector(searchDirector(Integer.toString(movieDb.getId())));
	            	
	            	listMovie.add(movie);
	            }
	        }else if(!genre.equals("")){
	            String url_genre= "https://api.themoviedb.org/3/discover/movie?api_key=b115c914f390bfeb9f5349f4d6be4f07&with_genres=";
	            String id = "0";
	            
	           if(genre.equals("Azione")){
	                id = "28";
	           }else if(genre.equals("Avventura")){
	                id = "12";
	           }else if(genre.equals("Animazione")){
	                id = "16";
	           }else if(genre.equals("Commedia")){
	                id = "35";
	           }else if(genre.equals("Crime")){
	                id = "80";
	           }else if(genre.equals("Documentario")){
	                id = "99";
	           }else if(genre.equals("Drammatico")){
	                id  = "18";
	           }else if(genre.equals("Famiglia")){
	                id = "10751";
	           }else if(genre.equals("Fantasy")){
	                id = "14";
	           }else if(genre.equals("History")){
	                id = "36";
	           }else if(genre.equals("Horror")){
	                id = "27";
	           }else if(genre.equals("Music")){
	                id = "10402";
	           }else if(genre.equals("Mystery")){
	                id = "9648";
	           }else if(genre.equals("Sentimentale")){
	                id = "10749";
	           }else if(genre.equals("Science Fiction")){
	                id = "878";
	           }else if(genre.equals("TV Movie")){
	                id = "10770";
	           }else if(genre.equals("Thriller")){
	                id = "53";
	           }else if(genre.equals("War")){
	                id = "10752";
	           }else if(genre.equals("Western")){
	                id = "37";
	           }
	           url_genre = url_genre+id;

	            try{
	                URL obj = new URL(url_genre);
	                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	                System.out.println("\nSending 'GET' request to  URL: " + url_genre);

	                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	                String inputLine;
	                StringBuffer response = new StringBuffer();

	                while((inputLine = in.readLine()) != null){
	                    response.append(inputLine);
	                }

	                in.close();

	                JSONObject myResponse = new JSONObject(response.toString());
	                JSONArray mineArrayResults = myResponse.getJSONArray("results");
	                for(int index = 0; index< mineArrayResults.length(); index++) { //Iterate the results array
	           		 	Movie movie = new Movie();
	           		 	
	                	JSONObject objectResults = mineArrayResults.getJSONObject(index);
	                	
	                	movie.setTitle(objectResults.getString("original_title"));
	                	movie.setUrlImage(objectResults.getString("poster_path"));
	                	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
	                	movie.setReleaseDate(dateFormat.parse(objectResults.getString("release_date")));
	                	movie.setDirector(searchDirector(Integer.toString(objectResults.getInt("id"))));
	                        	
	                	listMovie.add(movie);
	                }
	                        

	            }catch (Exception e){
	                System.out.println(e);
	            }

	        }else if(year != 0000){
	            MovieResultsPage movieResultsPage = tmdbApi.getSearch().searchMovie("a",year,"en",false,1);
	        	List<MovieDb> listMovies = movieResultsPage.getResults();
	            for(MovieDb movieDb : listMovies) {
	       		 	Movie movie = new Movie();
	            	movie.setTitle(movieDb.getTitle());
	            	String plusTitle = movie.getTitle().replaceAll("\\s", "+");
	            	movie.setUrlImage(searchPosterPath(plusTitle));
	            	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	            	try {
						movie.setReleaseDate(dateFormat.parse(movieDb.getReleaseDate()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	movie.setDirector(searchDirector(Integer.toString(movieDb.getId())));
	            	listMovie.add(movie);
	            }
	        }else{
	            System.out.println("Error during the search");
	        }


	        return listMovie;
	    }
	}
