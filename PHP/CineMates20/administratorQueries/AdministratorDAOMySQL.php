<?php
require_once('DbConnection.php');

class AdministratorDAOMySQL extends DbConnection{
        public function getAdministratorByEmail($emailPOST){
                $conn = $this->OpenCon();
                $email = $conn->real_escape_string($emailPOST);
                $sth = $conn->query("SELECT * FROM Administrators WHERE Email = '$email'");
                $rows = array();
                while($r = $sth->fetch_assoc()){
                    $rows[] = $r;
                }
                $this->CloseCon($conn);
                return $rows;
        } //end getAdministratorByEmail
} //end class
?>
