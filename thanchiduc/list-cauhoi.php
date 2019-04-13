<?php
	header('Content-Type:application/json');

	define('host', 'localhost');
	define('DB_USER', 'root');
	define('DB_PASS', '');
	define('DB_NAME', 'androi');

	$conn = mysqli_connect(host,DB_USER,DB_PASS,DB_NAME);
	mysqli_set_charset($conn, 'utf8');
	$sql = "SELECT * FROM cauhoi";
	$result = $conn->query($sql);
	$data = [];

	while ($row = mysqli_fetch_assoc($result)) {

		$data[] = $row;
	}

	echo json_encode($data);
	
?>