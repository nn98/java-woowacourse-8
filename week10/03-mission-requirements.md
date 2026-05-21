# 📖 미션

<details><summary><h2>미션</h2></summary>

<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">🚀 사이클1 - 미션 (테마 + 사용자 예약)</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>사이클1: 미션 (테마 + 사용자 예약)</h1>
<blockquote>
<p><strong>규칙을 적용하면서 사용자가 직접 예약하는 기능을 만든다.</strong></p>
</blockquote>
<hr>
<h2>실습 환경 구축</h2>
<p><a href="https://github.com/woowacourse/spring-roomescape-member">방탈출 사용자 예약</a> 저장소를 기반으로 미션을 진행한다. <a href="https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/review-step1.md">온라인 코드 리뷰 요청 1단계</a> 문서를 참고해 실습 환경을 구축한다.</p>
<ol>
<li>미션 시작 버튼을 눌러 미션을 시작한다.</li>
<li>저장소에 자신의 GitHub 아이디로 된 브랜치가 생성되었는지 확인한다.</li>
<li>저장소를 자신의 계정으로 Fork 한다.</li>
</ol>
<h3>이전 미션 코드 가져오기</h3>
<p>이번 사이클은 지난 주 진행한 방탈출 예약 관리 미션 코드 위에 사용자 예약 기능을 쌓는다. 페어와 상의해 <strong>누구의 방탈출 예약 관리 미션 코드를 시작점으로 쓸지</strong> 결정하고, 마이그레이션한 코드를 <strong>하나의 커밋으로 합친다</strong>. PR을 보낼 때는 리뷰어가 마이그레이션 커밋을 제외한 사이클1 작업만 볼 수 있도록 PR 본문에 리뷰 범위를 명시한다.</p>
<h4>누구의 코드를 사용할지 고민된다면</h4>
<ul>
<li><strong>본인 코드를 유지한다면?</strong> 기존 코드를 계속 발전시키는 경험을 할 수 있다.</li>
<li><strong>페어의 코드에서 시작한다면?</strong> 타인의 코드 기반에서 요구사항을 구현하는 경험을 할 수 있다.</li>
<li>어떤 방식을 선택하든 성장하는 경험이 된다.</li>
<li><strong>단, 페어와 처음부터 다시 구현하지 않는다.</strong> 이번 사이클의 학습 목표에 집중하지 못하게 되는 지름길이다.</li>
</ul>
<hr>
<h2>진행 방식</h2>
<ul>
<li>미션은 <strong>과제 진행 요구 사항</strong>, <strong>기능 요구 사항</strong>, <strong>프로그래밍 요구 사항</strong> 세 가지로 구성되어 있다.</li>
<li>세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋하는 방식으로 진행한다.</li>
<li><strong>기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.</strong> 이번 사이클은 사용자 예약 API의 명세를 주지 않는다. URL 경로, HTTP 메서드, 요청·응답 형태, 상태 코드를 페어가 직접 결정한다.</li>
</ul>
<hr>
<h2>목표</h2>
<p>단순히 동작하는 API를 만드는 것이 아니라, <strong>"왜 이렇게 설계했는가"의 판단 근거를 가지는 것</strong>이 핵심이다.</p>
<ul>
<li>이번 토론 활동에서 정한 <strong>API 설계 규칙을 코드에 적용</strong>한다.</li>
<li>API 설계 결정마다 <strong>"나는 왜 이렇게 설계했는가"</strong> 를 PR 본문에 한두 줄로 남긴다.</li>
<li>방탈출 예약 관리 미션과 비교했을 때, 새로 추가되는 사용자 API와 기존 관리자 API의 관계를 의식한다.</li>
</ul>
<hr>
<h2>기능 요구 사항</h2>
<p>지난 미션까지는 관리자가 전화·현장 예약을 받아 시스템에 직접 등록했다. 이번 사이클부터는 <strong>사용자가 브라우저에서 직접 예약</strong>하는 서비스로 발전시킨다. 별도의 로그인은 없으며, 사용자는 이름으로 식별된다.</p>
<p>이번 사이클의 작업은 <strong>백엔드 API 추가</strong>와 <strong>사용자가 보는 화면을 만드는 것</strong> 두 가지를 함께 진행한다. API에 맞춰 페어가 함께 사용자가 사용하는 클라이언트 화면을 직접 만들고, 각 단계의 화면이 브라우저에서 정상 동작하는 것까지 확인한다. 화면 작성에는 AI를 활용해도 좋다.</p>
<blockquote>
<p>잘못된 입력에 대한 에러 처리는 사이클2의 주제다. 이번 사이클에서는 정상 흐름을 만드는 데 집중한다.</p>
</blockquote>
<h3>1단계 - 테마 도메인 추가</h3>
<ul>
<li>방탈출 게임에 '테마' 정보를 추가한다.
<ul>
<li>테마는 이름, 설명, 썸네일 이미지 URL을 가진다.</li>
<li>모든 테마의 시작 시간과 소요 시간은 동일하다고 가정한다.</li>
</ul>
</li>
<li>예약에 테마 정보를 포함하도록 기존 코드를 변경한다.</li>
<li>관리자가 테마를 추가·삭제할 수 있다.</li>
</ul>
<h3>2단계 - 사용자 예약</h3>
<ul>
<li>사용자가 <strong>날짜와 테마를 선택</strong>하면 예약 가능한 시간 목록이 표시된다.
<ul>
<li>예약 가능한 시간이란, 관리자가 등록한 시간 중 해당 날짜+테마에 아직 예약이 없는 시간이다.</li>
</ul>
</li>
<li>사용자가 예약 가능한 시간을 선택하여 본인의 이름으로 예약한다.</li>
<li>같은 날짜·시간이라도 테마가 다르면 각각 예약 가능하다.</li>
</ul>
<h3>3단계 - 인기 테마 조회</h3>
<ul>
<li>최근 1주 동안 예약이 많았던 테마 상위 10개를 조회한다.</li>
<li>예: 오늘이 5월 8일이면, 게임 날짜가 5월 1일~5월 7일인 예약을 집계해 인기 순서대로 10개를 응답한다.</li>
</ul>
<hr>
<h2>프로그래밍 요구 사항</h2>
<ul>
<li>자바 코드 컨벤션을 지키면서 프로그래밍한다.
<ul>
<li>기본적으로 <a href="https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java">Java Style Guide</a>을 원칙으로 한다.</li>
</ul>
</li>
<li>레벨1에서 만든 규칙 중 좋은 코드 작성을 위해 의미있는 규칙을 정리하고 적용한다.</li>
</ul>
<h3>추가된 요구 사항</h3>
<ul>
<li>이번 사이클에서 구현한 API에 대한 요구사항 테스트를 작성한다.
<ul>
<li>정상 흐름(예약 가능 시간 조회 → 예약 생성 → 다시 조회 시 빠짐)이 검증되도록 한다.</li>
</ul>
</li>
<li><code data-backticks="1">data.sql</code>로 테스트용 초기 예약 데이터를 충분히 넣어 인기 테마 조회 결과를 검증할 수 있게 한다.</li>
</ul>
<hr>
<h2>과제 진행 요구 사항</h2>
<ul>
<li>구현을 시작하기 전에 <strong>기능 요구 사항을 분석하여 기능 목록을 정리</strong>한다.</li>
<li>README.md 파일에 구현할 기능 목록과 <strong>페어가 결정한 자기 API 명세</strong>를 정리해 추가한다.</li>
<li>Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
<ul>
<li><a href="https://gist.github.com/stephenparish/9941e89d80e2bc58a153">AngularJS Git Commit Message Conventions</a> 참고해 커밋 메시지를 작성한다.</li>
</ul>
</li>
<li>PR 본문에 <strong>주요 API 설계 결정과 그 이유</strong>를 한두 줄씩 남긴다.</li>
</ul>
<hr>
<h2>미션 중 할 일</h2>
<ol>
<li>토론 활동에서 정한 API 설계 규칙을 의식하며 코드 작성</li>
<li>규칙 때문에 설계나 코드를 변경한 곳 기록</li>
<li>막히는 순간 기록</li>
</ol>
<hr>
<h2>미션 중 기록</h2>
<p><strong>필수 기록</strong>:</p>
<ul>
<li class="task-list-item" data-te-task="">규칙을 적용해서 변경한 코드 1곳 이상</li>
<li class="task-list-item" data-te-task="">테스트 작성이 어려웠던 코드 1곳 이상</li>
<li class="task-list-item" data-te-task="">막힌 순간 1회 이상</li>
</ul>
<hr>
<h2>미션 완료 조건</h2>
<ul>
<li class="task-list-item" data-te-task="">요구사항 구현</li>
<li class="task-list-item" data-te-task="">규칙에 의한 코드 변경 1회 이상</li>
<li class="task-list-item" data-te-task="">미션 중 기록 작성</li>
</ul>
<h2>산출물</h2>
<ul>
<li class="task-list-item" data-te-task="">미션 코드 (PR)</li>
<li class="task-list-item" data-te-task="">미션 중 기록</li>
</ul>
</div></div></div></div>

</details>

## 🚀 미션

---

# `3. 미션`

# 🚀 사이클1 - 미션 ()

> **규칙을 적용하면서 를 구현한다.**

## 📜 **구현 원칙**

**빠르게 구현하고, 빠르게 PR을 보내라.**

완벽한 코드가 아니라 **피드백을 받을 수 있는 코드**가 목표다.

- 동작하는 코드가 되면 바로 PR을 보낸다
- 부족한 부분은 숨기지 말고, 인식하고 공유한다
- PR이 빠를수록 리뷰에서 더 많이 배운다

---

## 🛠️ 기능 요구 사항

# 🛠️ 기능 목록

## 1단계 - 서비스 정책 적용

> 다음 정책을 만족하지 않는 요청은 거부한다.

- [x] 지나간 날짜·시간에 대한 예약 생성은 불가능하다. `ReservationServiceTest`
- [x] 같은 날짜+시간+테마에 이미 예약이 있으면 중복 예약을 거부한다. `ReservationServiceTest`
- [x] 예약이 존재하는 시간을 삭제할 수 없다. `JdbcTimeSlotRepositoryTest`
- [x] 유효하지 않은 입력값(빈 이름, 잘못된 날짜 형식 등)을 거부한다. `ReservationControllerTest`

---

## 2단계 - 에러 응답 설계

- [x] 서비스 정책 위반, 유효하지 않은 입력, 존재하지 않는 리소스 등에 대해 의도된 에러 응답을 반환한다.
    - `IllegalArgumentException`
        - 지나간 날짜/시간
        - 유효하지 않은 입력값
    - `NoSuchElementException`
        - 존재하지 않는 리소스
    - `DuplicateKeyException`
        - 중복 예약
    - `DataIntegrityViolationException`
        - 예약이 존재하는 시간
- [o] 500(서버 에러)이 사용자에게 노출되지 않도록 한다.
- [x] 에러 응답 본문에 어떤 정보를 담을지 결정한다.
    - 에러 발생의 원인과 해결 방안 유추/유도
- [x] 브라우저에서 에러 발생 시 사용자에게 의미 있는 메시지가 표시되어야 한다.

---

## 3단계 - 내 예약 조회/변경/취소

- [x] 사용자가 자신의 이름으로 본인의 예약 목록을 조회할 수 있다.
- [x] 사용자가 본인의 예약을 취소할 수 있다.
- [x] 사용자가 본인의 예약의 날짜·시간을 변경할 수 있다.
- [x] 변경·취소 시 발생하는 에러 케이스(이미 지난 예약을 취소, 변경하려는 시간이 이미 차 있음 등)도 2단계의 규칙에 맞춰 처리한다.

---

- [x] 거부되어야 하는 요청
    - [x] 존재하지 않는 예약에 대한 수정/삭제 `NoSuchElementException`
    - [x] 다른 사용자의 예약에 대한 수정/삭제 `AccessDeniedException `
    - [x] 이미 지난 예약에 대한 수정/삭제 `DuplicateKeyException`
    - [x] 이미 존재하는 예약(동일한 날짜, 테마, 시간)으로의 수정 `DuplicateKeyException`
    - [x] 이미 지난 시간으로의 수정 `IllegalArgumentException`
- [x] 잘못된 요청
    - [x] 존재하지 않는 예약 조회 `NoSuchElementException` / 404
    - [x] 필수 값이 빠진 예약 생성 `IllegalArgumentException`
    - [x] 같은 시간·테마에 중복 예약 시도 `DuplicateKeyException`
    - [x] 잘못된 값 `IllegalArgumentException`
        - [x] 필요한 값 존재하지 않음
        - [x] 값이 형식과 일치하지 않음
        - [x] 값이 정해진 범위를 초과함(이미 지난 날짜로 예약 시도)
- [ ]

---

## 미션 중 할 일

1.

---

# 🧾 미션 중 기록

## 필수 기록

### 규칙을 적용해서 변경한 코드 1곳 이상

예외에 에러 메시지와 상태 코드, 발생 위치를 담아  
클라이언트에게 보내되, 사용자에겐 에러 메시지만을 전달할 것이라 가정하고  
에러 메시지가 문제의 원인과 대응을 잘 드러낼 수 있도록 작성

```java

@RestControllerAdvice
public class ProblemDetailsAdvice {

```

대응은 해당 요청-응답 사이클 내부에서 확인된 정보만을 담는다.  
대응을 위해 추가적인 서버 로직이 동작하지 않도록 한다.

### 변경/취소에서 발견한 엣지 케이스와 처리 방향

`지난 예약` 에 따른 다양한 엣지 케이스

- 이미 지난 예약에 대한 변경/취소
- 이미 지난 날짜로의 예약 변경

`중복 예약` 에 따른 엣지 케이스

- 이미 해당 날짜/시간대/테마로의 변경
- 해당 날짜/시간대/테마 에서 예약자 이름 변경

#### `처리 방향`

요구사항과 원칙을 생각하고 적용하면 알아서 처리됨

### 지금까지의 규칙 중 유지/수정/폐기한 항목

- 대부분의 규칙 유지.
- 리소스 식별의 관점 구체화
- 관리자/사용자 API 분리하되 사용자의 접근 가능성이 없으면 분리하지 않음
- 에러 메시지의 대상과 내용을 통합된 규칙으로 관리

### 특이점

```java

@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
public ResponseEntity<ProblemDetail> handleMethodNotSupportedException(
        HttpRequestMethodNotSupportedException exception) {
    String detailMessage = "해당 경로에서는 " + exception.getMethod() + " 요청을 지원하지 않습니다. API 명세를 확인해 주세요.";

    ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.METHOD_NOT_ALLOWED, detailMessage);
    problemDetail.setProperty("code", "METHOD_NOT_ALLOWED");

    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(problemDetail);
}
```

지원하지 않는 엔드포인트 + 메서드 응답을 처리하는 과정에서

```text
2026-05-15T15:54:52.974+09:00 ERROR 11136 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'handlerExceptionResolver' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Failed to instantiate [org.springframework.web.servlet.HandlerExceptionResolver]: Factory method 'handlerExceptionResolver' threw exception with message: Ambiguous @ExceptionHandler method mapped for [ExceptionHandler{exceptionType=org.springframework.web.HttpRequestMethodNotSupportedException, mediaType=*/*}]: {public org.springframework.http.ResponseEntity roomescape.exception.ProblemDetailsAdvice.handleMethodNotSupportedException(org.springframework.web.HttpRequestMethodNotSupportedException), public final org.springframework.http.ResponseEntity org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler.handleException(java.lang.Exception,org.springframework.web.context.request.WebRequest) throws java.lang.Exception}
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:657) ~[spring-beans-6.2.5.jar:6.2.5]
```

위와 같은 에러 발생.

#### `원인`

`ProblemDetailsAdvice` 가 `ResponseEntityExceptionHandler` 를 상속받았기 떄문에  
`HttpRequestMethodNotSupportedException` 에 대한 핸들러가 이미 부모 클래스에 존재해  
추가한 핸들러와 충돌.

#### `해결`

일반적인 예외에 대한 핸들러를 `추가`하는 것이 아닌 `재정의` 해야.

---

## 미션 완료 조건

* [ ] 

## 산출물

* [ ] 

---
