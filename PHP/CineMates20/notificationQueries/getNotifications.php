<?php
require_once('NotificationDAOMySQL.php');
$notificationDAOMySQL = new NotificationDAOMySQL();
$response = $notificationDAOMySQL->getNotifications($_POST['receiverUsername']);
print json_encode($response);
?>