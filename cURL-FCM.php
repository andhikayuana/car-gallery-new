<?php

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "https://fcm.googleapis.com/fcm/send",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => "{\n  \"registration_ids\":[\"fPkDq305ChI:APA91bG2nLwsbEejvc60EAPZRfbNfzSal08efkWoEF4mQC6JVO2pYA6WANo7ciCOiUmAOeKR2PY0fXdmm6iTDhYBkAMgWaZELz5wW5i64dQdHwvMPHu0kooi8jJeR3A3AbMsj3ururC9\", \"e1sD7T8qVAo:APA91bFeyEPfBy_3qmY9IYJCPv9TfsysZ7vVvlzyHdOupfS_FYfL1dgt8IoeDjgGcm1BdefcQsraYAcotTKA5oAYt4c9qPUhGhJpl6XWM5p8z2e_zFWTJpxIfTeN9Yx4XPXoTeQRBOCW\"],\n  \"priority\":\"high\",\n  \"notification\":{\n    \"title\":\"Halo App\",\n    \"body\":\"body\",\n    \"sound\":\"default\",\n    \"vibrate\":true,\n    \"color\":\"#3c8dbc\",\n    \"data\":{\n      \"data\":\"todata\"\n    }\n  }\n}",
  CURLOPT_HTTPHEADER => array(
    "authorization: key=AAAAzKOYMKQ:APA91bHyl7XjT7LWA8dGo4-guVWXJCJPPl-WLjZXBV_iGTAseqdV3MS7JNZYdBWRCDY_k854zcUBp_C6g9jxfYAXfyl25HHqeE4pXJ6-KR_zra_f49eO55qdAJQXyOA82EBD5G7SMHR3",
    "cache-control: no-cache",
    "content-type: application/json",
    "postman-token: 20225173-f00b-47aa-2005-b10c5301656d"
  ),
));

$response = curl_exec($curl);
$err = curl_error($curl);

curl_close($curl);

if ($err) {
  echo "cURL Error #:" . $err;
} else {
  echo $response;
}
