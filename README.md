# online-book-library
1. How to run this project.
   1) The local machine should have MongoDB.
   2) Download the source file from "github.com/dji756132/online-book-library/tree/master"
   3) It has three modules (book-catalog, book-review, online-service).
      a) Run the Main class of each module at "src/main/java/com.bartsassociates"
      b) book-catalog and book-review have MongoDB repositories.
      c) online-service use WebClient to retrieve data from book-catalog and book-review.

2. How to run a curl command that exercies the endpoint and displays the response.
  1) create a record of book-catalog.
     curl -d '{"bookCatalogId":1, "title": "Learning Spring Boot 3.0", "author": ["Greg L. Turnquist", "Dave Syer"], year:2022}' \
          -H "Content-Type:application/json" \
          -X POST http://localhost:8081/bookcatalog
     curl -d '{"bookCatalogId":2, "title": "Mastering MongoDB 6.x", "author": "Alex Giamas", year:2022}' \
          -H "Content-Type:application/json" \
          -X POST http://localhost:8081/bookcatalog
  2) create a recod of book-review.
     curl -d '{"bookReviewId":1, "bookCatalogId":1, comment:"privide concept and idea in depth!", "rating":9.0} \
          -H "Content-Type:applicaiton/json" \
          -X POST http://localhost:8082/bookreviews
  3) retrieve book-catalog and book-review by book-catalog-ID
     curl -i http://localhost:8083/onlinservices/1

3. Overview of this project
This Spring Boot project, "online-book-library" was built by Gradle with three modules,
which has the microservice architectural style
1) book-catalog, 2) book-review, 3) online-service

1) book-catalog module data persists at a docuemtn database, MongoDB.
  a) It provides boot title, its author and published year.
  b) it supports non-blocking handling with Spring WebFlux, which can save a lot of thread resources.

2) book-review module data also persists at MongoDB. 
  a) It provides bookCatalogID, comment, and its rating.
  b) It also supports non-blocking handling and functional endpoint with route and handle request,
     using stream API with Lambda expression or method reference of Java 8

3) online-service module retrieves data from the book-catalog and book-review modules.
  a) It uses a WebClient, which allows to get data from other modues in a non-blocking fashion.
  b) Its endpoint uses stream API operations (flatMap(), map())
    to get both the book catalog and review based on a bookCatalog ID.


