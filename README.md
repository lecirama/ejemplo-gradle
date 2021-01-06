## Linux & Mac
### Build Code, Test,Jar
* ./gradle clean

### Run Jar
* Local:      ./gradlew bootRun 
* Background: nohup bash gradlew bootRun &

### Testing Application
* curl -X GET 'http://localhost:8086/rest/mscovid/test?msg=testing'
