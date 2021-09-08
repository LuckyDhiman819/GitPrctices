FROM java:8

ADD target/Spring_Boot_Product_App-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java" , "-jar" , "app.jar" ]

EXPOSE 9090