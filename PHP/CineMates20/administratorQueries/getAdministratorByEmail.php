<?php
require_once('AdministratorDAOMySQL.php');
$administratorDAOMySQL = new AdministratorDAOMySQL();
$response = $administratorDAOMySQL->getAdministratorByEmail($_POST['email']);
print json_encode($response);
?>
