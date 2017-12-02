# car-gallery-new
Demo CRUD Android App

## API :

### baseUrl = `http://yuana.dev.php.or.id/slim/public`

### Endpoint :

```
[GET] /cars | get all cars
[GET] /cars/{id} | get cars by id
[POST] /cars | insert cars
body [raw] :
{
    "year": "2011",
    "make": "honda",
    "model": "mobilio"
}
[PUT] /cars/{id} | update cars
body [raw] :
{
    "year": "2015",
    "make": "halo",
    "model": "world"
}
[DELETE] /cars/{id} | delete by id
```
