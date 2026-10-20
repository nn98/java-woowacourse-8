# 📖 방탈출 사용자 예약

<details><summary><h2>미션</h2></summary>

<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">📘 사이클2 - 사전학습</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>사이클2: 사전학습</h1>
<blockquote>
<p><strong>혼자서 실험하고 관찰한다. 토론 활동의 재료를 만드는 단계.</strong></p>
</blockquote>
<hr>
<h2>이번 사이클에서 답할 질문</h2>
<ul>
<li>잘못된 요청에 지금 내 코드는 어떻게 응답하고 있는가?</li>
<li>에러 응답에 무엇을 담아야 사용자가 다음에 무엇을 할 수 있는가?</li>
<li>변경·취소는 생성보다 어떤 에러 케이스가 더 많은가?</li>
<li>사이클1에서 만든 API 설계 규칙은 에러 상황에서도 그대로 유효한가?</li>
</ul>
<hr>
<h2>사전 학습 키워드</h2>
<table>
<thead>
<tr>
<th>목적</th>
<th>키워드</th>
</tr>
</thead>
<tbody>
<tr>
<td>예외 처리</td>
<td><code data-backticks="1">@ExceptionHandler</code>, <code data-backticks="1">@ControllerAdvice</code>, 예외 변환</td>
</tr>
<tr>
<td>응답 설계</td>
<td>HTTP Status Code (4xx/5xx), 에러 응답 본문 형식</td>
</tr>
<tr>
<td>변경/취소</td>
<td>PUT vs PATCH, 멱등성, 리소스 상태</td>
</tr>
</tbody>
</table>
<blockquote>
<p><strong>키워드 사용법</strong>: 위 키워드를 검색해서 기본 개념을 익힌다.<br>
깊이 파지 않아도 된다. "이런 게 있구나" 수준이면 충분하다.<br>
모르는 것이 있어도 실험을 먼저 해본다. 막히면 그때 찾아본다.</p>
</blockquote>
<hr>
<h2>실험 범위</h2>
<p><strong>서비스 정책·예외 처리·변경/취소를 모두 구현하지 않는다.</strong></p>
<p>실험은 <strong>사이클1 코드에 잘못된 요청을 보내 응답을 관찰</strong>하고, <strong>변경/취소 API를 종이 위에서 설계</strong>해보는 두 가지다.</p>
<blockquote>
<p><strong>왜 잘못된 요청부터 보내보는가</strong>: 정상 흐름만 만들어둔 코드는 잘못된 요청에 어떻게 응답하는지 본인도 모를 때가 많다. 토론에서 "사용자에게 뭘 보여줘야 하는가"를 다루기 전에, <strong>지금 내 코드가 실제로 뭘 보여주고 있는지</strong>를 먼저 봐야 비교가 가능하다.</p>
</blockquote>
<hr>
<h2>실험1: 사이클1 코드에 잘못된 요청 보내기</h2>
<h3>해볼 것</h3>
<ol>
<li>사이클1에서 만든 코드를 실행한다 (Postman·브라우저 등 자유)</li>
<li>다음 네 가지 잘못된 요청을 보낸다
<ul>
<li>존재하지 않는 예약 조회</li>
<li>필수 값이 빠진 예약 생성</li>
<li>이미 지난 날짜로 예약 시도</li>
<li>같은 시간·테마에 중복 예약 시도</li>
</ul>
</li>
<li>각 요청에 대한 <strong>상태 코드</strong>와 <strong>응답 본문</strong>을 그대로 기록한다</li>
</ol>
<h3>관찰할 것</h3>
<ul>
<li>어떤 요청이 500을 반환했는가? 사용자에게 그대로 노출되어도 되는가?</li>
<li>응답 본문에 "무엇이 잘못됐는지"가 들어 있는가? "다음에 뭘 할 수 있는지"는?</li>
<li>4개 응답의 형식이 일관적인가?</li>
</ul>
<h3>기록하기</h3>
<p><strong>형식</strong>: 요청별로 <strong>상태 코드 / 본문 / 사용자가 이걸 보면 뭘 할 수 있는가</strong></p>
                <pre id="default-rn0xs45oyz" class="hljs-code-block overflow-hidden relative d-flex mt-3 mb-8">                    <button type="button" class="clipboard-btn v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--default absolute right-10 top-10 z-1 grey--text text--darken-3">
                      <span class="v-btn__content">
                        <i aria-hidden="true" class="v-icon notranslate mdi mdi-clipboard theme--light"></i>
                      </span>
                    </button>
                    <code class="relative pa-4 lh-1-3 text-normal width-100 ls-0
                   language-plaintext hljs">예시:
- 요청: 같은 시간·테마에 중복 예약
- 상태 코드: 500
- 본문: {"timestamp":"...","status":500,"error":"Internal Server Error",...}
- 사용자가 할 수 있는 것: 거의 없음. 무엇이 문제인지 모른다.
  </code>
  </pre>
<hr>
<h2>실험2: 예약 변경/취소 API 설계</h2>
<h3>해볼 것</h3>
<ol>
<li>"사용자가 자신의 예약을 취소한다", "예약 날짜·시간을 변경한다"를 API로 만든다고 가정한다</li>
<li>두 API의 URL·HTTP 메서드·요청·응답·상태 코드를 적는다</li>
<li>변경/취소가 <strong>거부되어야 하는 케이스</strong>를 떠오르는 만큼 적고, 각 케이스의 응답을 설계한다</li>
</ol>
<h3>관찰할 것</h3>
<ul>
<li>변경 API에 어떤 HTTP Method를 쓸 것인가? 무엇을 기준으로 결정했는가?</li>
<li>"이미 지난 예약을 취소"는 허용할 것인가, 거부할 것인가? 거부한다면 상태 코드는?</li>
<li>변경하려는 시간이 이미 차 있을 때, 응답에 "예약 가능한 다른 시간"까지 알려줄 것인가?</li>
</ul>
<h3>기록하기</h3>
<p>관찰 기록에 추가:</p>
<ul>
<li>거부해야 하는 케이스 1개와 그 응답 설계 (상태 코드 + 본문)</li>
<li>그 응답을 받은 사용자가 다음에 할 수 있는 행동</li>
</ul>
<hr>
<h2>사전 학습 준비 가이드</h2>
<p>사전 학습 시 다음을 목표로 한다:</p>
<ul>
<li class="task-list-item" data-te-task="">실험을 직접 수행했다</li>
<li class="task-list-item" data-te-task="">관찰 기록을 작성했다</li>
<li class="task-list-item" data-te-task="">토론 활동에서 말할 근거가 1개 이상 있다</li>
</ul>
<hr>
<h2>산출물</h2>
<blockquote>
<p>사전 학습 산출물의 제출은 토론 활동 전 완료까지 완료한다.<br>
산출물은 <a href="https://techcourse-lms-plus-web.woowahan.com/crew">LMS+</a> 에 제출한다.</p>
</blockquote>
<ul>
<li class="task-list-item" data-te-task="">관찰 기록</li>
<li class="task-list-item" data-te-task="">토론에서 가장 묻고 싶은 질문 1개</li>
</ul>
</div></div></div></div>

</details>

## 🚀 사이클2 - 미션 (예약 변경/취소와 에러 처리)

---

# `1. 사전 학습`

- Q. 잘못된 요청에 지금 내 코드는 어떻게 응답하고 있는가?
- A. 몇몇 처리된 코드 외엔 순수하게 예외를 발생시키고 전달
- Q. 에러 응답에 무엇을 담아야 사용자가 다음에 무엇을 할 수 있는가?
- A. 에러의 원인과 내용에 대한 정보
- Q. 변경·취소는 생성보다 어떤 에러 케이스가 더 많은가?
- A. 없는 값에 대한 요청에 따른 에러
- Q. 사이클1에서 만든 API 설계 규칙은 에러 상황에서도 그대로 유효한가?
- A. 개인적으로 추가한 규칙에 따르면 유효하다.
  > - 동작하는 API 중 바람직한 API 가 좋은 API 다.
  >* 올바른 요청에 올바른 응답을 보내는 것은 동작하는 API 다.
  >* **잘못된 요청에 합당한 응답을 보내는 것은 바람직한 API 다.**
  >* 명세만으로 목적/행위/결과를 추론할 수 있는 것은 바람직한 API 다.
  >* 드러나선 안 될 정보를 은닉하는 것은 바람직한 API 다.
  >* 엔드포인트는 `무엇`을, 메서드는 `어떻게`를 표현한다.

## 키워드

<table>
<thead>
<tr>
<th>목적</th>
<th>키워드</th>
</tr>
</thead>
<tbody>
<tr>
<td>예외 처리</td>
<td><code data-backticks="1">@ExceptionHandler</code>, <code data-backticks="1">@ControllerAdvice</code>, 예외 변환</td>
</tr>
<tr>
<td>응답 설계</td>
<td>HTTP Status Code (4xx/5xx), 에러 응답 본문 형식</td>
</tr>
<tr>
<td>변경/취소</td>
<td>PUT vs PATCH, 멱등성, 리소스 상태</td>
</tr>
</tbody>
</table>

## 실험 범위

서비스 정책·예외 처리·변경/취소를 모두 구현하지 않는다.

실험은 사이클1 코드에 잘못된 요청을 보내 응답을 관찰하고, 변경/취소 API를 종이 위에서 설계해보는 두 가지다.

> **왜 잘못된 요청부터 보내보는가**: 정상 흐름만 만들어둔 코드는 잘못된 요청에 어떻게 응답하는지 본인도 모를 때가 많다.  
> 토론에서 "사용자에게 뭘 보여줘야 하는가"를 다루기 전에,  
> 지금 내 코드가 실제로 뭘 보여주고 있는지를 먼저 봐야 비교가 가능하다.

## **실험1: 사이클1 코드에 잘못된 요청 보내기**

### **해볼 것**

- [x] 사이클1 코드 실행
- [x] 잘못된 요청 4개 전송

#### 1. 존재하지 않는 예약 조회

```jsonpath
GET http://localhost:8080/reservations/999

HTTP/1.1 500
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 11 May 2026 16: 16: 04 GMT
Connection: close

{
"timestamp": "2026-05-11T16:16:04.701+00:00",
"status": 500,
"error": "Internal Server Error",
"path": "/reservations/999"
}
```

- 사용자가 할 수 있는 것: 거의 없음. 무엇이 문제인지 모른다.

#### 2. 필수 값 누락 예약 생성

```jsonpath
POST http://localhost:8080/reservations

HTTP/1.1 400
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 11 May 2026 16: 18: 55 GMT
Connection: close

{
    "timestamp": "2026-05-11T16:18:55.328+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/reservations"
}
```

- 사용자가 할 수 있는 것: 거의 없음. 무엇이 문제인지 모른다.

#### 3. 지난 날짜로 예약 시도

```jsonpath
POST http://localhost:8080/reservations

HTTP/1.1 201
Location: /reservations/295
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 11 May 2026 16:20: 53 GMT

{
    "id": 295,
    "name": "브라운",
    "date": "2025-08-05",
    "time": {
        "id": 1,
        "startAt": "09:00:00",
        "isAvailable": true
    },
    "theme": {
        "id": 1,
        "name": "폐병원 탈출",
        "description": "버려진 병원에서 벌어지는 기괴한 일들. 살아서 나가야 한다.",
        "thumbnailUrl": "https://example.com/t1.jpg"
    }
}
```

- 사용자가 할 수 있는 것: 없음. 그냥 성공.

#### 4. 같은 시간/테마에 중복 예약 시도

```jsonpath
POST http://localhost:8080/reservations

HTTP/1.1 500
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 11 May 2026 16: 22: 04 GMT
Connection: close

{
    "timestamp": "2026-05-11T16:22:04.102+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/reservations"
}
```

- 사용자가 할 수 있는 것: 거의 없음. 무엇이 문제인지 모른다.

### **관찰할 것**

|                         질문                         |                                    답변                                     |
|:--------------------------------------------------:|:-------------------------------------------------------------------------:|
|    어떤 요청이 500을 반환했는가? <br/>사용자에게 그대로 노출되어도 되는가?    | 1번과 4번.<br/>충분히 예측 가능한 예외에 <br/>Internal Server Error 를 노출하는 것은 바람직하지 않다. |
| 응답 본문에 "무엇이 잘못됐는지"가 들어 있는가? <br/>"다음에 뭘 할 수 있는지"는? |        예외를 처리한 중복 예약에서도 <br/>서버 콘솔에서만 메시지 확인이 가능. <br/>둘 다 알 수 없다.        |
|                 4개 응답의 형식이 일관적인가?                  |                           처리되지 않은 예외라는 일관성은 있다.                           |

---

## **실험2: 예약 변경/취소 API 설계**

### **해볼 것**

- [x] "사용자가 자신의 예약을 취소한다", "예약 날짜·시간을 변경한다"를 API로 만든다고 가정한다
- [x] 두 API의 URL·HTTP 메서드·요청·응답·상태 코드를 적는다
- [x] 변경/취소가 거부되어야 하는 케이스를 떠오르는 만큼 적고, 각 케이스의 응답을 설계한다

`사용자가 자신의 예약을 취소한다`

- 요청

```jsonpath
DELETE localhost:8080/reservations/{id} HTTP/1.1
Content-Type: application/json
```

- 응답 (정상적 요청)

```jsonpath
DELETE http://localhost:8080/reservations/{id}

HTTP/1.1 200 

{
    "timestamp": "2026-05-11T16:22:04.102+00:00",
    "status": 200,
    "message": "예약이 정상적으로 취소되었습니다.",
    "path": "/reservations"
}
```

- 응답 (잘못된 요청)

```jsonpath
DELETE http://localhost:8080/reservations/{id}

HTTP/1.1 400 

{
    "timestamp": "2026-05-11T16:22:04.102+00:00",
    "status": 400,
    "message": "해당 예약 정보가 존재하지 않습니다.",
    "path": "/reservations"
}
```

`예약 날짜·시간을 변경한다`

- 요청

```jsonpath
PUT localhost:8080/reservations/{id} HTTP/1.1
Content-Type: application/json

{
    "date": "2026-05-07",
    "name": "브라운",
    "timeId": 1,
    "themeId": 1
}

```

- 응답 (정상적 요청)

```jsonpath
PUT http://localhost:8080/reservations/{id}

HTTP/1.1 200 

{
    "timestamp": "2026-05-11T16:22:04.102+00:00",
    "status": 200,
    "message": "예약이 정상적으로 변경되었습니다.",
    "path": "/reservations", 
    "reservation": {
        "id": {id},
        "name": "브라운",
        "date": "2026-05-07",
        "time": {
            "id": 1,
            "startAt": "09:00:00",
            "isAvailable": true
        },
        "theme": {
            "id": 1,
            "name": "폐병원 탈출",
            "description": "버려진 병원에서 벌어지는 기괴한 일들. 살아서 나가야 한다.",
            "thumbnailUrl": "https://example.com/t1.jpg"
        }
    }
}
```

- 응답 (잘못된 요청)

```jsonpath
PUT http://localhost:8080/reservations/{id}

HTTP/1.1 400 

{
    "timestamp": "2026-05-11T16:22:04.102+00:00",
    "status": 400,
    "message": "해당 예약 정보가 존재하지 않습니다.",
    "path": "/reservations"
}
```

`거부되어야 하는 케이스`

각각엔 타임스탬프가 포함된 것으로 가정

- 존재하지 않는 예약에 대한 수정/삭제
    - `400`, "message": "해당 예약 정보가 존재하지 않습니다."
- 다른 사용자의 예약에 대한 수정/삭제
    - `403`, "message": "자신의 예약 정보만 수정 및 삭제할 수 있습니다."
- 이미 지난 예약에 대한 수정/삭제
    - `400`, "message": "지나간 예약은 수정 및 삭제할 수 없습니다."
- 이미 존재하는 예약(동일한 날짜, 테마, 시간)으로의 수정
    - `400`, "message": "선택하신 시간과 테마는 이미 예약되었습니다."
- 이미 지난 시간으로의 수정
    - `403`, "message": "지나간 날짜로 수정할 수 없습니다."

### **관찰할 것**

|                         질문                          |                    답변                    |           사용자 대응            |
|:---------------------------------------------------:|:----------------------------------------:|:---------------------------:|
| 변경 API에 어떤 HTTP Method를 쓸 것인가? <br/>무엇을 기준으로 결정했는가? |         PUT. RESTful 한 설계에서 권장해서         | 없는 값에 대한 접근은 <br/>정상 처리로 인지 |
|   "이미 지난 예약을 취소"는 허용할 것인가, 거부할 것인가? 거부한다면 상태 코드는?   |    거부. 완결된 데이터에 대한 접근은 차단해야.<br/>400     |    이미 지난 예약에 대한 접근 불가 인지    |
| 변경하려는 시간이 이미 차 있을 때, 응답에 "예약 가능한 다른 시간"까지 알려줄 것인가?  | 고지하지 않는다. <br/>이미 존재하는 기능이고 불필요한 호출이 반복됨 |   실패 후 변경 가능 시간을 조회해서 선택    |

---

## **사전 학습 준비 가이드**

사전 학습 시 다음을 목표로 한다:

- [x] 실험을 직접 수행했다
- [x] 관찰 기록을 작성했다
- [x] 토론 활동에서 말할 근거가 1개 이상 있다

## **산출물**

- [x] 관찰 기록
- [x] 토론에서 가장 묻고 싶은 질문 1개

## 산출물(제출 내용)

- ### Q.
- ### A.

## 개선 가능 부분

- 
