<?php
class DBConnection{
	function getConnection(){

mysql_set_charset('utf8', mysql_connect("localhost","root","") ) or
         die("Could not connect: " . mysql_error());
    //change to your database name
		mysql_select_db("monitors") or 
		     die("Could not select database: " . mysql_error());
	}
}
?>