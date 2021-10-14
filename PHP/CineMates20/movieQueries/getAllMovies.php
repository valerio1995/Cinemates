<?php
require_once('MovieDAOMySQL.php');
$movieDAOMySQL = new MovieDAOMySQL();
$response = $movieDAOMySQL->getAllMovies($_POST['idList']);
print json_encode($response);
?>