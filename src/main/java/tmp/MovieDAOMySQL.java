package tmp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.sql.Date;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.regex.Pattern;
import java.text.DateFormat;


public class MovieDAOMySQL implements MovieDAO{
	private String url = "http://localhost/Cinemates20/movieQueries";
	
	@Override
	public void deleteMovie(Movie movie) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(movie.getIdListContainer())));
		params.add(new BasicNameValuePair("title", movie.getTitle()));
		params.add(new BasicNameValuePair("director", movie.getDirector()));
		params.add(new BasicNameValuePair("releaseDate", new SimpleDateFormat("yyyy-MM-dd").format(movie.getReleaseDate())));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/deleteMovie.php");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            System.out.println("Problem: " +responseString);
            JSONObject jsonObject = new JSONObject(responseString);
            int check = jsonObject.getInt("response");
            if(check == 0)
            	System.out.println("Success");
        } catch (Throwable e) {
        	System.out.println("Failed: " +e);
        }
	}

	@Override
	public AtomicBoolean saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(movie.getIdListContainer())));
		params.add(new BasicNameValuePair("title", movie.getTitle()));
		params.add(new BasicNameValuePair("director", movie.getDirector()));
		params.add(new BasicNameValuePair("releaseDate", new SimpleDateFormat("yyyy-MM-dd").format(movie.getReleaseDate())));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/saveMovie.php");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            System.out.println("Problem: " +responseString);
            JSONObject jsonObject = new JSONObject(responseString);
            int check = jsonObject.getInt("response");
            if(check == 0)
            	System.out.println("Success");
        } catch (Throwable e) {
        	System.out.println("Failed: " +e);
        }
		
		return null;
	}

	@Override
	public List<Movie> getAllMovies(int idList) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getAllMovies.php");
        Movie movie = new Movie();
        List<Movie> listMovies = new ArrayList<Movie>();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         int idListContainer = 0;
	         String title = null;
	         Date releaseDate = null;
	         String director = null;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                idListContainer = Integer.parseInt(jsonObject.getString("idList"));
	                title = jsonObject.getString("title");
	                director = jsonObject.getString("director");
	                releaseDate = Date.valueOf(jsonObject.getString("releaseDate"));
	                
		            movie.setDirector(director);
		            movie.setIdListContainer(idListContainer);
		            movie.setReleaseDate(releaseDate);
		            movie.setTitle(title);
			        
			        listMovies.add(movie);
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return listMovies;

	}
}
