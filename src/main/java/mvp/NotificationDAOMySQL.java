package mvp;

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

public class NotificationDAOMySQL implements NotificationDAO{
	private String url = "http://ec2-13-59-48-12.us-east-2.compute.amazonaws.com/CineMates20/notificationQueries" ;
	@Override
	public void saveNotification(Notification notification) {
		// TODO Auto-generated method stub
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("text", notification.getText()));
        params.add(new BasicNameValuePair("typeOfNotification", notification.getTypeOfNotification()));
        params.add(new BasicNameValuePair("receiverUsername", notification.getReceiverUsername()));
        params.add(new BasicNameValuePair("senderUsername", notification.getSenderUsername()));
        params.add(new BasicNameValuePair("readFromUser", String.valueOf(notification.isReadFromUser())));
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/saveNotification.php");
        System.out.println(notification.getText());
        System.out.println(notification.getTypeOfNotification());
        System.out.println(notification.getReceiverUsername());
        System.out.println(notification.getSenderUsername());
        System.out.println(notification.isReadFromUser());
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(responseString);
            int check = jsonObject.getInt("response");
            System.out.println("Check: "+check);
            if(check == 0)
            	System.out.println("Success");
        } catch (Throwable e) {
        	System.out.println("Failed: " +e);
        }
		
	}

	@Override
	public List<Notification> getRequestNotifications(String senderUsername) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("senderUsername", senderUsername));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getRequestNotifications.php");
        Notification notification = new Notification();
        List<Notification> listNotification = new ArrayList<Notification>();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         String text = null;
	         String _senderUsername = null;
	         String typeOfNotification = null;
	         String receiverUsername = null;
	         boolean readFromUser = false;
	         
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                text = jsonObject.getString("text");
	                typeOfNotification = jsonObject.getString("typeOfNotification");
	                receiverUsername = jsonObject.getString("receiverUsername");
	                readFromUser = Boolean.parseBoolean(jsonObject.getString("readFromUser"));
	                _senderUsername = jsonObject.getString("senderUsername");
	                
	                notification.setReadFromUser(readFromUser);
	                notification.setReceiverUsername(receiverUsername);
	                notification.setSenderUsername(_senderUsername);
	                notification.setText(text);
	                notification.setTypeOfNotification(typeOfNotification);
			        
			        listNotification.add(notification);
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return listNotification;
	}

	@Override
	public List<Notification> getNotifications(String receiverUsername) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("receiverUsername", receiverUsername));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getNotifications.php");
        Notification notification = new Notification();
        List<Notification> listNotification = new ArrayList<Notification>();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         String text = null;
	         String typeOfNotification = null;
	         String senderUsername = null;
	         String _receiverUsername = null;
	         boolean readFromUser = false;
	         
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                text = jsonObject.getString("text");
	                typeOfNotification = jsonObject.getString("typeOfNotification");
	                senderUsername = jsonObject.getString("senderUsername");
	                readFromUser = Boolean.parseBoolean(jsonObject.getString("readFromUser"));
	                _receiverUsername = jsonObject.getString("receiverUsername");
	                
	                notification.setReadFromUser(readFromUser);
	                notification.setReceiverUsername(_receiverUsername);
	                notification.setSenderUsername(senderUsername);
	                notification.setText(text);
	                notification.setTypeOfNotification(typeOfNotification);
			        
			        listNotification.add(notification);
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return listNotification;
	}

	@Override
	public void updateNotification(Notification notification) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("text", notification.getText()));
        params.add(new BasicNameValuePair("typeOfNotification", notification.getTypeOfNotification()));
        params.add(new BasicNameValuePair("receiverUsername", notification.getReceiverUsername()));
        params.add(new BasicNameValuePair("senderUsername", notification.getSenderUsername()));
        params.add(new BasicNameValuePair("readFromUser", String.valueOf(notification.isReadFromUser())));
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/updateNotification.php");
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse response = client.execute(httpPost);
            String responseString = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(responseString);
            int check = jsonObject.getInt("response");
            if(check == 0)
            	System.out.println("Success");
        } catch (Throwable e) {
        	System.out.println("Failed: "+e);
        }
	}



}
