Bus Reservation System
======================

###Setup:

1. Install Prerequisite Software:
	* Java 1.8
	* MySql 5.6 + MySql Connector/J + workbench (http://dev.mysql.com/downloads/windows/installer/)
	* Eclipse Luna
	* Install Maven plugin in Eclipse (http://download.eclipse.org/technology/m2e/releases/)

2. Set Enviroment Variables (Paths may vary based on OS and installation): 
	* ```CLASSPATH=C:\Program Files\Java\jdk1.8.0_20\bin```
	* ```PATH=C:\Program Files\Java\jdk1.8.0_20\bin```
	* ```JAVA_HOME=C:\Program Files\Java\jdk1.8.0_20```

3. Clone the source code:
 	```bash
 	git clone https://pg-gitlab.altimetrik.com/ajitd7741594467082644/javatestajit/tree/master/AltimetrikAssesmentTest.git
 	```
 	
4. Import project into eclipse.

5. Make sure eclispe is using currect JDK.

6. Database setup


mysql> use altimetrik_busreservation;


	mysql> desc bus_detail;
+------------------+-------------+------+-----+---------------------+-----------------------------+
| Field            | Type        | Null | Key | Default             | Extra                       |
+------------------+-------------+------+-----+---------------------+-----------------------------+
| BUS_NUMBER       | varchar(50) | NO   | PRI | NULL                |                             |
| OPERATOR_NAME    | varchar(50) | YES  |     | NULL                |                             |
| DEPARTURE        | timestamp   | NO   |     | CURRENT_TIMESTAMP   | on update CURRENT_TIMESTAMP |
| ARRIVAL_TIME     | timestamp   | NO   |     | 0000-00-00 00:00:00 |                             |
| PRICE            | double      | YES  |     | NULL                |                             |
| SOURCE_CITY      | varchar(50) | YES  |     | NULL                |                             |
| DESTINATION_CITY | varchar(50) | YES  |     | NULL                |                             |
+------------------+-------------+------+-----+---------------------+-----------------------------+

mysql> select * from bus_detail;
+------------+----------------+---------------------+---------------------+-------+-------------+------------------+
| BUS_NUMBER | OPERATOR_NAME  | DEPARTURE           | ARRIVAL_TIME        | PRICE | SOURCE_CITY | DESTINATION_CITY |
+------------+----------------+---------------------+---------------------+-------+-------------+------------------+
| MH02AI4323 | NEETA TRAVEL   | 2020-07-01 10:10:10 | 2020-07-01 18:15:40 |   500 | PUNE        | INDORE           |
| MH02AI4324 | ORANGE TRAVEL  | 2020-07-01 19:10:10 | 2020-08-01 05:15:40 |   500 | INDORE      | PUNE             |
| MH02AI4325 | GREEN TRAVEL   | 2020-07-01 15:10:10 | 2020-08-01 03:15:40 |   500 | BANGLORE    | MUMBAI           |
| MH02AI4326 | YELLOW TRAVEL  | 2020-07-01 08:10:10 | 2020-07-01 16:15:40 |   500 | PUNE        | INDORE           |
| MP19LP6789 | GAUTAM TRAVELS | 2020-07-03 08:10:10 | 2020-07-03 18:10:10 |   600 | INDORE      | PUNE             |
+------------+----------------+---------------------+---------------------+-------+-------------+------------------+
5 rows in set (0.00 sec)

7. API Request and Response

URL:
localhost:8080/busSearchDetail

Request Body:
{
    "source":"PUNE",
    "destination":"INDORE",
    "departureDate":"2020-07-01",
    "arrivalDate":"2020-07-03"
}

Response Body:

{
    "departure_details": [
        {
            "busNumber": "MH02AI4323",
            "operatorName": "NEETA TRAVEL",
            "departure": "2020-07-01T04:40:10.000+00:00",
            "arrivalTime": "2020-07-01T12:45:40.000+00:00",
            "price": 500.0,
            "sourceCity": "PUNE",
            "destinationCity": "INDORE"
        },
        {
            "busNumber": "MH02AI4326",
            "operatorName": "YELLOW TRAVEL",
            "departure": "2020-07-01T02:40:10.000+00:00",
            "arrivalTime": "2020-07-01T10:45:40.000+00:00",
            "price": 500.0,
            "sourceCity": "PUNE",
            "destinationCity": "INDORE"
        }
    ],
    "arrival_details": [
        {
            "busNumber": "MP19LP6789",
            "operatorName": "GAUTAM TRAVELS",
            "departure": "2020-07-03T02:40:10.000+00:00",
            "arrivalTime": "2020-07-03T12:40:10.000+00:00",
            "price": 600.0,
            "sourceCity": "INDORE",
            "destinationCity": "PUNE"
        }
    ]
}

