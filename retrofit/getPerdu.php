<?php
 
/*
 * Following code will list all the pieces
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// get all piece from piece table
$result = mysql_query("SELECT *FROM piece") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // piece node
    $response["piece"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $piece = array();
        $piece["pid"] = $row["idPiece"];
        $piece["title"] = $row["title"];
        $piece["description"] = $row["description"];
        $piece["location"] = $row["location"];
 
        // push single piece into final response array
        array_push($response["piece"], $piece);
    }
    // success
    $response["success"] = 1;
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no piece found
    $response["success"] = 0;
    $response["message"] = "No piece found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>