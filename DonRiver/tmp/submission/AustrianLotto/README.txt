Problem statement: https://community.topcoder.com/stat?c=problem_statement&pm=1934
This software is built with Apache Maven.
The commands are to be run under the same directory as README.txt

---- RUN  ----
The zip file already contains compiled classes. The jar can be executed standalone. 
use command:				
		java -jar target/AustrianLotto-1.0-SNAPSHOT.jar



---- REBUILD  ----
		mvn clean install
		mvn package



---- TEST  ----
1. Test cases can be found in src/test/resources/testcases.txt
2. Current implementation assumes ONE TEST CASE PER LINE. 
   However, when adding customized test case files, this can be changed easily.
use command:		
		mvn test
