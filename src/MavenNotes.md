*********************Maven Building Tools. *****************************


-Maven is a build and dependency management tool for Java based application development.

	- Builds , Documentation, REporting , Depedencies, SCMs, Releases and Distribution.

- Create first time project from maven
  mvn -B archetype:generate \
  -DarchteypeGroupId = com.elliemae
  -DgroupId = com.elliemae.services
  -DartifactedId = my-app

  above execution ends up in POM.xml file.

  groupId – a unique base name of the company or group that created the project
  artifactId – a unique name of the project
  version – a version of the project
  packaging – a packaging method (e.g. WAR/JAR/ZIP)
  name This element indicates the display name used for the project

- Build:  It provides information about the default Maven goal, the directory for the compiled project, and the final name of the application

  	<build>
  		<defaultGoal>install</defaultGoal>
  		<directory>${basedir}/target</directory>
  		<finalName>${artifactId}-${version}</finalName>
  		<filters>
  		  <filter>filters/filter1.properties</filter>
  		</filters>
  		//...
  	</build>

- Plugins : Maven plugin is a collection of one or more goals. Goals are executed in phases, which helps to determine the order in which the goals are executed .For customizing the build for Maven. plugin will be automatically downloaded and used
  e.g. Here , its configured to use Java compiler to allow JDS 5.0 resoures.
  <build>
  <plugins>
  <plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.3</version>
  <configuration>
  <source>1.5</source>
  <target>1.5</target>
  </configuration>
  </plugin>
  </plugins>
  </build>

  	- Configuration : element applies the given parameters to every goad from the compler plugin. There can be a goal setup in configuration.
  	e.g. 
  	 <configuration>
         <tagNameFormat>@{project.version}</tagNameFormat>
         <preparationGoals>clean verify replacer:replace docker:build -DdockerRepo=greenbuild-repo -DpushImageTag scm:checkin -Dmessage="[maven-release-plugin] prepare release" promote:artifacts deploy:deploy</preparationGoals>
         <completionGoals>clean verify replacer:replace scm:checkin -Dmessage="[maven-release-plugin] prepare for next development iteration"</completionGoals>
       </configuration>

- Deploy jar in remote repository.
    - configure repository url in pom and authentication in settings.xml
    - e.g.

       <distributionManagement>
      	<repository>
      	  <id>mycompany-repository</id>
      	  <name>MyCompany Repository</name>
      	  <url>scp://repository.mycompany.com/repository/maven2</url>
      	</repository>
        </distributionManagement>

- resource elements : explicitly state that the resources are located in the src/main/resources directory and filtering to true because Sometimes a resource file will need to contain a value that can only be supplied at build time  To accomplish this in Maven, put a reference to the property that will contain the value into your resource file using the syntax ${<property name>}. The property can be one of the values defined in your pom.xml, a value defined in the user's settings.xml, a property defined in an external properties file, or a system property


- POM :
    - Project Object Model or POM is the fundamental unit of work in Maven.
    -  Examples for this is the build directory, which is target; the source directory, which is src/main/java; the test source directory, which is src/test/java
    -  Super POM is default POM all pom exended it.
    -
- Archetype:
    - Archetype is a Maven project templating toolkit. An archetype is defined as an original pattern or model from which all other things of the same kind are made
    -  create a new project based on an Archetype, you need to call mvn archetype:generate
  
	