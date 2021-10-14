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

public class CommentDAOMySQL implements CommentDAO {

	private String url = "http://localhost/Cinemates20/commentQueries";
	
	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(comment.getIdList())));
		params.add(new BasicNameValuePair("idComment", String.valueOf(comment.getIdComment())));
		params.add(new BasicNameValuePair("writer", comment.getWriterUsername()));
		params.add(new BasicNameValuePair("text", comment.getText()));
		params.add(new BasicNameValuePair("numberLikes", String.valueOf(comment.getNumberLikes())));
		params.add(new BasicNameValuePair("numberNoLikes", String.valueOf(comment.getNumberNoLikes())));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/saveComment.php");
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
	public void addQuickOpinionToComment(String username, int idList, int idComment, boolean opinion) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		params.add(new BasicNameValuePair("idComment", String.valueOf(idComment)));
		params.add(new BasicNameValuePair("opinion", String.valueOf(opinion)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/addQuickOpinionToComment.php");
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
	public List<Comment> getListComments(int idList) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getListComments.php");
        Comment comment = new Comment();
        List<Comment> listComment = new ArrayList<Comment>();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	      
	         int idComment = 0;
	         String writerUsername = null;
	         String text = null;
	         int numberLikes = 0;
	         int numberNoLikes = 0;
	         int _idList = 0;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                _idList = Integer.parseInt(jsonObject.getString("idList"));
	                text = jsonObject.getString("text");
	                numberLikes = Integer.parseInt(jsonObject.getString("numberLikes"));
	                numberNoLikes = Integer.parseInt(jsonObject.getString("numberNoLikes"));
	                idComment = Integer.parseInt(jsonObject.getString("idComment"));
	                writerUsername =jsonObject.getString("writer");
	                
	                comment.setIdList(_idList);
	                comment.setNumberLikes(numberLikes);
	                comment.setNumberNoLikes(numberNoLikes);
	                comment.setIdComment(idComment);
	                comment.setText(text);
	                comment.setWriterUsername(writerUsername);
			        
			        listComment.add(comment);
		          }

		}catch (Throwable e){
			System.out.println("Error get movielist" +e);
            return null;
		}
		return listComment;
	}

	@Override
	public AtomicBoolean getUserQuickOpinionToComment(String username, int idList, int idComment) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		params.add(new BasicNameValuePair("idComment", String.valueOf(idComment)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getUserQuickOpinionToComment.php");
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
	public void updateUserQuickOpinionToComment(String username, int idList, int idComment, boolean opinion) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		params.add(new BasicNameValuePair("idComment", String.valueOf(idComment)));
		params.add(new BasicNameValuePair("opinion", String.valueOf(opinion)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/updateUserQuickOpinionToComment.php");
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
	public Comment getComment(int idList, int idComment) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("idList", String.valueOf(idList)));
		params.add(new BasicNameValuePair("idComment", String.valueOf(idComment)));
		HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getComment.php");
        Comment comment = new Comment();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	      
	         String writerUsername = null;
	         String text = null;
	         int _idList = 0;
	         int _idComment = 0;
	         int numberLikes = 0;
	         int numberNoLikes = 0;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                _idList = Integer.parseInt(jsonObject.getString("idList"));
	                text = jsonObject.getString("text");
	                numberLikes = Integer.parseInt(jsonObject.getString("numberLikes"));
	                numberNoLikes = Integer.parseInt(jsonObject.getString("numberNoLikes"));
	                _idComment = Integer.parseInt(jsonObject.getString("idComment"));
	                writerUsername =jsonObject.getString("writer");
	                
	                comment.setIdList(_idList);
	                comment.setNumberLikes(numberLikes);
	                comment.setNumberNoLikes(numberNoLikes);
	                comment.setIdComment(_idComment);
	                comment.setText(text);
	                comment.setWriterUsername(writerUsername);
		          }

		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
		return comment;
	}

}
