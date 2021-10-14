package mvp;

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

import java.util.ArrayList;
import java.util.List;

public class AdministratorDAOMySQL implements AdministratorDAO{

	private String url = "http://ec2-13-59-48-12.us-east-2.compute.amazonaws.com/CineMates20/administratorQueries" ;
	
	@Override
	public Administrator getAdministratorByEmail(String email) {
		// TODO Auto-generated method stub
		List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("email", email));
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url+"/getAdministratorByEmail.php");
        Administrator administrator = new Administrator();
		try {
			 httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	         HttpResponse response = client.execute(httpPost);
	         String responseString = EntityUtils.toString(response.getEntity());
	         JSONArray jsonArray = new JSONArray(responseString);
	         String password = null;
	         String _email = null;
	         for(int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	                _email = jsonObject.getString("email");
	                password = jsonObject.getString("password");
	          }
	         
	         administrator.setEmail(_email);
	         administrator.setPassword(password);
	         
		}catch (Throwable e){
			System.out.println("Failed: " +e);
            return null;
		}
        
		return administrator;
	}
}
