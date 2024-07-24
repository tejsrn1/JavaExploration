*********************JAVA Webserver / Application Server (Tomcat) and Web Container *****************************



A. Some Points about WebServer/Web container. :

	- Websever is mainly to server static content and App server for serverside response but now a days both does almost same.

	- Webcontainer in Java, is Servlet contaier. It is a componet of a web server that intaracs with Java servelet. 
	- Webcontainer manages lifecycle of servlets,map url to particular servlet and user that url requester has correct access rights etc..
	- Java servelet api i.e. classes liek ServeletContext, ServeletRequest ,ServeletResponse, Session.
	- Basically its a runtime enviornment where servlet runs.

	-Java Servelets enabled you to write server side component which help in generating dyanamic content based on request. Again Java provides sevelet interfaces and implementer webserver company has to provide acutal implemenation.
		- ServletContext : 
			- when serverlet container starts it will deploy and load all web applicaiton. when web application loaded, servelet container will create ServeletContext once per application and keep in server memeory.
			- Also web.xml will be parsed and every servelet, filter and listener found in web.xml will be created and kept in memory.
			- ServletContext defines a set of methods that a servlet uses to communicate with its servlet container.
		
	- Servelet container attached to Webserver that listne on HTTP request on port 80 (Tomcat is on 8080). When new request comes servlet container will create new HttpServletRequest and HttpServletResponse object and pass it through the method of the already created Filter and Servelet instance based on URL matching request ALL IN SAME THREAD.
	
	- Servlets and filters are shared among all requests so that never assign any request or session scoped data as an instance variable of a servlet or filter otherwise it will be shared among all request.
	
	- 50K feet high : Webserver -> Webcontainer/Serveletcontainer -> Filter,Listener,Servelet Instance -> ServeletContext -> Servelet api class in perticualr application.
	
	- HttpSession:  When a client visits the web-app for the first time and/or the HttpSession is to be obtained for the first time by request.getSession(), then the servlet container will create it, generate a long and unique ID (which you can get by session.getId()) and store it in server’s memory. The servlet container will also set a Cookie in the HTTP response with JSESSIONID as cookie name and the unique session ID as cookie value.




B.Some Points about Tomcat:

		
	
	- Apache Tomcat is open source web server and servlet container devloped by Apache. 
	- Tomcat implements serveral Java EE interfaces like Servelet, JSP etc.
	- Tomcat consist of several components like Server,Service,Engine,Host,Context, connectors.
	- All this defiend in server.xml which is located in the /conf subdirectory of Tomcat installation folder.
	
	- HOST : 
		- Its a networkname www.gogle.com to Tomcat server.
		- Host can have any number of applications. 
		- There can be serveral host on same Tomcat sever.e.g. www.google.com. www.microsoft.com etc.
		- Host attribute "appBase" defines application dircotry within the Tomcat installation folder. Each applicatoin then identified by its path within that directory. 
			- e.g. App base directory for localhost is webapps (C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\ROOT\) for http://localhost:8080. 
			- For other app other than ROOT as in “C:\Program Files\Apache Software Foundation\Tomcat 6.0\webapps\myapp\“, the URL is like “http://localhost:8080/myapp/“.
			- Like IIS has intepub as default and other custom direcotry for any custom website.
			
	- Context : 
		- Its innermost element of component of server and it represent single web application. 
		- Tomcat automaticaly instantiates and configure a standard context upon loading application. 
		- It also load properties defiend in WEB-INF\web.xml file.
	
	- Connectors: 
		- It handles communication with client. 
		- There are various connectors available e.g. HTTPConnector for HTTP traffic and AJP connector to use AJP protocot etc. Connectors lisent port 8080.
	
	- Service: 
		- It ties connectors to engine. Tomcat has defautl serivce name Catalina which connects HTTP AND AJP CONNECTORS TO Catalina Engine.
	
	- Engine : 
		- Represents request processssing pipeline for a specific service.
		- Engine receives and processes all request from all these connectors and handling response back to appropriate connector for transmission to the client.
		
			- e.g. Jasper : JSP Engine for Tomcat , responsible for parsing JSP files and compilation of JSP’s Java code as servlets. Remeber like IIS once compile code its needs to be updated to get in effect by tomcat.
			- Catalina : Tomcat’s servlet container. Catalina makes Tomcat a Web Server for dynamic content
			- Coyote : makes Tomcat a HTTP web server.
	
	Server : Its an instance of Tomcat server. It has services that connects connector to engine.
	
	Listener : Its a java object implement org.apache.catalina.LifecycleListener interface.
	
	Relam : It can appera in any container e.g Engine,Host and Context and represent database of users, password, user role.Its purpose is to support container-based authentication.
	
	Valve :its a intercepotr and intercept all http request before they reach to applicaiton. 