
# Java Webserver / Application Server (Tomcat) and Web Container

## A. WebServer/Web Container Overview

- **Webserver**: Primarily serves static content; **Application Server** handles server-side processing. Both now perform similar functions.
- **Webcontainer**: A Java Servlet container within a web server, managing the lifecycle of servlets, URL mappings, and access rights. It serves as the runtime environment for Java servlets, enabling dynamic content generation.

### ServletContext

- Created once per application by the servlet container when a web application is loaded. It stays in server memory and facilitates communication between the servlet and the container.
- ServletContext manages servlets, filters, and listeners defined in `web.xml`.

### HttpSession

- Created when a client first visits a web app, with a unique session ID stored as a cookie (`JSESSIONID`). It persists session data server-side.

## B. Tomcat Overview

**Apache Tomcat**: An open-source web server and servlet container that implements Java EE interfaces (Servlet, JSP, etc.). Key components include:

### Host

- Represents a network name (e.g., `www.google.com`) on the Tomcat server.
- Multiple hosts can run on the same Tomcat server.
- The `appBase` attribute defines the application directory within Tomcat, with each application identified by its path.

### Context

- Represents a single web application within Tomcat, automatically instantiated and configured upon application load. It uses properties from the `WEB-INF/web.xml` file.

### Connectors

- Handle communication with clients. Common connectors include `HTTPConnector` for HTTP traffic and `AJPConnector` for the AJP protocol. They typically listen on port 8080.

### Service

- Ties connectors to the engine. The default service in Tomcat is "Catalina," connecting HTTP and AJP connectors to the Catalina engine.

### Engine

- Manages the request processing pipeline for a specific service, handling requests from connectors and returning responses. Examples include:
  - **Jasper**: JSP engine, compiles JSP to servlets.
  - **Catalina**: Tomcat’s servlet container for dynamic content.
  - **Coyote**: Tomcat’s HTTP web server component.

### Server

- Represents the Tomcat server instance, containing services that connect connectors to the engine.

### Listener

- Implements the `org.apache.catalina.LifecycleListener` interface to monitor server lifecycle events.

### Realm

- Manages user authentication and roles, supporting container-based authentication across components like Engine, Host, and Context.

### Valve

- An interceptor that processes HTTP requests before they reach the application, often used for logging or access control.
