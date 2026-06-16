# 사전학습

## 참고

> [아마찌의 ORM vs SQL Mapper vs JDBC](https://youtu.be/VTqqZSuSdOk)

JDBC 문제점 - 이를 해결하기 위한 SQL Mapper - SQL 에 대한 의존에서 벗어나기 위한 ORM

`Persistence`  
영속성. 데이터를 생성한 프로그램이 종료되더라도 사라지지 않는 데이터의 특성.  
레이어드 아키텍처에서 영속성 계층이 도메인 모델인 객체에 영속성을 부여.

`Layerd Architecture`  
User Interface - Presentation - Application - Domain Model - Persistence - Data

영속성 계층을 어떻게 구현하는지에 따라 분류할 수 있다

- ### JDBC

DriverManager - Connection - Statement - ResultSet  
간단 SQL 실행에 중복 코드 반복 사용  
DB에 따라 일관성 없는 정보를 가진 채로 Checked Exception 처리  
Connection과 같은 공유 자원을 제대로 릴리즈하지 않으면 자원 고갈

> JDBC 만을 사용했을 경우 위와 같은 문제점이 존재, 문제와 불편을 처리하기 위해 프레임워크 적용  
> Persistence Framework 는 내부적으로 JDBC API 사용

- ### SQL Mapper 