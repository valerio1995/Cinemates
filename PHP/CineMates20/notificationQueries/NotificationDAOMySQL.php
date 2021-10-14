<?php
require_once('DbConnection.php');

class NotificationDAOMySQL extends DbConnection{
        public function saveNotification($textPOST,$typeOfNotificationPOST,$receiverUsernamePOST,$senderUsernamePOST,$readFromUserPOST){
            $conn = $this->OpenCon();
            $text = $conn->real_escape_string($textPOST);
            $typeOfNotification = $conn->real_escape_string($typeOfNotificationPOST);
            $receiverUsername = $conn->real_escape_string($receiverUsernamePOST);
            $senderUsername = $conn->real_escape_string($senderUsernamePOST);
            $readFromUser = $conn->real_escape_string($readFromUserPOST);	
            $sth = $conn->query("INSERT INTO Notifications VALUES('$text','$typeOfNotification',$readFromUser,'$senderUsername','$receiverUsername')");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
        } //end saveNotification

        public function getRequestNotifications($senderUsernamePOST){
            $conn = $this->OpenCon();
            $senderUsername = $conn->real_escape_string($senderUsernamePOST);
            $sth = $conn->query("SELECT * FROM Notifications WHERE senderUsername = '$senderUsername' AND typeOfNotification = 'Richiesta'");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
        } //end getRequestNotifications

        public function getNotifications($receiverUsernamePOST){
            $conn = $this->OpenCon();
            $receiverUsername = $conn->real_escape_string($receiverUsernamePOST);
            $sth = $conn->query("SELECT * FROM Notifications WHERE receiverUsername = '$receiverUsername'");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
        } //end getNotifications

        public function updateNotification($textPOST,$typeOfNotificationPOST,$receiverUsernamePOST,$senderUsernamePOST,$readFromUserPOST){
            $conn = $this->OpenCon();
            $text = $conn->real_escape_string($textPOST);
            $typeOfNotification = $conn->real_escape_string($typeOfNotificationPOST);
            $receiverUsername = $conn->real_escape_string($receiverUsernamePOST);
            $senderUsername = $conn->real_escape_string($senderUsernamePOST);
            $readFromUser = $conn->real_escape_string($readFromUserPOST);	
            $sth = $conn->query("UPDATE Notifications SET readFromUser = $readFromUser WHERE readFromUser = false AND receiverUsername = '$receiverUsername';");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
        } //end updateNotification
} //end class
?>
