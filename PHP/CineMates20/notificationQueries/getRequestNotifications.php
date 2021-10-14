<?php
require_once('NotificationDAOMySQL.php');
$notificationDAOMySQL = new NotificationDAOMySQL();
$response = $notificationDAOMySQL->getRequestNotifications($_POST['senderUsername']);
print json_encode($response);
?>