# 사전학습

<details><summary>미션 내용</summary>

<div class="wmde-markdown wmde-markdown-color " style="background-color: transparent;"><h1 id="user-content-사전학습"><a tabindex="-1" href="#사전학습"></a>사전학습</h1>
<p>미션을 시작하기 전, <strong>혼자 읽고 정리하는 단계</strong>입니다. 머릿속에 "JPA가 푸는 문제"의 윤곽을 만드는 것이 목적입니다. 깊이는 미션 진행 중에 만들어집니다.</p>
<h2 id="user-content-미리-보고-오기"><a tabindex="-1" href="#미리-보고-오기"></a>미리 보고 오기</h2>
<ul>
<li><a href="https://youtu.be/mezbxKGu68Y">[코즈의 ORM vs SQL Mapper vs JDBC](https://youtu.be/mezbxKGu68Y)</a></li>
<li><a href="https://youtu.be/VTqqZSuSdOk">[아마찌의 ORM vs SQL Mapper vs JDBC](https://youtu.be/VTqqZSuSdOk)</a></li>
</ul>
<h2 id="user-content-이번-사이클에서-답할-질문"><a tabindex="-1" href="#이번-사이클에서-답할-질문"></a>이번 사이클에서 답할 질문</h2>
<p>영상을 본 후 다음 4가지 질문에 본인이 답해봅니다. 정답을 찾는 것이 아니라, 미션을 시작할 때 "이게 답이었어?"를 비교할 기준점을 만드는 것입니다.</p>
<ul>
<li>JPA는 JdbcTemplate에 비해 <strong>무엇을 자동화</strong>하고, 그 대가로 <strong>무엇을 감추는가</strong>?</li>
<li>영속성 컨텍스트가 켜져 있다는 것을 코드의 어느 시점에 의식해야 하는가?</li>
<li>미션1에서 SQL로 풀었던 join을, 객체 그래프로 옮기면 어디에 부담이 옮겨가는가?</li>
<li>어노테이션 한 줄이 만드는 <strong>실제 SQL</strong>을 추적할 수 있는가?</li>
</ul>
<h2 id="user-content-사전-학습-키워드"><a tabindex="-1" href="#사전-학습-키워드"></a>사전 학습 키워드</h2>
<p>키워드를 검색해 1줄 정의를 만들고, "이게 미션1 어디에 해당하는가?"를 메모합니다.</p>

<table><thead><tr><th>목적</th><th>키워드</th></tr></thead><tbody><tr><td>패러다임 차이</td><td>ORM, 객체-관계 임피던스 불일치, 영속성</td></tr><tr><td>핵심 개념</td><td>영속성 컨텍스트, 1차 캐시, dirty checking, 쓰기 지연, flush</td></tr><tr><td>매핑</td><td><code>@Entity</code>, <code>@Id</code>, <code>@GeneratedValue</code>, <code>@Column</code>, <code>@Table</code></td></tr><tr><td>연관관계</td><td><code>@ManyToOne</code>, <code>@OneToMany</code>, 단/양방향, 연관관계 주인, cascade, orphanRemoval</td></tr><tr><td>페치</td><td>EAGER, LAZY, fetch join, <code>@EntityGraph</code></td></tr><tr><td>쿼리</td><td>JPQL, Native Query</td></tr></tbody></table>
<blockquote>
<p><strong>키워드 사용법</strong>: 키워드 검색 → 1줄 정의 → "이게 미션1 어디에 해당하는가?"를 메모. 깊이는 미션 중에 만들어집니다.</p>
</blockquote>
<h2 id="user-content-학습-테스트-참조-매뉴얼"><a tabindex="-1" href="#학습-테스트-참조-매뉴얼"></a>학습 테스트 (참조 매뉴얼)</h2>
<p><a href="https://github.com/cho-log/spring-learning-test">스프링 학습 테스트 저장소</a>의 두 모듈이 본 미션과 직접 맞물립니다.</p>
<ul>
<li><code>spring-data-jpa-1</code> — Entity·Repository·기본 CRUD → 1단계 매핑</li>
<li><code>spring-data-jpa-2</code> — 연관관계·JPQL → 1단계 연관관계 + 3단계 JPQL</li>
</ul>
<p>미션 진행 중 막히는 지점에서 <strong>참조 매뉴얼처럼</strong> 활용합니다. 처음부터 끝까지 따라할 필요 없습니다.</p>
<h2 id="user-content-미션1-repository-코드-다시-읽기"><a tabindex="-1" href="#미션1-repository-코드-다시-읽기"></a>미션1 Repository 코드 다시 읽기</h2>
<p>본격 시작 전에 <strong>본인의 미션1 4단계 코드</strong>를 한 번 다시 읽고 다음 메모를 남깁니다.</p>
<ul>
<li><code>JdbcTemplate</code>이 직접 다루는 SQL은 몇 종류인가? (insert/select/update/delete/join)</li>
<li>도메인 객체와 테이블의 관계가 1 : 1인가?</li>
<li>연관 데이터를 가져올 때 join을 SQL에 박아두었나, 두 번 조회했나?</li>
<li>만약 이걸 객체 그래프(<code>reservation.getTime().getStartAt()</code>)로 표현한다면 어느 코드가 사라질까?</li>
</ul>
<blockquote>
<p>이 메모가 <strong>0단계·1단계의 시작점</strong>이 됩니다. 학습 로그 첫 줄로 남기면 좋습니다.</p>
</blockquote></div>

</details>

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

SQL 직접 작성, SQL문의 결과와 객체의 필드를 매핑하여 테이터를 객체화, RowMapper 재활용

`Mybatis`

- 쿼리를 XML 파일로 정의
- 사용자는 인터페이스랑 XML만
- 실제 연결과 구현체는 Mybatis가

자동 Connection 관리, 중복 작업 대부분 제거  
동적 쿼리 작성 용이, 매핑도 XMl에서 같이 정의 가능

> DAO 로부터 SQL 문을 분리하여 코드의 간결성 및 유지보수성 향상

## 한계

SQL을 직접 작성하는 이상, 특정 DB에 종속적으로 사용할 가능성 농후  
테이블마다 유사항 CRUD SQL 작성 필요 == DAO 반복에서 벗어나지 못함  
테이블 필드 변경 시 관련된 모든 DAO SQL, 객체 필드 수정 필요  
SQL을 직접 작성하고 사용하는 이상 객체간의 관계보다 DB 처리에 집중

> 코드상으로 SQL과 JDBC API를 분리했다 해도 논리적으로 강한 의존성이 남아 있음

## `패러다임 불일치 문제`

객체지향 - 추상화, 상속, 다형성..  
RDB - 데이터 중심의 구조.

각각이 지향하는 목적이 다르기 때문에 사용 방법과 표현방식에 차이가 존재.  
객체지향 구조를 DB에 그대로 표현하기엔 한계가 있다. 객체지향적 설계일수록 테이블로 저장하긴 힘들다.

- ### ORM(Object-Relational Mapping, 객체 관계 매핑)

객체와 관계형 DB를 매핑, 쿼리가 아닌 직관적인 코드(메서드)로 데이터 조작  
`JPA - 자바 ORM 기술에 대한 API 표준 명세.` 인터페이스의 집합?  
을 구현한 프레임워크는 Hibernate, EclipseLink, ...

`패러다임 불일치 문제 해결`

- 상속관계의 구현방식 차이를 해결 (상속/슈퍼타입)
- 연관관계의 표현방식 차이를 해결 (객체 기반/식별자 기반)
- 반환된 엔티티 참조 관계 신뢰 가능 (객체 그래프 탐색)
- 식별자 기반으로 동일성 비교 보장

`장점`

- 패러다임 불일치 문제 해결 : 객체지향 언어가 가진 장점을 살리면서 구현
- 생산성 : 반복적인 CURD SQL 작성 소요 제거
- 데이터 접근 추상화, 벤더 독립성 : 벤더간의 차이를 추상화를 통해 해결
- 유지보수 : 필드 추가/삭제 영향을 쿼리 수정이 아닌 엔티티 수정으로 처리

---

### 사전 질문

- JPA는 JdbcTemplate에 비해 무엇을 자동화하고, 그 대가로 무엇을 감추는가?
    - 쿼리 작성과 매핑 자동화, 쿼리 구현 방식 은닉?
- 영속성 컨텍스트가 켜져 있다는 것을 코드의 어느 시점에 의식해야 하는가?
    - 글쎄 조회를 시작하는 시점?
- 미션1에서 SQL로 풀었던 join을, 객체 그래프로 옮기면 어디에 부담이 옮겨가는가?
    - 객체들의 의존을 설정하고 호출하는 메모리?
- 어노테이션 한 줄이 만드는 실제 SQL을 추적할 수 있는가?
    - 아직은 불가

---

### 키워드

<table><thead><tr><th>목적</th><th>키워드</th></tr></thead><tbody><tr><td>패러다임 차이</td><td>ORM, 객체-관계 임피던스 불일치, 영속성</td></tr><tr><td>핵심 개념</td><td>영속성 컨텍스트, 1차 캐시, dirty checking, 쓰기 지연, flush</td></tr><tr><td>매핑</td><td><code>@Entity</code>, <code>@Id</code>, <code>@GeneratedValue</code>, <code>@Column</code>, <code>@Table</code></td></tr><tr><td>연관관계</td><td><code>@ManyToOne</code>, <code>@OneToMany</code>, 단/양방향, 연관관계 주인, cascade, orphanRemoval</td></tr><tr><td>페치</td><td>EAGER, LAZY, fetch join, <code>@EntityGraph</code></td></tr><tr><td>쿼리</td><td>JPQL, Native Query</td></tr></tbody></table>

`패러다임 차이`  
객체지향적 자바 코드 / 데이터와 관계 지향적 RDB의 패러다임 차이가 존재.  
객체의 영속화 도중 이 차이가 객체-관계 `임피던스` 불일치로 나타나고 이를 ORM으로 해결.

---

