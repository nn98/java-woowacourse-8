# 📖 미션

<details><summary><h2>미션</h2></summary>

<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">📘 사이클1 - 사전학습</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>사이클1: 사전학습</h1>
<blockquote>
<p><strong>혼자서 실험하고 관찰한다. 토론 활동의 재료를 만드는 단계.</strong></p>
</blockquote>
<hr>
<h2>이번 사이클에서 답할 질문</h2>
<ul>
<li>명세 없이 직접 API를 설계하라고 하면 무엇부터 결정해야 하는가?</li>
<li>URL·HTTP 메서드·요청·응답·상태 코드를 무엇을 기준으로 결정할 것인가?</li>
<li>"예약 가능 시간" 같은 판단을 서버가 책임질 것인가, 클라이언트가 책임질 것인가?</li>
<li>기존에 있는 관리자 API와 새로 추가하는 사용자 API의 관계를 어떻게 정리할 것인가?</li>
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
<td>HTTP 기본</td>
<td>HTTP 메시지(요청/응답), HTTP Method, Status Code</td>
</tr>
<tr>
<td>API 설계</td>
<td>REST API, 리소스 식별, URL 경로 설계</td>
</tr>
<tr>
<td>도메인 확장</td>
<td>엔티티 추가, 외래 키, 연관관계</td>
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
<p><strong>사용자 예약 기능 전체를 코드로 구현하지 않는다.</strong></p>
<p>실험은 <strong>종이(또는 빈 문서) 위에서 API를 설계해본다</strong>.</p>
<blockquote>
<p><strong>왜 코드가 아니라 종이인가</strong>: 코드를 쓰기 시작하면 IDE의 자동완성과 익숙한 패턴에 끌려간다. 종이 위에서는 "왜 이걸 GET으로 했지?", "왜 URL을 이렇게 짰지?"가 그대로 드러난다. 토론에서 비교할 재료는 코드가 아니라 <strong>각자의 결정과 그 이유</strong>다.</p>
</blockquote>
<hr>
<h2>실험1: 사용자 예약 API 직접 설계</h2>
<h3>해볼 것</h3>
<ol>
<li>"사용자가 날짜·테마를 골라 예약 가능한 시간을 보고, 선택해 예약한다" 흐름에 필요한 엔드포인트를 정한다</li>
<li>각 엔드포인트의 URL·HTTP 메서드·요청·응답·상태 코드를 적는다</li>
<li>결정마다 "왜 이렇게 했는가" 한 줄 이유를 붙인다</li>
</ol>
<h3>관찰할 것</h3>
<ul>
<li>가장 망설인 결정은 무엇인가? 무엇과 무엇 사이에서 망설였는가?</li>
<li>"정답이 있을 것 같다"고 느낀 결정과 "내가 선택할 수 있다"고 느낀 결정은 어떻게 다른가?</li>
<li>"예약 가능한 시간"을 응답에서 어떻게 처리했는가? (서버에서 거름 / 전체 + 예약 여부)</li>
</ul>
<h3>기록하기</h3>
<p><strong>형식</strong>: 망설인 결정 1개 → <strong>선택지 A / 선택지 B / 내 선택 / 이유</strong></p>
                <pre id="default-3ttwg4xp1q" class="hljs-code-block overflow-hidden relative d-flex mt-3 mb-8">                    <button type="button" class="clipboard-btn v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--default absolute right-10 top-10 z-1 grey--text text--darken-3">
                      <span class="v-btn__content">
                        <i aria-hidden="true" class="v-icon notranslate mdi mdi-clipboard theme--light"></i>
                      </span>
                    </button>
                    <code class="relative pa-4 lh-1-3 text-normal width-100 ls-0
                   language-plaintext hljs">예시:
- 항목: 예약 가능 시간 조회 URL
- 선택지 A: GET /times?date=2026-05-08&amp;themeId=1
- 선택지 B: GET /themes/1/available-times?date=2026-05-08
- 내 선택: A
- 이유: 시간 자체가 리소스고, 테마와 날짜는 필터 조건이라고 봤다.
  </code>
  </pre>
<hr>
<h2>실험2: 관리자 API와의 일관성 점검</h2>
<h3>해볼 것</h3>
<ol>
<li>미션1에서 만든 관리자 예약 API를 옆에 펼쳐 둔다</li>
<li>실험1의 사용자 예약 API와 URL·메서드·응답 컨벤션을 비교한다</li>
<li>같은 컨벤션으로 "최근 1주 동안 예약이 많은 테마 상위 10개" API를 추가해본다</li>
</ol>
<h3>관찰할 것</h3>
<ul>
<li>관리자 API와 사용자 API가 일관적인가? 일관성이 깨지는 지점이 있는가?</li>
<li>두 API를 같은 엔드포인트로 합칠 것인가, 분리할 것인가? 무엇을 기준으로 결정했는가?</li>
<li>인기 테마 API를 추가할 때 어떤 컨벤션이 자연스럽게 적용됐는가?</li>
</ul>
<h3>기록하기</h3>
<p>관찰 기록에 추가:</p>
<ul>
<li>일관성이 깨진 지점 1곳</li>
<li>그 지점에 대한 내 결정과 이유</li>
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

## 🚀 미션 - :

---

# `1. 사전 학습`

- Q.
- A.

## 키워드

>

## 실험 범위

****

## **실험1: **

### **해볼 것**

- [x] 
- [x] 
- [x] 

### **관찰할 것**

-
-

| 질문 | 답변 |
|:--:|:--:|
|    |    |
|    |    |
|    |    |
|    |    |

### **기록하기**

> ###    
> - `사실`:
> - `문제`:

---

## **사전 학습 준비 가이드**

사전 학습 시 다음을 목표로 한다:

- [x] 
- [x] 
- [x] 

## **산출물**

- [x] 

## 산출물(제출 내용)

- ### Q.
- ### A.

## 개선 가능 부분

- 
