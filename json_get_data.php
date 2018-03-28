<?php

$host  = "localhost";
$user_name=  "root";
$password  = "";
$db_name = "project";
$sql=  "select * from project_info ;";

$con = mysqli_connect($host,$user_name,$password,$db_name);

$result = mysqli_query( $con, $sql);

$response = array();
while( $row =  mysqli_fetch_array( $result ))     
{
	array_push($response, array("name"=>$row[0],"details"=>$row[1],"project_id"=>$row[2]));
}

echo json_encode(array("server_response"=>$response));

mysqli_close($con);

?>
