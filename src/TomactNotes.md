# Java Webserver / Application Server (Tomcat) and Web Container

## A. WebServer/Web Container Overview

- A **Webserver** primarily serves static content, while an **Application Server** provides server-side responses. However, both now perform similar functions.
- A **Webcontainer** in Java is a Servlet container. It is a component of a web server that interacts with Java servlets.
- The Webcontainer manages the lifecycle of servlets, maps URLs to particular servlets, and ensures that the URL requester has the correct access rights.
- The Java servlet API includes classes like ServletContext, ServletRequest, ServletResponse, and Session.
- Essentially, it's a runtime environment where servlets run.

Java Servlets enable you to write server-side components which help in generating dynamic content based on requests. Java provides servlet interfaces and the webserver company has to provide the actual implementation.

### ServletContext

- When the servlet container starts, it deploys and loads all web applications. When a web application is loaded, the servlet container will create a ServletContext once per application and keep it in server memory.
- Also, web.xml will be parsed and every servlet, filter, and listener found in web.xml will be created and kept in memory.
- ServletContext defines a set of methods that a servlet uses to communicate with its servlet container.

The Servlet container is attached to the Webserver that listens to HTTP requests on port 80 (Tomcat is on 8080). When a new request comes, the servlet container will create a new HttpServletRequest and HttpServletResponse object and pass it through the method of the already created Filter and Servlet instance based on URL matching request ALL IN THE SAME THREAD.

Servlets and filters are shared among all requests so never assign any request or session scoped data as an instance variable of a servlet or filter otherwise it will be shared among all requests.

From a high-level perspective: Webserver -> Webcontainer/Servletcontainer -> Filter, Listener, Servlet Instance -> ServletContext -> Servlet API class in a particular application.

### HttpSession

When a client visits the web-app for the first time and/or the HttpSession is to be obtained for the first time by request.getSession(), then the servlet container will create it, generate a long and unique ID (which you can get by session.getId()) and store it in the server’s memory. The servlet container will also set a Cookie in the HTTP response with JSESSIONID as the cookie name and the unique session ID as the cookie value.

## B. Tomcat Overview

Apache Tomcat is an open-source web server and servlet container developed by Apache. Tomcat implements several Java EE interfaces like Servlet, JSP, etc. Tomcat consists of several components like Server, Service, Engine, Host, Context, and connectors. All these are defined in server.xml which is located in the /conf subdirectory of the Tomcat installation folder.

### HOST

- It's a network name www.google.com to the Tomcat server.
- A Host can have any number of applications.
- There can be several hosts on the same Tomcat server e.g., www.google.com, www.microsoft.com, etc.
- The Host attribute "appBase" defines the application directory within the Tomcat installation folder. Each application is then identified by its path within that directory.
    - For example, the App base directory for localhost is webapps (C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\ROOT\) for http://localhost:8080.
    - For other apps other than ROOT as in “C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\myapp\“, the URL is like “http://localhost:8080/myapp/“.
    - Like IIS has inetpub as default and other custom directories for any custom website.

### Context

- It's the innermost element of the component of the server and it represents a single web application.
- Tomcat automatically instantiates and configures a standard context upon loading an application.
- It also loads properties defined in WEB-INF\web.xml file.

### Connectors

- It handles communication with the client.
- There are various connectors available e.g., HTTPConnector for HTTP traffic and AJP connector to use the AJP protocol, etc. Connectors listen on port 8080.

### Service

- It ties connectors to the engine. Tomcat has a default service name Catalina which connects HTTP AND AJP CONNECTORS TO the Catalina Engine.

### Engine

- Represents the request processing pipeline for a specific service.
- The Engine receives and processes all requests from all these connectors and handles the response back to the appropriate connector for transmission to the client.
    - For example, Jasper: JSP Engine for Tomcat, responsible for parsing JSP files and compilation of JSP’s Java code as servlets. Remember like IIS once compile code it needs to be updated to get in effect by tomcat.
    - Catalina: Tomcat’s servlet container. Catalina makes Tomcat a Web Server for dynamic content.
    - Coyote: makes Tomcat an HTTP web server.

### Server

- It's an instance of the Tomcat server. It has services that connect the connector to the engine.

### Listener

- It's a Java object that implements the org.apache.catalina.LifecycleListener interface.

### Realm

- It can appear in any container e.g., Engine, Host, and Context and represent a database of users, passwords, user roles. Its purpose is to support container-based authentication.

### Valve

- It's an interceptor and intercepts all HTTP requests before they reach the application.
