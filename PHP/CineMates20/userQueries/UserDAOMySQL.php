<?php
require_once('DbConnection.php');

class UserDAOMySQL extends DbConnection{
	public function getUserByEmail($emailPOST){
		$conn = $this->OpenCon();
        $email = $conn->real_escape_string($emailPOST);
        $sth = $conn->query("SELECT * FROM Users WHERE Email = '$email'");
        $rows = array();
        while($r = $sth->fetch_assoc()){
            $rows[] = $r;
        }
        $this->CloseCon($conn);
        return $rows;
	} //end getUserByEmail

	public function getUserByUsername($usernamePOST){
		$conn = $this->OpenCon();
        $username = $conn->real_escape_string($usernamePOST);
        $sth = $conn->query("SELECT * FROM Users WHERE Username = '$username'");
        $rows = array();
        while($r = $sth->fetch_assoc()){
            $rows[] = $r;
        }
        $this->CloseCon($conn);
        return $rows;
	} //end getUserByUsername

	public function saveUser($emailPOST,$passwordPOST,$usernamePOST,$namePOST,$surnamePOST,$genderPOST,$dateBirthPOST,$countryPOST,$listVisibilityPOST,$receptionStatusPOST,$commentsStatusPOST){
		$conn = $this->OpenCon();
		$email = $conn->real_escape_string($emailPOST);
		$password = $conn->real_escape_string($passwordPOST);
		$username = $conn->real_escape_string($usernamePOST);
		$name = $conn->real_escape_string($namePOST);
		$surname = $conn->real_escape_string($surnamePOST);
		$gender = $conn->real_escape_string($genderPOST);
		$dateBirth = date('Y-m-d', strtotime($dateBirthPOST));
		$country = $conn->real_escape_string($countryPOST);
		$listVisibility = $conn->real_escape_string($listVisibilityPOST);
		$receptionStatus = $conn->real_escape_string($receptionStatusPOST);
		$commentsStatus = $conn->real_escape_string($commentsStatusPOST);		
		$sth = $conn->query("INSERT INTO Users VALUES('$email','$password','$username','$name','$surname','$gender', '$dateBirth','$country',$listVisibility,$receptionStatus,$commentsStatus);");
		if($sth){
			$arr = array('response' => 0);
		}else{
			$arr = array('response' => 1);
		}
		$this->CloseCon($conn);
		return $arr;
	} //end saveUser


	public function updateUser($emailPOST,$passwordPOST,$usernamePOST,$namePOST,$surnamePOST,$genderPOST,$dateBirthPOST,$countryPOST,$listVisibilityPOST,$receptionStatusPOST,$commentsStatusPOST){
		$conn = $this->OpenCon();
		$email = $conn->real_escape_string($emailPOST);
		$password = $conn->real_escape_string($passwordPOST);
		$username = $conn->real_escape_string($usernamePOST);
		$name = $conn->real_escape_string($namePOST);
		$surname = $conn->real_escape_string($surnamePOST);
		$gender = $conn->real_escape_string($genderPOST);
		$dateBirth = date('Y-m-d', strtotime($dateBirthPOST));
		$country = $conn->real_escape_string($countryPOST);
		$listVisibility = $conn->real_escape_string($listVisibilityPOST);
		$receptionStatus = $conn->real_escape_string($receptionStatusPOST);
		$commentsStatus = $conn->real_escape_string($commentsStatusPOST);		
		$sth = $conn->query("UPDATE Users SET Email ='$email', Password ='$password', Name ='$name', Surname='$surname', Gender='$gender', Birth='$dateBirth', Country='$country', ListVisibility=$listVisibility, ReceptionStatus=$receptionStatus, CommentsStatus=$commentsStatus WHERE Username='$username';");
		if($sth){
			$arr = array('response' => 0);
		}else{
			$arr = array('response' => 1);
		}
		$this->CloseCon($conn);
		return $arr;
	} //end updateUser

	public function getAllUsers(){
		$conn = $this->OpenCon();
        $sth = $conn->query("SELECT * FROM Users");
        $rows = array();
        while($r = $sth->fetch_assoc()){
            $rows[] = $r;
        }
        $this->CloseCon($conn);
        return $rows;
	} //end getAllUsers

	public function getFriends($usernamePOST){
		$conn = $this->OpenCon();
        $username = $conn->real_escape_string($usernamePOST);
        $sth = $conn->query("SELECT usernameFriend FROM Friendships WHERE Username = '$username'");
        $rows = array();
        while($r = $sth->fetch_assoc()){
            $rows[] = $r;
        }
        $this->CloseCon($conn);
        return $rows;
	} //end getFriends

	public function addFriendUser($usernamePOST,$friendUsernamePOST){
		$conn = $this->OpenCon();
		$username = $conn->real_escape_string($usernamePOST);
		$friendUsername = $conn->real_escape_string($friendUsernamePOST);	
		$sth = $conn->query("INSERT INTO Friendships VALUES ('$username','$friendUsername')");
		if($sth){
			$arr = array('response' => 0);
		}else{
			$arr = array('response' => 1);
		}
		$this->CloseCon($conn);
		return $arr;
	} //end addFriendUser

	public function addDeclinedUser($usernamePOST,$declinedUsernamePOST){
		$conn = $this->OpenCon();
		$username = $conn->real_escape_string($usernamePOST);
		$declinedUsername = $conn->real_escape_string($declinedUsernamePOST);	
		$sth = $conn->query("INSERT INTO UsersDeclined VALUES ('$username','$declinedUsername');");
		if($sth){
			$arr = array('response' => 0);
		}else{
			$arr = array('response' => 1);
		}
		$this->CloseCon($conn);
		return $arr;
	} //end addDeclinedUser

	public function getDeclinedUsers($usernamePOST){
		$conn = $this->OpenCon();
        $username = $conn->real_escape_string($usernamePOST);
        $sth = $conn->query("SELECT declinedUsername FROM UsersDeclined WHERE username = '$username'");
        $rows = array();
        while($r = $sth->fetch_assoc()){
            $rows[] = $r;
        }
        $this->CloseCon($conn);
        return $rows;
	} //end getDeclinedUsers

	public function getUsersByUsername(){
		$conn = $this->OpenCon();
        $sth = $conn->query("SELECT * FROM Users");
        $rows = array();
        while($r = $sth->fetch_assoc()){
            $rows[] = $r;
        }
        $this->CloseCon($conn);
        return $rows;
	} //end getUsersByUsername

} //end class
?>