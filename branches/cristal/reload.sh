#!/bin/sh
export JAVA_HOME=/home/cristal/jdk1.5.0_21
svn up monitors
~/apache-tomcat-6.0.20/bin/catalina.sh stop
apache-maven-3.0.1/bin/mvn -f monitors/pom.xml -Dmaven.test.skip compile war:inplace
~/apache-tomcat-6.0.20/bin/catalina.sh start
