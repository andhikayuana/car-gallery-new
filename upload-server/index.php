<?php

// var_dump($_SERVER);

header('Content-Type: application/json');
if (isset($_FILES['file'])){

    $errors     = array();
    $file_name  = $_FILES['file']['name'];
    $file_size  = $_FILES['file']['size'];
    $file_tmp   = $_FILES['file']['tmp_name'];
    $file_type  = $_FILES['file']['type'];
    $file_ext   = strtolower(end(explode('.',$_FILES['file']['name'])));

    //echo json_encode(getallheaders());exit;

    // $expensions = array("jpeg","jpg","png");

    // if (in_array($file_ext, $expensions) === false) {
    //     $errors[] = "extension not allowed, please choose a JPEG or PNG file.";
    // }

    if ($file_size > 2097152) {
        $errors[] = 'File size must be excately 2 MB';
    }

    if (empty($errors) == true) {
        move_uploaded_file($file_tmp, __DIR__ . DIRECTORY_SEPARATOR . $file_name);

        echo json_encode([
            'code' => 200,
            'msg' => 'success',
            'data' => 'http://' . $_SERVER['HTTP_HOST'] . '/' . $file_name
        ]);
    } else {
        echo json_encode($errors);
    }
} else {
    echo json_encode([
        'code' => 500,
        'msg'  =>'Error : no file found!'
    ]);
    throw new Exception("Error : no file found!");

}
