# MyRetailRepo
MyRetail Repository

Valid product id’s for red sky external URL:
13860428, 13860429,13860431, 13860432

Swagger URL:
http://localhost:9090/swagger-ui.html#

Below are the List of API's:

1.get Product By ProductId
GET /api/v1/products/13860428 HTTP/1.1
Host: localhost:9090
Content-Type: application/json
User-Agent: PostmanRuntime/7.19.0
Accept: */*
Cache-Control: no-cache
Postman-Token: d0b09406-090b-48bb-8ab7-4f1798c400f9,d6bc80fc-7a04-418f-b441-5991c223427d
Host: localhost:9090
Accept-Encoding: gzip, deflate
Content-Length: 113
Connection: keep-alive
cache-control: no-cache

{
    "productId": 13860429,
    "currentPrice": {
        "value": 222.77,
        "currencyCode": "USD"
    }
}

2. update Product Price
PUT /api/v1/products/13860428 HTTP/1.1
Host: localhost:9090
Content-Type: application/json
User-Agent: PostmanRuntime/7.19.0
Accept: */*
Cache-Control: no-cache
Postman-Token: 9dd41c73-b450-4884-b365-e3aed2693335,ed3d5f69-0efb-481a-91a6-500e474cdbe3
Host: localhost:9090
Accept-Encoding: gzip, deflate
Content-Length: 113
Connection: keep-alive
cache-control: no-cache

{
    "productId": 13860428,
    "currentPrice": {
        "value": 888.77,
        "currencyCode": "USD"
    }
}

3. get Product Name BY Id
GET /api/v1/productName/13860428 HTTP/1.1
Host: localhost:9090
Content-Type: application/json
User-Agent: PostmanRuntime/7.19.0
Accept: */*
Cache-Control: no-cache
Postman-Token: 4380a251-ba28-4abe-8f39-6edf9f8fad2d,37aa4f2e-543e-4786-964f-69799b000b1a
Host: localhost:9090
Accept-Encoding: gzip, deflate
Content-Length: 113
Connection: keep-alive
cache-control: no-cache

{
    "productId": 13860428,
    "currentPrice": {
        "value": 888.77,
        "currencyCode": "USD"
    }
}

4. insert New Product
POST /api/v1/products HTTP/1.1
Host: localhost:9090
Content-Type: application/json
User-Agent: PostmanRuntime/7.19.0
Accept: */*
Cache-Control: no-cache
Postman-Token: f82c3f76-4c49-4d35-8f66-940072097823,5f95bb80-7b65-4998-9da4-fb1832b11d38
Host: localhost:9090
Accept-Encoding: gzip, deflate
Content-Length: 113
Connection: keep-alive
cache-control: no-cache

{
    "productId": 13860432,
    "currentPrice": {
        "value": 888.77,
        "currencyCode": "USD"
    }
}

MongoDB Details:
Collection Name: current_price
Below are the Available  data:

/* 1 createdAt:13/11/2019, 19:02:52*/
{
	"_id" : ObjectId("5dcc0604afa9d86e1ae37dc1"),
	"product_id" : 13860434,
	"value" : 888.77,
	"currency_code" : "USD",
	"_class" : "com.target.myRetail.domain.CurrentPrice"
},

/* 2 createdAt:13/11/2019, 19:02:28*/
{
	"_id" : ObjectId("5dcc05ecafa9d86e1ae37dc0"),
	"product_id" : 13860431,
	"value" : 888.77,
	"currency_code" : "USD",
	"_class" : "com.target.myRetail.domain.CurrentPrice"
},

/* 3 createdAt:13/11/2019, 19:01:58*/
{
	"_id" : ObjectId("5dcc05ceafa9d86e1ae37dbb"),
	"product_id" : 13860433,
	"value" : 888.77,
	"currency_code" : "USD",
	"_class" : "com.target.myRetail.domain.CurrentPrice"
},

/* 4 createdAt:13/11/2019, 19:00:11*/
{
	"_id" : ObjectId("5dcc0563afa9d86e1ae37dba"),
	"product_id" : 13860432,
	"value" : 888.77,
	"currency_code" : "USD",
	"_class" : "com.target.myRetail.domain.CurrentPrice"
},

/* 5 createdAt:13/11/2019, 17:40:45*/
{
	"_id" : ObjectId("5dcbf2c55f815c504d98fceb"),
	"product_id" : 2222222,
	"value" : 111.77,
	"currency_code" : "USD",
	"_class" : "com.target.myRetail.domain.CurrentPrice"
},

/* 6 createdAt:13/11/2019, 15:41:50*/
{
	"_id" : ObjectId("5dcbd6e6cc538d10f84203ad"),
	"product_id" : 87687876,
	"value" : 2626.22,
	"currency_code" : "AE",
	"_class" : "com.target.myRetail.domain.CurrentPrice"
},

/* 7 createdAt:13/11/2019, 14:58:31*/
{
	"_id" : ObjectId("5dcbccbfcc538d10f84203ac"),
	"product_id" : 13860429,
	"value" : 222.77,
	"currency_code" : "USD",
	"_class" : "com.target.myRetail.domain.CurrentPrice"
},

/* 8 createdAt:13/11/2019, 13:17:11*/
{
	"_id" : ObjectId("5dcbb4ffe147a14da36ae53b"),
	"product_id" : 13860428,
	"value" : 888.77,
	"currency_code" : "USD",
	"_class" : "com.target.myRetail.domain.CurrentPrice"
},

/* 9 createdAt:12/11/2019, 18:08:24*/
{
	"_id" : ObjectId("5dcaa7c0cd475802ab9859cc"),
	"product_id" : 16696652,
	"value" : 96522,
	"currency_code" : "USD"
},

/* 10 createdAt:12/11/2019, 18:08:02*/
{
	"_id" : ObjectId("5dcaa7aacd475802ab9859cb"),
	"product_id" : 16483589,
	"value" : 66522,
	"currency_code" : "USD"
}