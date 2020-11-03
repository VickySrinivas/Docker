FROM openjdk:8u191-jre-alpine3.8

WORKDIR /usr/share/Project3

ADD target/selenium-docker-tests.jar   selenium-docker-tests.jar
ADD target/selenium-docker.jar   selenium-docker.jar
ADD target/libs   libs

ADD Book_Flight.xml Book_Flight.xml
ADD SearchPage.xml  SearchPage.xml

ENTRYPOINT java -cp selenium-docker-tests.jar:selenium-docker.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE
