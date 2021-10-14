<?php
class DbConnection{
        //Credentials
        private $server = "mysql-53448-0.cloudclusters.net";
        private $port = 19832;
        private $username = "admin";
        private $password = "OL6TTJqj";
        private $dbname = "Cinemates20";

        public function OpenCon(){
                //Connection to database
                $conn = new mysqli($this->server,$this->username,$this->password,$this->dbname,$this->port);
                if($conn === false){
                        die("Failed Connection: ". $conn->connect_error);
                }
                $conn->set_charset('utf8mb4');
                return $conn;
        } //end OpenCon

        public function CloseCon($conn){
                $conn->close();
        } //end CloseCon

} //end class
?>
