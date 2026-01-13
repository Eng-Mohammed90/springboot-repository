Students-System:
It is a Spring Boot MySQL Docker Application

Description:
This project is a Java Spring Boot REST API connected to a MySQL database.
The application is containerized using Docker and deployed to a production environment as part of OS Lab – Assignment #3.

-----------------------------

-->>Technologies Used
- Java Spring Boot
- MySQL
- Docker
- Railway (Production Deployment)

------------------------------

Production URL: (NOTE that you have to use the endpoints; because there is no front-end in the project )


The application is deployed and accessible at: https://students-system-production-85d7.up.railway.app/student 

Tou have to finish the URL with one of these end points:

For viewing all students: use the link with this end point: https://students-system-production-85d7.up.railway.app/showAll

For adding a new student: (for example) https://students-system-production-85d7.up.railway.app/add?name=Omar&major=HR&grade=85   (and you can edit hte values: Omar, HR and 85)

To update a student info: (for example): https://students-system-production-85d7.up.railway.app/update/2?name=Omar&major=CS&grade=88 (and you can edit the ID number (2) and other values)

for deleting a student: https://students-system-production-85d7.up.railway.app/delete/2 (2 is the ID number).