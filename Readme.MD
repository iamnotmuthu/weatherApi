<H2>Weather Application </H2>

 Developed as spring Boot Application. Shall be built with Maven build tool. Code is compatible with JDK1.5.<br>
 
Enter your openweathermap app's APPID as app.id in application.properties<br>


Get weather forecast through openweatherman's api. Has provision to get data from other APis too or combination of multiple open APIs with minimal changes, if required in future. <br>

Input url: 
http://localhost:8080/v1/weather?city={city}<br>

Sample Response:
  [
  {
        "dt": 1568721600,
        "wind": {
            "speed": 1.37,
            "deg": 273.697
        },
        "temp": {
            "temp": 305.58,
            "temp_min": 300.502,
            "temp_max": 305.58,
            "pressure": 1003.86,
            "sea_level": 1003.86,
            "grnd_level": 999.44,
            "temp_kf": 5.08,
            "humidity": 77
        }
    }
    ]
    
    Error Response:
    [
    {
        "code": 100,
        "field": "city",
        "message": "City is missing"
    }
]