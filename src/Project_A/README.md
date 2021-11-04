# Server

- Serversocket은 특정 포트 번호를 열어두고 대기
- 연결 요청이 오면 accept하고 내부에 별도의 Socket 생성
- BufferedReader와 BufferedWriter를 활용해 Stream을 연결하고 클라이언트의 대화가 도착할 때까지 무한 대기
- 메세지가 들어오면 String으로 받은 뒤, "종료"가 포함되어 있는지 확인
- 포함되어 있지 않다면 클라이언트 메세지를 print
- 이후 내가 메세지를 입력하고, Buffer를 이용하므로 **반드시 flush() 해주기**
- 다시 메세지가 도착할 때까지 무한 대기


- 이후, 종료가 도착하게 되면 finally 구문으로 가서 사용한 리소스 해제
- 중간에 예외 발생해도 catch하고 리소스는 해제

# Client

- Host ip와 port 번호를 가진 Socket 생성
- BufferedReader와 BufferedWriter를 활용해 Stream을 연결하고 클라이언트의 대화가 도착할 때까지 무한 대기
- 먼저 메시지 입력하고 이 메세지에 "종료"가 포함되어 있으면 **메세지를 보낸 후** 연결 종료
- 포함되어 있지 않다면 전송 후 상대방의 메세지가 올 때까지 무한 대기


- 이후, 종료가 도착하게 되면 finally 구문으로 가서 사용한 리소스 해제
- 중간에 예외 발생해도 catch하고 리소스는 해제


# 고찰

- 무한 대기가 필요하다
  - GUI를 활용하면 이 문제를 해결 가능하다
  - 추후 만들어 볼 예정
- 쓰레드를 활용하지 않아서 특정 사람과의 1대1 통신만 가능하다
  - 추후 멀티쓰레드를 활용한 프로그램 만들어 볼 예정
- 영어를 사용할 경우
  - `inMsg.contains("종료")` 대신 `inMsg.equalsIgnoreCase("bye")` 사용
- 추가적으로 utf-8 인코딩을 해줄 수도 있을 것으로 보임


[더 자세히 알아보기](https://velog.io/@hahahaa8642/%EC%B1%84%ED%8C%85-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8-Socket-%ED%99%9C%EC%9A%A9%ED%95%9C-%EA%B0%84%EB%8B%A8%ED%95%9C-%EC%BD%98%EC%86%94-%EC%B1%84%ED%8C%85-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8)
