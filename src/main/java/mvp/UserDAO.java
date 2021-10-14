package mvp;

import java.util.List;

public interface UserDAO {
	public User getUserByEmail(String email);
	public User getUserByUsername(String username);
	public List<User> getUsersByUsername(String username);
	public List<User> getFriends(String username);
	public void saveUser(User user);
	public void updateUser(User user);
	public void addFriendUser(String username, String friendUsername);
	public void addDeclineUser(String username, String declineUsername);
	public List<User >getAllUsers();
	public List<User> getDeclinedUsers(String username);
}
