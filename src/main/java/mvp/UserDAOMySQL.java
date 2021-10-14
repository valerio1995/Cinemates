package mvp;

import java.util.regex.Pattern;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


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

public class UserDAOMySQL implements UserDAO{
	private String url = "http://ec2-13-59-48-12.us-east-2.compute.amazonaws.com/CineMates20/userQueries";
	
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("email", email));
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getUserByEmail.php");
        User user = new User();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         String password = null;
	         String _email = null;
	         String username = null;
	         String name = null;
	         String surname = null;
	         String gender = null;
	         Date birth = null;
	         String country = null;
	         boolean listVisibility = false;
	         boolean receptionStatus = false;
	         boolean commentsStatus = false;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                
		            password = jsonObject.getString("password");
		            _email = jsonObject.getString("email");
		            username = jsonObject.getString("username");
		            name = jsonObject.getString("name");
		            surname = jsonObject.getString("surname");
		            gender = jsonObject.getString("gender");
		            birth = Date.valueOf(jsonObject.getString("birth"));
		            country = jsonObject.getString("country");
		            listVisibility = Boolean.parseBoolean(jsonObject.getString("listVisibility"));
		            receptionStatus = Boolean.parseBoolean(jsonObject.getString("receptionStatus"));
		            commentsStatus = Boolean.parseBoolean(jsonObject.getString("commentsStatus"));
	          }
	         
	         
		         user.setEmail(_email);
		         user.setPassword(password);
		         user.setUsername(username);
		         user.setName(name);
		         user.setSurname(surname);
		         user.setGender(gender);   
		         user.setDateBirth(birth);
		         user.setCountry(country);
		         user.setListVisibility(listVisibility);
		         user.setReceptionStatus(receptionStatus);
		         user.setCommentsStatus(commentsStatus);
	                           

		}catch (Throwable e){
			System.out.println("Failed: "+e);
            return null;
		}

		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", username));
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getUserByUsername.php");
        User user = new User();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         String password = null;
	         String _username = null;
	         String email = null;
	         String name = null;
	         String surname = null;
	         String gender = null;
	         Date birth = null;
	         String country = null;
	         boolean listVisibility = false;
	         boolean receptionStatus = false;
	         boolean commentsStatus = false;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                _username = jsonObject.getString("username");
	                password = jsonObject.getString("password");
	                email = jsonObject.getString("email");
	                name = jsonObject.getString("name");
	                surname = jsonObject.getString("surname");
	                gender = jsonObject.getString("gender");
	                birth = Date.valueOf(jsonObject.getString("birth"));
	                country = jsonObject.getString("country");
	                listVisibility = Boolean.parseBoolean(jsonObject.getString("listVisibility"));
	                receptionStatus = Boolean.parseBoolean(jsonObject.getString("receptionStatus"));
	                commentsStatus = Boolean.parseBoolean(jsonObject.getString("commentsStatus"));
	          }
	         user.setUsername(_username);
	         user.setEmail(email);
	         user.setPassword(password);
	         user.setName(name);
	         user.setSurname(surname);
	         user.setGender(gender);
	         user.setDateBirth(birth);
	         user.setCountry(country);
	         user.setListVisibility(listVisibility);
	         user.setReceptionStatus(receptionStatus);
	         user.setCommentsStatus(commentsStatus);
		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
        
		return user;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("email", user.getEmail()));
        params.add(new BasicNameValuePair("password", user.getPassword()));
        params.add(new BasicNameValuePair("username", user.getUsername()));
        params.add(new BasicNameValuePair("name", user.getName()));
        params.add(new BasicNameValuePair("surname", user.getSurname()));
        params.add(new BasicNameValuePair("gender", user.getGender()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        params.add(new BasicNameValuePair("birth", dateFormat.format(user.getDateBirth())));
        params.add(new BasicNameValuePair("country", user.getCountry()));
        params.add(new BasicNameValuePair("listVisibility", String.valueOf(user.isListVisibility())));
        params.add(new BasicNameValuePair("receptionStatus", String.valueOf(user.isReceptionStatus())));
        params.add(new BasicNameValuePair("commentsStatus", String.valueOf(user.isCommentsStatus())));
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/saveUser.php");
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
	public void updateUser(User user) {
		// TODO Auto-generated method stub
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("email", user.getEmail()));
        params.add(new BasicNameValuePair("password", user.getPassword()));
        params.add(new BasicNameValuePair("username", user.getUsername()));
        params.add(new BasicNameValuePair("name", user.getName()));
        params.add(new BasicNameValuePair("surname", user.getSurname()));
        params.add(new BasicNameValuePair("gender", user.getGender()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        params.add(new BasicNameValuePair("birth", dateFormat.format(user.getDateBirth())));
        params.add(new BasicNameValuePair("country", user.getCountry()));
        params.add(new BasicNameValuePair("listVisibility", String.valueOf(user.isListVisibility())));
        params.add(new BasicNameValuePair("receptionStatus", String.valueOf(user.isReceptionStatus())));
        params.add(new BasicNameValuePair("commentsStatus", String.valueOf(user.isCommentsStatus())));
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/updateUser.php");
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
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getAllUsers.php");
        User user = new User();
        List<User> listUsers = new ArrayList<User>();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         String password = null;
	         String username = null;
	         String email = null;
	         String name = null;
	         String surname = null;
	         String gender = null;
	         Date birth = null;
	         String country = null;
	         boolean listVisibility = false;
	         boolean receptionStatus = false;
	         boolean commentsStatus = false;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                username = jsonObject.getString("username");
	                password = jsonObject.getString("password");
	                email = jsonObject.getString("email");
	                name = jsonObject.getString("name");
	                surname = jsonObject.getString("surname");
	                gender = jsonObject.getString("gender");
	                birth = Date.valueOf(jsonObject.getString("birth"));
	                country = jsonObject.getString("country");
	                listVisibility = Boolean.parseBoolean(jsonObject.getString("listVisibility"));
	                receptionStatus = Boolean.parseBoolean(jsonObject.getString("receptionStatus"));
	                commentsStatus = Boolean.parseBoolean(jsonObject.getString("commentsStatus"));
	                
		            user.setEmail(email);
		   	        user.setPassword(password);
			        user.setUsername(username);
			        user.setName(name);
			        user.setSurname(surname);
			        user.setGender(gender);
			        user.setDateBirth(birth);
			        user.setCountry(country);
			        user.setListVisibility(listVisibility);
			        user.setReceptionStatus(receptionStatus);
			        user.setCommentsStatus(commentsStatus);
			        
			        listUsers.add(user);
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return listUsers;
	}

	@Override
	public List<User> getUsersByUsername(String username) {
		// TODO Auto-generated method stub
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				HttpClient client = new DefaultHttpClient();
		        HttpPost httpPost = new HttpPost(url+"/getUsersByUsername.php");
		        User user = new User();
		        List<User> listUsers = new ArrayList<User>();
				try {
					 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
			         HttpResponse response = client.execute(httpPost);
			         String responseString = EntityUtils.toString(response.getEntity());
			         JSONArray jsonArray = new JSONArray(responseString);
			         String password = null;
			         String email = null;
			         String name = null;
			         String surname = null;
			         String gender = null;
			         Date birth = null;
			         String country = null;
			         boolean listVisibility = false;
			         boolean receptionStatus = false;
			         boolean commentsStatus = false;
			         for(int i = 0; i < jsonArray.length(); i++) {
			                JSONObject jsonObject = jsonArray.getJSONObject(i);
			                username = jsonObject.getString("username");
			                if (Pattern.matches("^([a-zA-Z0-9_]*)" + username + "([a-zA-Z0-9_]*)$",username)) {
				                password = jsonObject.getString("password");
				                email = jsonObject.getString("email");
				                name = jsonObject.getString("name");
				                surname = jsonObject.getString("surname");
				                gender = jsonObject.getString("gender");
				                birth = Date.valueOf(jsonObject.getString("birth"));
				                country = jsonObject.getString("country");
				                listVisibility = Boolean.parseBoolean(jsonObject.getString("listVisibility"));
				                receptionStatus = Boolean.parseBoolean(jsonObject.getString("receptionStatus"));
				                commentsStatus = Boolean.parseBoolean(jsonObject.getString("commentsStatus"));
				                
					            user.setEmail(email);
					   	        user.setPassword(password);
						        user.setUsername(username);
						        user.setName(name);
						        user.setSurname(surname);
						        user.setGender(gender);
						        user.setDateBirth(birth);
						        user.setCountry(country);
						        user.setListVisibility(listVisibility);
						        user.setReceptionStatus(receptionStatus);
						        user.setCommentsStatus(commentsStatus);
						        
						        listUsers.add(user);
			                }
				          }

				}catch (Throwable e){
					System.out.println("Failed: " +e);
		            return null;
				}
				return listUsers;
	}

	@Override
	public List<User> getFriends(String username) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getFriends.php");
        User user = new User();
        List<User> listUsers = new ArrayList<User>();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         String username_friend = null;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                username_friend = jsonObject.getString("usernameFriend");
	                user = getUserByUsername(username_friend);
			        listUsers.add(user);
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return listUsers;
	}


	@Override
	public List<User> getDeclinedUsers(String username) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getDeclinedUsers.php");
        User user = new User();
        List<User> listUsers = new ArrayList<User>();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         String declined_username = null;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                declined_username = jsonObject.getString("declinedUsername");
	                user = getUserByUsername(declined_username);
			        listUsers.add(user);
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return listUsers;
	}

	@Override
	public void addFriendUser(String username, String friendUsername) {
		// TODO Auto-generated method stub
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("friendUsername", friendUsername));
        HttpClient client = new DefaultHttpClient(); 
        HttpPost httpPost = new HttpPost(url+"/addFriendUser.php");
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
	public void addDeclineUser(String username, String declinedUsername) {
		// TODO Auto-generated method stub
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("declinedUsername", declinedUsername));
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/addDeclinedUser.php");
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
