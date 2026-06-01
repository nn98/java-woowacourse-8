<details><summary><h2>미션 정보</h2></summary>

<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">📘 사이클2 - 사전학습</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>사이클2: 사전학습</h1>
<blockquote>
<p><strong>혼자서 실험하고 관찰한다. 토론 활동의 재료를 만드는 단계.</strong></p>
</blockquote>
<hr>
<h2>이번 사이클에서 답할 질문</h2>
<ul>
<li>내 코드에서 <strong>여러 데이터 변경이 함께 일어나야 하는 곳</strong>은 어디인가?</li>
<li>그 변경 중 일부만 성공했을 때 데이터는 어떤 상태가 되는가? 사용자는 그 상태에서 무엇을 보게 되는가?</li>
<li>어디까지를 하나의 작업 단위로 묶을 것인가? 그 경계는 무엇이 결정하는가?</li>
<li>지금까지의 규칙은 이 기능에서도 그대로 유효한가?</li>
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
<td>트랜잭션</td>
<td><code data-backticks="1">@Transactional</code>, 전파(Propagation), 롤백, 원자성</td>
</tr>
<tr>
<td>동시성</td>
<td>동시 요청, 데이터 정합성</td>
</tr>
<tr>
<td>도메인</td>
<td>상태 전이, 작업 단위 (Unit of Work)</td>
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
<p><strong>예약 대기 승인 기능 전체를 구현하지 않는다.</strong></p>
<p>실험은 <strong>사이클1 코드에서 함께 일어나는 작업을 찾아 분석</strong>하고, <strong>대기 승인 흐름을 종이 위에서 설계</strong>해보는 두 가지다.</p>
<blockquote>
<p><strong>왜 코드부터 보지 않는가</strong>: <code data-backticks="1">@Transactional</code>을 어디에 붙일지부터 시작하면 도구 사용법이 결론이 된다. 이번 사이클의 질문은 "어디에 붙이는가"가 아니라 <strong>왜 이것들이 함께 일어나야 한다고 판단했는가</strong>이다. 그 판단은 코드보다 도메인의 흐름을 그릴 때 또렷해진다.</p>
</blockquote>
<hr>
<h2>실험1: 함께 일어나는 작업 찾기</h2>
<h3>해볼 것</h3>
<ol>
<li>사이클1 코드를 펼쳐 놓고, <strong>두 가지 이상의 데이터 변경이 같은 요청 안에서 일어나는 기능</strong>을 찾는다 (예약 생성, 대기 신청, 대기 취소 등)</li>
<li>각 기능에서 <strong>어떤 데이터들이 함께 변경되는지</strong> 적는다</li>
<li>첫 번째 변경만 성공하고 두 번째가 실패했다고 가정했을 때, <strong>데이터가 어떤 상태가 되는지</strong> 적는다</li>
</ol>
<h3>관찰할 것</h3>
<ul>
<li>어떤 기능이 가장 위험한가? (중간 실패 시 사용자 경험이 가장 망가지는 것)</li>
<li>"사실은 함께 일어나야 했는데 그렇게 안 짜여 있던" 곳이 있는가?</li>
<li>그 상태에서 사용자가 다음 요청을 보내면 무엇이 보이는가?</li>
</ul>
<h3>기록하기</h3>
<p><strong>형식</strong>: <strong>기능 / 함께 변경되는 데이터 / 첫 번째만 성공 시 상태 / 사용자가 보게 되는 것</strong></p>
                <pre id="default-b2mur5zxj3" class="hljs-code-block overflow-hidden relative d-flex mt-3 mb-8">                    <button type="button" class="clipboard-btn v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--default absolute right-10 top-10 z-1 grey--text text--darken-3">
                      <span class="v-btn__content">
                        <i aria-hidden="true" class="v-icon notranslate mdi mdi-clipboard theme--light"></i>
                      </span>
                    </button>
                    <code class="relative pa-4 lh-1-3 text-normal width-100 ls-0
                   language-plaintext hljs">예시:
- 기능: 대기 신청
- 함께 변경: 대기 테이블에 ROW 추가 + 대기 순번 카운터 갱신
- 첫 번째만 성공 시: 대기는 추가됐는데 순번이 비어 있음
- 사용자가 보게 되는 것: 내 예약 목록에 "대기 ?번"으로 표시됨
  </code>
  </pre>
<hr>
<h2>실험2: 대기 승인 흐름 설계</h2>
<h3>해볼 것</h3>
<ol>
<li>"예약 대기를 승인해 예약으로 전환한다"를 어떻게 구현할지 종이 위에 그린다</li>
<li><strong>자동 전환</strong>(예약 취소 시 대기 1번 자동 전환) / <strong>수동 승인</strong>(관리자가 승인) 중 하나를 고르고, 왜 골랐는지 적는다</li>
<li>그 흐름에서 <strong>함께 일어나야 하는 데이터 변경</strong>을 모두 적는다 (예약 추가/삭제, 대기 상태 변경, 순번 재정렬 등)</li>
<li>그 변경들을 <strong>하나로 묶을 것인가, 따로 처리할 것인가</strong>를 결정하고 이유를 적는다</li>
</ol>
<h3>관찰할 것</h3>
<ul>
<li>묶기로 한 변경이 중간에 실패하면 어떤 상태가 되는가? 그 상태가 허용 가능한가?</li>
<li>따로 처리하기로 한 변경이 중간에 실패하면 어떤 상태가 되는가? 그 상태가 허용 가능한가?</li>
<li>동시에 두 사용자가 같은 슬롯에 요청을 보낸다면 어떤 일이 벌어지는가?</li>
</ul>
<h3>기록하기</h3>
<p>관찰 기록에 추가:</p>
<ul>
<li>자동/수동 중 내 선택과 이유 1줄</li>
<li>묶기로 한 변경 / 따로 처리하기로 한 변경의 경계와 그 이유</li>
</ul>
<hr>
<h2>사전 학습 준비 가이드</h2>
<p>사전 학습 시 다음을 목표로 한다:</p>
<ul>
<li class="task-list-item" data-te-task="">함께 일어나는 작업을 1개 이상 분석했다</li>
<li class="task-list-item" data-te-task="">대기 승인 흐름을 그리고 경계 결정을 했다</li>
<li class="task-list-item" data-te-task="">토론 활동에서 말할 근거가 1개 이상 있다</li>
</ul>
<hr>
<h2>산출물</h2>
<blockquote>
<p>사전 학습 산출물의 제출은 토론 활동 전 완료까지 완료한다.<br>
산출물은 <a href="https://techcourse-lms-plus-web.woowahan.com/crew">LMS+</a> 에 제출한다.</p>
</blockquote>
<ul>
<li class="task-list-item" data-te-task="">함께 일어나는 작업 분석 (실험1)</li>
<li class="task-list-item" data-te-task="">대기 승인 흐름 설계 + 경계 결정과 이유 (실험2)</li>
<li class="task-list-item" data-te-task="">토론에서 가장 묻고 싶은 질문 1개</li>
</ul>
</div></div></div></div>

</details>

---

<h2>이번 사이클에서 답할 질문</h2>
<ul>
<li>내 코드에서 <strong>여러 데이터 변경이 함께 일어나야 하는 곳</strong>은 어디인가?</li>

- 현재 적용되지 않았지만 예약 삭제 시 최우선 대기 예약으로 승격 필요

<li>그 변경 중 일부만 성공했을 때 데이터는 어떤 상태가 되는가? 사용자는 그 상태에서 무엇을 보게 되는가?</li>

- 예약만 삭제되고 대기가 승격되지 않는다면
    - 존재하지 않는 예약에 대기가 걸림
    - 예약이 존재하지 않는데 대기 순번이 남음
    - 예약 가능이라 뜨지만 대기는 이미 존재함(우선순위 위배)

<li>어디까지를 하나의 작업 단위로 묶을 것인가? 그 경계는 무엇이 결정하는가?</li>

- 하나의 메서드가 진행하는 행위?

<li>지금까지의 규칙은 이 기능에서도 그대로 유효한가?</li>

- 트랜잭션에 대해 정의한 규칙에선 유효하지않나

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
<td>트랜잭션</td>
<td><code data-backticks="1">@Transactional</code>, 전파(Propagation), 롤백, 원자성</td>
</tr>
<tr>
<td>동시성</td>
<td>동시 요청, 데이터 정합성</td>
</tr>
<tr>
<td>도메인</td>
<td>상태 전이, 작업 단위 (Unit of Work)</td>
</tr>
</tbody>
</table>

<hr>
<h2>실험1: 함께 일어나는 작업 찾기</h2>
<h3>해볼 것</h3>
<ol>
<li>사이클1 코드를 펼쳐 놓고, <strong>두 가지 이상의 데이터 변경이 같은 요청 안에서 일어나는 기능</strong>을 찾는다 (예약 생성, 대기 신청, 대기 취소 등)</li>

- 변경의 중첩은 없는디
- 생긴다면 예약 취소 - 대기 확인 - 대기->예약 승격 기능

<li>각 기능에서 <strong>어떤 데이터들이 함께 변경되는지</strong> 적는다</li>

- 예약 테이블 - 삭제(소프트 딜리트로?)
    - 취소된 예약의 정보를 삭제하고, 대기 정보를 탐색한다
- 대기 테이블 - 삭제
    - 취소된 예약에 대한 대기라면, 최우선(created_at이 가장 빠른) 대기를 삭제하고
- 예약 테이블 - 삽입
    - 삭제한 대기 정보로 예약을 삽입한다

<li>첫 번째 변경만 성공하고 두 번째가 실패했다고 가정했을 때, <strong>데이터가 어떤 상태가 되는지</strong> 적는다</li>

- 예약은 삭제되었는데 대기가 잔존
- 예약 없는 대기는 불가능하다는 도메인 로직 위배

</ol>
<h3>관찰할 것</h3>
<ul>
<li>어떤 기능이 가장 위험한가? (중간 실패 시 사용자 경험이 가장 망가지는 것)</li>

- 예약 취소 시 자동 대기 승격 기능

<li>"사실은 함께 일어나야 했는데 그렇게 안 짜여 있던" 곳이 있는가?</li>

- 예약 취소 시 예약만 삭제되고 있음

<li>그 상태에서 사용자가 다음 요청을 보내면 무엇이 보이는가?</li>

- 예약이 없는데 대기는 걸려있음
- 대기가 여러개일 경우 각 대기자 모두의 사용자 경험이 망가짐

</ul>
<h3>기록하기</h3>
<p><strong>형식</strong>: <strong>기능 / 함께 변경되는 데이터 / 첫 번째만 성공 시 상태 / 사용자가 보게 되는 것</strong></p>
                <pre id="default-b2mur5zxj3" class="hljs-code-block overflow-hidden relative d-flex mt-3 mb-8">                    <button type="button" class="clipboard-btn v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--default absolute right-10 top-10 z-1 grey--text text--darken-3">
                      <span class="v-btn__content">
                        <i aria-hidden="true" class="v-icon notranslate mdi mdi-clipboard theme--light"></i>
                      </span>
                    </button>
                    <code class="relative pa-4 lh-1-3 text-normal width-100 ls-0
                   language-plaintext hljs">예시:
- 기능: 대기 신청
- 함께 변경: 대기 테이블에 ROW 추가 + 대기 순번 카운터 갱신
- 첫 번째만 성공 시: 대기는 추가됐는데 순번이 비어 있음
- 사용자가 보게 되는 것: 내 예약 목록에 "대기 ?번"으로 표시됨
  </code>
  </pre>
<hr>
<h2>실험2: 대기 승인 흐름 설계</h2>
<h3>해볼 것</h3>
<ol>
<li>"예약 대기를 승인해 예약으로 전환한다"를 어떻게 구현할지 종이 위에 그린다</li>
<li><strong>자동 전환</strong>(예약 취소 시 대기 1번 자동 전환) / <strong>수동 승인</strong>(관리자가 승인) 중 하나를 고르고, 왜 골랐는지 적는다</li>
<li>그 흐름에서 <strong>함께 일어나야 하는 데이터 변경</strong>을 모두 적는다 (예약 추가/삭제, 대기 상태 변경, 순번 재정렬 등)</li>
<li>그 변경들을 <strong>하나로 묶을 것인가, 따로 처리할 것인가</strong>를 결정하고 이유를 적는다</li>
</ol>
<h3>관찰할 것</h3>
<ul>
<li>묶기로 한 변경이 중간에 실패하면 어떤 상태가 되는가? 그 상태가 허용 가능한가?</li>

- 예약만 삭제되고 대기가 남아있다
- 허용 불가. 존재하는 예약에 대한 대기만 가능하다

<li>따로 처리하기로 한 변경이 중간에 실패하면 어떤 상태가 되는가? 그 상태가 허용 가능한가?</li>

- 대기 없는 예약의 삭제
- 대기 삭제
- 실패하면 원상태 유지, 성공하면 삭제
- 허용 가능

<li>동시에 두 사용자가 같은 슬롯에 요청을 보낸다면 어떤 일이 벌어지는가?</li>

- 어떤요청? 동시 예약? 동시 취소?
- 동시 예약이 발생할 경우 UNIQUE 조건으로 방지됨.
- 동시 취소가 발생할 경우 삭제는 정상적으로 진행
- 하지만 대기의 승급에서 중복 동작이 발생해 같은 값으로 예약 2개 가능,
- 트랜잭션으로 묶어서 방지해야 할 동시성 이슈

</ul>

<h3>기록하기</h3>
<p>관찰 기록에 추가:</p>
<ul>

<li>자동/수동 중 내 선택과 이유 1줄</li>

- 자동. 실험 과정에 남겼듯이 자동 선택의 이점이 단점보다 뛰어나서

<li>묶기로 한 변경 / 따로 처리하기로 한 변경의 경계와 그 이유</li>

- 예약 대기처럼 후속 작업이 존재하는 변경만 묶어서 처리
- 그 외의 변경 쿼리는 단일 동작으로 처리

</ul>
<hr>

# LMS+

---

### Q. 사전학습 관찰 기록을 남겨주세요.

## 실험 1

<h3>관찰할 것</h3>
<ul>
<li>어떤 기능이 가장 위험한가? (중간 실패 시 사용자 경험이 가장 망가지는 것)</li>

- 예약 취소 시 자동 대기 승격 기능

<li>"사실은 함께 일어나야 했는데 그렇게 안 짜여 있던" 곳이 있는가?</li>

- 예약 취소 시 예약만 삭제되고 있음

<li>그 상태에서 사용자가 다음 요청을 보내면 무엇이 보이는가?</li>

- 예약이 없는데 대기는 걸려있음
- 대기가 여러개일 경우 각 대기자 모두의 사용자 경험이 망가짐

<p>추가</p>

<li>기능</li>

- 예약 취소 시 자동 대기 승격 기능

<li>함께 변경되는 데이터</li>

- 예약 데이터 삭제 / 대기 데이터 삭제 / 예약 데이터 추가

<li>첫 번째만 성공 시</li>

- 예약이 없는데 대기가 존재

<li>사용자가 보게 되는 것</li>

- 예약이 없는데 대기가 존재하는 모습
- 대기가 무시되고 새로운 예약이 가능한 모습

</ul>

---

## 실험 2

<h3>관찰할 것</h3>
<ul>
<li>묶기로 한 변경이 중간에 실패하면 어떤 상태가 되는가? 그 상태가 허용 가능한가?</li>

- 예약만 삭제되고 대기가 남아있다
- 허용 불가. 존재하는 예약에 대한 대기만 가능하다

<li>따로 처리하기로 한 변경이 중간에 실패하면 어떤 상태가 되는가? 그 상태가 허용 가능한가?</li>

- 대기 없는 예약의 삭제
- 대기 삭제
- 실패하면 원상태 유지, 성공하면 삭제
- 허용 가능

<li>동시에 두 사용자가 같은 슬롯에 요청을 보낸다면 어떤 일이 벌어지는가?</li>

- 어떤요청? 동시 예약? 동시 취소?
- 동시 예약이 발생할 경우 UNIQUE 조건으로 방지됨.
- 동시 취소가 발생할 경우 삭제는 정상적으로 진행
- 하지만 대기의 승급에서 중복 동작이 발생해 같은 값으로 예약 2개 가능,
- 트랜잭션으로 묶어서 방지해야 할 동시성 이슈

<p>추가</p>

<li>자동/수동 중 내 선택과 이유 1줄</li>

- 자동. 실험 과정에 남겼듯이 자동 선택의 이점이 단점보다 뛰어나서

<li>묶기로 한 변경 / 따로 처리하기로 한 변경의 경계와 그 이유</li>

- 예약 대기처럼 후속 작업이 존재하는 변경만 묶어서 처리
- 그 외의 변경 쿼리는 단일 동작으로 처리

</ul>

---

### Q. 토론에서 가장 묻고 싶은 질문 1개는 무엇인가요?

    동시성 이슈를 고려할 부분이 많은가?  
    동시성 이슈를 효과적으로 핸들링하는 것이 맞는가?
    동시성 이슈를 최소화하는 것이 맞는가? 
