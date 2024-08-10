
## Maven Build Tools

Maven is a powerful build and dependency management tool designed for Java-based application development. It facilitates a wide range of project management tasks, including building, documentation, reporting, dependency management, SCMs, releases, and distribution.

### Creating a Maven Project

To create a new Maven project, use the following command:

```bash
mvn -B archetype:generate \
  -DarchteypeGroupId=com.elliemae \
  -DgroupId=com.elliemae.services \
  -DartifactId=my-app
```

This command generates a `pom.xml` file, which is the core of a Maven project. Key elements include:

- **groupId**: A unique identifier for the organization or group that created the project.
- **artifactId**: A unique name for the project.
- **version**: The project’s version.
- **packaging**: The packaging method (e.g., WAR, JAR, ZIP).
- **name**: The display name for the project.

### Build Configuration

Maven allows you to define the default build behavior within the `pom.xml` file. For example:

```xml
<build>
    <defaultGoal>install</defaultGoal>
    <directory>${basedir}/target</directory>
    <finalName>${artifactId}-${version}</finalName>
    <filters>
        <filter>filters/filter1.properties</filter>
    </filters>
</build>
```

- **defaultGoal**: Specifies the default Maven goal (e.g., `install`).
- **directory**: The directory for compiled project artifacts.
- **finalName**: The final name of the application.

### Plugins

Maven plugins are collections of goals that can be executed in phases, determining the order of goal execution. For example, the Java compiler plugin can be configured as follows:

```xml
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
```

### Configuration

Configuration elements in Maven apply parameters to plugin goals. For example:

```xml
<configuration>
    <tagNameFormat>@{project.version}</tagNameFormat>
    <preparationGoals>clean verify replacer:replace docker:build -DdockerRepo=greenbuild-repo -DpushImageTag scm:checkin -Dmessage="[maven-release-plugin] prepare release" promote:artifacts deploy:deploy</preparationGoals>
    <completionGoals>clean verify replacer:replace scm:checkin -Dmessage="[maven-release-plugin] prepare for next development iteration"</completionGoals>
</configuration>
```

### Deploying JAR Files to a Remote Repository

To deploy a JAR file to a remote repository, configure the repository URL in `pom.xml` and authentication details in `settings.xml`:

```xml
<distributionManagement>
    <repository>
        <id>mycompany-repository</id>
        <name>MyCompany Repository</name>
        <url>scp://repository.mycompany.com/repository/maven2</url>
    </repository>
</distributionManagement>
```

### Resource Management

Specify resources in Maven using the `<resources>` element, allowing for dynamic values during the build process:

```xml
<resources>
    <resource>
        <directory>src/main/resources</directory>
        <filtering>true</filtering>
    </resource>
</resources>
```

### Project Object Model (POM)

The `pom.xml` file is the cornerstone of a Maven project, defining everything from the project's build settings to its dependencies. Key directories include:

- **Build directory**: `target`
- **Source directory**: `src/main/java`
- **Test source directory**: `src/test/java`

### Archetypes

Maven Archetypes are templates for creating new projects. To generate a project based on an Archetype, use:

```bash
mvn archetype:generate
```

This command initializes a new project structure based on predefined templates.

