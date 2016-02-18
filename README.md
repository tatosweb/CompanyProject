# CompanyProject

##Description
>This Project demostrates the integration between a REST API made with SparkJava and Java 8 for the Backend and JavaScript and AungularJS for the Frontend.

##CURL Examples
> These are culr commands that are use to handle information of the Company's REST API through the command line

* Find all the Companies:
`curl -i http://localhost:4567/companies`
* Find Company bi Id:
`curl -i http://localhost:4567/companies/ed1290c5-bde9-4163-935a-6f7f482fc59c`
* Create a new Company:
`curl -i -H "Content-type: application/json" -X POST -d '{"name":"company name","address":"street 123","city":"New Yort","country":"United States","email":"contact@company.com","phoneNumber":"555-1234","owners":["Mr. Anderson","Mr. Parker"]}' http://localhost:4567/companies`
* Update a Company:
`curl -i -H "Content-type: application/json" -X PUT -d '{"name":"Company's new name","address":"calle 123","city":"Medellin","country":"Colombia","email":"contact@company.com","phoneNumber":"555-1234","owners":["Mr. Andreson","Mr. Rodriguez"]}' http://localhost:4567/companies/73a26a4e-d949-458d-af15-41aece072901`
* Delete a Company
`curl -i -H "Content-Type: application/json" -X DELETE http://localhost:4567/companies/73a26a4e-d949-458d-af15-41aece072901`

#Database object

##Company
- Id (String)
- Name (String)
- Address (String)
- City (String)
- Country (String)
- Email (String)
- phoneNumber (String)
- Owners (List of Strings)