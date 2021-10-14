package mvp;

import java.util.ArrayList;
import java.util.List;

public class RecommendMoviePresenter {
	public void sendNotification(String title, String dateRelease, String director){
		List<User> listUsers = new ArrayList<User>();
		UserDAOMySQL userDAOMySQL = new UserDAOMySQL();
		listUsers = userDAOMySQL.getAllUsers();
		for(int index = 0; index<listUsers.size(); index++) {
			Notification notification = new Notification();
			notification.setText(title+"/"+director+"/"+dateRelease);
			notification.setTypeOfNotification("Raccomandazione");
			notification.setReadFromUser(false);
			notification.setReceiverUsername(listUsers.get(index).getUsername());
			notification.setSenderUsername("admin");
			NotificationDAOMySQL notificationDAOMySQL = new NotificationDAOMySQL();
			notificationDAOMySQL.saveNotification(notification);
		}
	}
	
	public List<Movie> getListMovie() {
		List<Movie> listMovie = new ArrayList<Movie>();
		OpenMovieAPI openMovieAPI = new OpenMovieAPI();
		listMovie = openMovieAPI.searchMovie("", "", "", "", 2021);
		return listMovie;
	}
}
