## Resource application
 ```
 java -jar WebClientAsync-1.0.jar --server.port=8081
 ```

## Client Application
 ```
 java -jar WebClientAsync-1.0.jar
 ```

## Resources

### /personal
 ```
{
   "name":"John",
   "surname":"Smith",
   "company":"Fisher Car Wash"
}
 ```

### /location
 ```
{
   "city":"Dublin",
   "address":"UNIT 33 Slaney Rd"
}
 ```

### /contact
 ```
{
	"phone":"00353 123123123",
	"email":"info@fishercarwash.ie"
}
 ```
 
### /preference
 ```
{
   "openinghours":"00353 123123123",
   "accessible":"yes"
}
 ```

## Client Controller
 
### Reactive endpoint
 ```
http://localhost:8080/client/reactive
 ```
### Asyncronous endpoint
 ```
http://localhost:8080/client/async
 ```