mvn clean
mvn package
java -jar target/${artifactId}-${version}.jar server configuration/server-basicAuth.yaml