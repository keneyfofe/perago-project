# Perago Diffing Assessment

Please use this payload to send REST requests.

1. cd to path/to/project/
2. run mvn clean install
3. cd to target folder
4.1. run java -jar class-diffiing-0.0.1-SNAPSHOT.jar
4.2. Alternatively: 
	cd to project folder
	run mvn clean install
	run mvn spring-boot:run

NB: To change host port, check application.properties file configuration.

5. REST endpoint:  http://hostname:8080/api/diffing/v1/diff


# Payloads

1. Create object

[
   null,
   {
      "firstName":"Elsy",
      "surname":"Jones",
      "pet":{
         "id":null,
         "type":"Cat",
         "name":"Rosy"
      }
   }
]

2. Deleted object

[
   {
      "firstName":"Elsy",
      "surname":"jones",
      "pet":{
         "id":null,
         "type":"Cat",
         "name":"Rosy"
      }
   },
   null
]

3. Updated object

[
	{
  "firstName": "Elsy",
  "surname": "Jones",
  "pet": {
    "id": null,
    "type": "Cat",
    "name": "Rosy"
  }
},
	{
  "firstName": "Nil",
  "surname": "Nikky",
  "pet": {
    "id": null,
    "type": "Cat",
    "name": "Rosy"
  }
}
	
]
