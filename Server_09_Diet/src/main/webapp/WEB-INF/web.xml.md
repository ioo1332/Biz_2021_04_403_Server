#web.xml  
* java EE (Enterprise edition) 프로젝트에서의 servlet, controller등을 관리하는   
서버설정 파일  
* @WebServlet()Annotation이 만들어지기 전에는 Servlet, controller 관련 정보를 web.xml파일에 설정했었다.    
* @WebServlet()Annotation을 사용하기 때문에 web.xml을 사용하지 않아도 프로젝트를 실행하는데 문제가 없다.  
* 다만 슬래시(/,root path)로 접근하는 경로를 catch하는 controller가 없을때는 아무런 문제가 없다  
* 지금 프로젝트 HomeController에서 슬래시(/,rootPath)를 직접 핸들링 하고 있기 때문에 모든파일  
(이미지,css,HTML)의 요청을 할수 없게 되어 버렸다  
* 이미지,css파일을 jsp에서 link하려면 controller가 직접 핸들링 하지 못하도록 만들줘야한다.  
* controller가 직접 핸들링 하지 않고 css등을 link하기 위해서 web.xml에 default mapping을 선언해주어야한다

## web.xml을 사용한 controller설정
<servlet>
	<servlet-name>home</servlet-home>
	<servlet-class>com.callor.diet.HomeController</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>home</servlet-home>
	<url-pattern>/*</url-pattern>
</servlet-mapping>

<servlet-mapping>
	<servlet-name>default</servlet-home>
	<url-pattern>*.png</url-pattern>
</servlet-mapping>

* 슬래시로 req가 오면 com.callor.diet.HomeController가 처리해라
