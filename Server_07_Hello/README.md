#Servlet 의 응답처리

##Requset와 Response
*Request는 web browser에서 서버에서 요청을 하는 행위
*reponse는 서버가 web browser에게 응답을 하는 행위

##Request의 forword(),Response의 sendRedirect()
*forword()는 서버에 있는 jsp파일을 읽어서 rendering을 수행한후
web browser에게 전달하는것
*sendRedirect는 서버가 다시 web browser 에게 다른 요청주소를 보내고
##forword() sendRedirect()
*forword()는 client의 요청을 끝까지 책임지고 수행하여 결과를 알려주는것 까지 책임을 지는
코드 수행
*forword()는 데이터를 처리하고 화면 rendering까지 수행
*sendRedirect()는 client의 요청을 서버의 다른 요청주로 책임을 떠 넘기는 방식
*마치 web browser에 주소를 타이핑하여 입력하는 방식으로 