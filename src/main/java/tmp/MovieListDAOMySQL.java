package tmp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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


public class MovieListDAOMySQL implements MovieListDAO{

	private String url = "http://localhost/Cinemates20/movieListQueries";

	@Override
	public MovieList getFavouriteList(String username) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getFavouriteList.php");
        MovieList movieList = new MovieList();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         int idList = 0;
	         String typeList = null;
	         int numberLikes = 0;
	         int numberNoLikes = 0;
	         float totalRating = 0;
	         String usernameOwner = null;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                idList = Integer.parseInt(jsonObject.getString("idList"));
	                typeList = jsonObject.getString("typeList");
	                numberLikes = Integer.parseInt(jsonObject.getString("numberLikes"));
	                numberNoLikes = Integer.parseInt(jsonObject.getString("numberNoLikes"));
	                totalRating = Integer.parseInt(jsonObject.getString("totalRating"));
	                usernameOwner =jsonObject.getString("usernameOwner");
			        
		          }
	         
             movieList.setIdList(idList);
             movieList.setNumberLikes(numberLikes);
             movieList.setNumberNoLikes(numberNoLikes);
             movieList.setTotalRating(totalRating);
             movieList.setTypeList(typeList);
             movieList.setUsernameOwner(usernameOwner);

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return movieList;

	}


	@Override
	public MovieList getToSeeList(String username) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getToSeeList.php");
        MovieList movieList = new MovieList();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         int idList = 0;
	         String typeList = null;
	         int numberLikes = 0;
	         int numberNoLikes = 0;
	         float totalRating = 0;
	         String usernameOwner = null;

	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                idList = Integer.parseInt(jsonObject.getString("idList"));
	                typeList = jsonObject.getString("typeList");
	                numberLikes = Integer.parseInt(jsonObject.getString("numberLikes"));
	                numberNoLikes = Integer.parseInt(jsonObject.getString("numberNoLikes"));
	                totalRating = Integer.parseInt(jsonObject.getString("totalRating"));
	                usernameOwner =jsonObject.getString("usernameOwner");
	               
		          }
	         
             movieList.setIdList(idList);
             movieList.setNumberLikes(numberLikes);
             movieList.setNumberNoLikes(numberNoLikes);
             movieList.setTotalRating(totalRating);
             movieList.setTypeList(typeList);
             movieList.setUsernameOwner(usernameOwner);

		}catch (Throwable e){
			System.out.println("Error get movielist" +e);
            return null;
		}
		return  movieList;
	}

	@Override
	public MovieList getMovieListObject(int idList) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getMovieListObject.php");
        MovieList movieList = new MovieList();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	      
	         String typeList = null;
	         int numberLikes = 0;
	         int numberNoLikes = 0;
	         float totalRating = 0;
	         String usernameOwner = null;
	         int _idList = 0;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                _idList = Integer.parseInt(jsonObject.getString("idList"));
	                typeList = jsonObject.getString("typeList");
	                numberLikes = Integer.parseInt(jsonObject.getString("numberLikes"));
	                numberNoLikes = Integer.parseInt(jsonObject.getString("numberNoLikes"));
	                totalRating = Integer.parseInt(jsonObject.getString("totalRating"));
	                usernameOwner =jsonObject.getString("usernameOwner");

		          }
	         
             movieList.setIdList(_idList);
             movieList.setNumberLikes(numberLikes);
             movieList.setNumberNoLikes(numberNoLikes);
             movieList.setTotalRating(totalRating);
             movieList.setTypeList(typeList);
             movieList.setUsernameOwner(usernameOwner);

		}catch (Throwable e){
			System.out.println("Error get movielist" +e);
            return null;
		}
		return movieList;
	}

	@Override
	public void updateMovieListObject(MovieList movieList) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(movieList.getIdList())));
		params.add(new BasicNameValuePair("numberLikes", String.valueOf(movieList.getNumberLikes())));
		params.add(new BasicNameValuePair("numberNoLikes", String.valueOf(movieList.getNumberNoLikes())));
		params.add(new BasicNameValuePair("totalRating", String.valueOf(movieList.getTotalRating())));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/updateMovieListObject.php");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(responseString);
            int check = jsonObject.getInt("response");
            if(check == 0)
            	System.out.println("Success");
        } catch (Throwable e) {
        	System.out.println("Failed: " +e);
        }	
	}

	@Override
	public void addQuickOpinionToMovieList(String username, int idList, boolean opinion) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		params.add(new BasicNameValuePair("opinion", String.valueOf(opinion)));

		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/addQuickOpinionToMovieList.php");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(responseString);
            int check = jsonObject.getInt("response");
            if(check == 0)
            	System.out.println("Success");
        } catch (Throwable e) {
        	System.out.println("Failed: " +e);
        }	
	}

	@Override
	public List<Float> getAllRates(int idList) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getAllRates.php");
        List<Float> listRates = new ArrayList<Float>();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	      
	         float rate;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                rate = Integer.parseInt(jsonObject.getString("rate"));

			        listRates.add(rate);
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return listRates;
	}

	@Override
	public void addRateToMovieList(String username, int idList, float rate) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		params.add(new BasicNameValuePair("rate", String.valueOf(rate)));

		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/addRateToMovieList.php");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(responseString);
            int check = jsonObject.getInt("response");
            if(check == 0)
            	System.out.println("Success");
        } catch (Throwable e) {
        	System.out.println("Failed: " +e);
        }	
	}

	@Override
	public AtomicBoolean getUserQuickOpinionToMovieList(String username, int idList) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getUserQuickOpinionToMovieList.php");
        AtomicBoolean isTrue = new AtomicBoolean(true);
        AtomicBoolean isFalse = new AtomicBoolean(false);
        boolean opinion = false;
        try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                opinion = Boolean.parseBoolean(jsonObject.getString("opinion"));		          
	                }
		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		if(opinion == true) {
			return isTrue;
		}else {
		}
			return isFalse;
	}

	@Override
	public Float getUserRate(String username, int idList) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getUserRate.php");
		
        float rate = 0;
        try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);

	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                rate = Integer.parseInt(jsonObject.getString("rate"));
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return rate;
	}

	@Override
	public void updateUserQuickOpinionToList(String username, int idList, boolean opinion) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		params.add(new BasicNameValuePair("opinion", String.valueOf(opinion)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/updateUserQuickOpinionToList.php");
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
	public void updateUserRate(String username, int idList, float rate) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		params.add(new BasicNameValuePair("rate", String.valueOf(rate)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/updateUserRate.php");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(responseString);
            int check = jsonObject.getInt("response");
            if(check == 0)
            	System.out.println("Success");
        } catch (Throwable e) {
        	System.out.println("Failed: " +e);
        }	
		
	}

}
