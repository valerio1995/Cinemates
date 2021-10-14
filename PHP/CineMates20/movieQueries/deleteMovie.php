<?php
require_once('MovieDAOMySQL.php');
$movieDAOMySQL = new MovieDAOMySQL();
$response = $movieDAOMySQL->deleteMovie($_POST['idList'],$_POST['title'],$_POST['director'],$_POST['releaseDate']);
print json_encode($response);
?>