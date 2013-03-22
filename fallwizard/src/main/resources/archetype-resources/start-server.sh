mvn clean
mvn package
java -jar target/${artifactId}-${version}.jar server conf/server-basicAuth.yaml