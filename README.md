# SpringBootJPAIntegrationHBRelationship
1. Postgress DB is required to run this application
2. this is spring boot application with JPA integrations
3. this is maven integration application
After installing Postgress run the application with below commad
    1. mvn spring-boot:run
4. run the below post main to add/update/fetch the values from DB

localhost:8000//city/add
{
	"name":"Bangalore",
	"population":"2200000"
}
5. Get City

localhost:8000//city/get?1
6. Save guest profile info

localhost:8000//guest/profile
{
"firstName":"Asendra",
"lastName":"Kushwaha",
"email":"k.asendra@gmail.com",
"password":"testing"
}
7. Get Profile Info

localhost:8000//guest/profile/21
    
