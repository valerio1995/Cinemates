<?php
require_once('NotificationDAOMySQL.php');
$notificationDAOMySQL = new NotificationDAOMySQL();
$response = $notificationDAOMySQL->saveNotification($_POST['text'],$_POST['typeOfNotification'],$_POST['receiverUsername'],$_POST['senderUsername'],$_POST[readFromUser]);
print json_encode($response);
?>
