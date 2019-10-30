init:
	git init
	touch .git/info/exclude

#	maven-wrapper
	mvn -N io.takari:maven:wrapper -Dmaven=3.6.2
	rm mvnw
#	chmod +x ./mvnw
	echo "\n/.mvn\n/mvnw.cmd*\n" >> .git/info/exclude

#	jenv
#	jenv local openjdk64-`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:java.version`
#	echo "\n/.java-version\n" >> .git/info/exclude

#	checkstyler
#	curl -O https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
#	echo "\n/google_checks.xml\n" >> .git/info/exclude

uninit:
	rm -rf .mvn mvnw* google_checks.xml .git/info/exclude

reboot: clear uninit init

uninit-full: clear uninit
	rm -rf .idea Java-for-testers.iml .git

reboot-full: uninit-full init
	echo "\n/.idea/\n/Java-for-testers.iml\n/out/\n/classes/\n" >> .git/info/exclude
	git add src .editorconfig .gitignore Makefile pom.xml README.md
	idea pom.xml

jshell:
	jshell --enable-preview --start PRINTING --start JAVASE --class-path `mvn dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1`

build:
	./mvnw verify
	chmod +x ./target/Java-for-testers-0.0.1-SNAPSHOT.jar

run:
#	./mvnw spring-boot:start -Dspring.profiles.active=local
#	./target/Java-for-testers-0.0.1-SNAPSHOT.jar
	java -jar --enable-preview ./target/Java-for-testers-0.0.1-SNAPSHOT-jar-with-dependencies.jar

clear:
	./mvnw clean

test: clear
	./mvnw test

update:
	./mvnw versions:update-parent versions:update-properties versions:display-plugin-updates

.DEFAULT_GOAL := build-run
build-run: update build run
