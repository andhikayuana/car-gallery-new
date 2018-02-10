## Upload Server


### Requirement

1. [PHP](http://php.net/downloads.php)
2. [ngrok](https://ngrok.com/download)

### How to run 

1. serve the server first, don't forget to enter your directory :

```
php -S localhost:8000
```

2. using ngrok for tunneling the local server into internet :

```
ngrok http 8000
```

now you can access your server  from ngrok. example : http://6dd29778.ngrok.io 

example :
```
curl -X POST \
  http://localhost:9090/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW' \
  -H 'postman-token: 4838b888-3a73-9511-c85a-b73c5d9ac585' \
  -F file=@/home/yuana/Pictures/Screenshot_2018-02-07_12-58-32.png
```


