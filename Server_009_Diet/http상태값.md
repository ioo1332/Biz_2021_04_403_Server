# Http Status  

### web browser가 요청을 하면

### server는 요청이 적절한가 판단하고 응답 준비를 한다

*요청이 무엇인지 알지 못할때 : 404 코드를 전송  
Not found

*요청이 정상적인데 서버에서 어떤 연산처리를 하는중에 오류가 발생하면 : 500코드(짧막한 메시포함)를 전송  
서버 내부 오류

*요청이 정상적인데 내가 직접 처리할대상이 아니다 다른 요청으로 redirection 하겠다 : 302코드

*요청이 정상적이고 보내줄 데이터를 준비하고있을때 : 200코드 전송  
기다려라 보내줄테니

*요청이 정상적이고 보내줄 데이터가 있는데 방금전에 보낸 데이터와 변함이 없다 그냥 그거써라 : 304코드 전송  
기다려라 보내줄테니

*요청이 무엇이닞 알지 못할때 : 404코드 전송

*요청이 주소는 맞는데 method는 틀릴때  
anchor를 클릭해서 요청을 했는데 클래스에 doGet()가 없을때
form의 post로 요청이 들어왔는데 doPost가 없을때 이때는 405오류를 보낸다.

*권한이 없을때 : 401,403 오류를 전송


*요청이 정상적인데 내가 직접 처리할대상이 아니다 다른 요청으로 redirection 하겠다 : 302코드

