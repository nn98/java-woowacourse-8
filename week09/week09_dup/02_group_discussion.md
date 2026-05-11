<details><summary><h2>미션</h2></summary>

<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">📘 토론 활동</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>미션1: 토론 활동</h1>
<blockquote>
<p><strong>동료와 함께 학습법을 공유하고, 시도해보고, AI 피드백까지 받아 다듬는다.</strong></p>
</blockquote>
<hr>
<h2>토론 활동 규칙</h2>
<ul>
<li>이번 토론 활동은 이전 미션의 사이클과 달리 "그룹 규칙"을 만드는 자리가 아니라, <strong>각자가 자기 학습법을 다듬는 자리</strong>다.</li>
<li>동료의 학습법에 대한 <strong>조언을 쏟지 않는다</strong>. 동료의 배경 지식과 맞는 학습 방법은 나와 다를 수 있다.</li>
<li>동료의 학습법을 <strong>평가하지 않는다</strong>. 질문하고 관점을 나눈다.</li>
</ul>
<hr>
<h2>진행 방식 (3인 페어)</h2>
<blockquote>
<p><strong>시간은 기준일 뿐이다.</strong> 레벨1 토론이 그랬듯이, 3인 페어가 상황에 맞게 유연하게 조정한다.</p>
</blockquote>
<table>
<thead>
<tr>
<th>활동</th>
<th>권장 시간</th>
<th>형태</th>
<th>내용</th>
</tr>
</thead>
<tbody>
<tr>
<td>오프닝</td>
<td>~10분</td>
<td>마을 with 코치</td>
<td>레벨2 OT, 학습법을 학습해야 하는 이유</td>
</tr>
<tr>
<td><strong>활동 A</strong></td>
<td>~25분</td>
<td><strong>3인 페어</strong></td>
<td>레벨1 학습법(v1) 공유 + 함께 다듬기</td>
</tr>
<tr>
<td><strong>활동 B</strong></td>
<td>~45분</td>
<td><strong>개인</strong></td>
<td>다듬은 학습법(v2) 시도 → 회고 → AI 피드백 → 학습법 마무리</td>
</tr>
<tr>
<td><strong>활동 C</strong></td>
<td>~10분</td>
<td><strong>3인 페어</strong></td>
<td>마무리한 학습법(v3) 공유</td>
</tr>
</tbody>
</table>
<hr>
<h3>활동 A — 레벨1 학습법(v1) 공유 + 함께 다듬기</h3>
<ol>
<li>각자 사전학습에서 가져온 <strong>레벨1 학습법(v1) + 충돌 지점</strong>을 페어에게 설명한다.</li>
<li>동료는 "왜 그게 충돌 지점이라고 생각하세요?"로 파고든다.</li>
<li>PiFSR 5원칙과 나선형 학습을 참고하여, <strong>학습법을 함께 개선한다</strong>.</li>
</ol>
<p><strong>산출물</strong>: <strong>각자의 다듬은 학습법 v2</strong></p>
<hr>
<h3>활동 B — 개인 학습 시도 (같은 공간)</h3>
<blockquote>
<p>같은 공간에 모여 있지만 각자 집중한다. 막히면 그룹에게 물어보는 것은 자유.</p>
</blockquote>
<ol>
<li>하나의 학습 주제를 선택해 <strong>다듬은 학습법으로 작은 학습을 시도한다.</strong> (20 min)
<ul>
<li>학습 주제는 <strong>코딩이 아니라 개념 이해, 구조화</strong>를 할 수 있는 것으로 고른다.</li>
<li>Claude Code skills, sub-agent, Gradle 기본 개념 (task, dependency), SOLID 원칙, HTTP 상태 코드 설계 등</li>
<li>예: "@Controller가 뭔지 내 방식으로 알아본다"</li>
</ul>
</li>
<li><strong>아래의 질문에 답하며 학습법 v2에 대한 회고를 진행한다.</strong>
<ul>
<li>학습법이 어디서 잘 동작하였고</li>
<li>어디서 잘 동작하지 않았는가?</li>
<li>왜 그런가?</li>
</ul>
</li>
<li><strong>아래 프롬프트를 사용하여 AI의 도움을 받아 학습법을 한 번 더 개선한다.</strong></li>
<li><strong>AI 피드백을 반영해 학습법 v3를 만든다.</strong></li>
</ol>
<h4>AI 학습 전문가 프롬프트</h4>
<h5>1. 학습 전문가 소개 받기</h5>
                <pre id="default-onx76iuvms" class="hljs-code-block overflow-hidden relative d-flex mt-3 mb-8">                    <button type="button" class="clipboard-btn v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--default absolute right-10 top-10 z-1 grey--text text--darken-3">
                      <span class="v-btn__content">
                        <i aria-hidden="true" class="v-icon notranslate mdi mdi-clipboard theme--light"></i>
                      </span>
                    </button>
                    <code class="relative pa-4 lh-1-3 text-normal width-100 ls-0
                   language-plaintext hljs">[지침] 
새로운 기술을 효율적으로 학습할 수 있도록 하는 방법을 탐구 중입니다. 기술 학습에 대한 실용적인 인사이트를 제공할 수 있는 교육/학습 분야의 전문가 5인을 소개해주세요.
[맥락]
저는 웹프론트엔드 개발 분야를 학습하고 있는 학생입니다.
</code>
</pre>
<h5>2. 여러 전문가에게 나의 학습 방법 피드백 받기</h5>
                <pre id="default-j7vfdfwnku" class="hljs-code-block overflow-hidden relative d-flex mt-3 mb-8">                    <button type="button" class="clipboard-btn v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--default absolute right-10 top-10 z-1 grey--text text--darken-3">
                      <span class="v-btn__content">
                        <i aria-hidden="true" class="v-icon notranslate mdi mdi-clipboard theme--light"></i>
                      </span>
                    </button>
                    <code class="relative pa-4 lh-1-3 text-normal width-100 ls-0
                   language-plaintext hljs">[지침] 
저는 새로운 기술을 학습할 때, 맥락에서 제시한 바와 같이 학습해왔습니다. 학습 전문가로서, 이 학습 방법의 장단점을 분석해주세요. 그리고 학습 효율을 높이기 위해서 딱 하나만 개선하려고 합니다. 시도 회고에 근거하여 개선점을 구체적으로 제안해주세요. 전문가로서 멘탈 모델을 기반으로 개선안을 제안해주세요.
[역할]
당신은 {전문가 이름} 입니다. 학습, 교육에 전문성이 있습니다.
[맥락]
{학습법 v2}
{학습법 v2에 대한 회고}
</code>
</pre>
<h6>3. 새로운 학습 방법론 제안 받기</h6>
                <pre id="default-dgvafgjxfd" class="hljs-code-block overflow-hidden relative d-flex mt-3 mb-8">                    <button type="button" class="clipboard-btn v-btn v-btn--flat v-btn--icon v-btn--round theme--light v-size--default absolute right-10 top-10 z-1 grey--text text--darken-3">
                      <span class="v-btn__content">
                        <i aria-hidden="true" class="v-icon notranslate mdi mdi-clipboard theme--light"></i>
                      </span>
                    </button>
                    <code class="relative pa-4 lh-1-3 text-normal width-100 ls-0
                   language-plaintext hljs">[지침]
새로운 기술을 효율적으로 학습하는 방법을 탐구하려고 합니다. 웹 프론트엔드 개발자로서 제가 기존에 시도하지 않았지만, 훨씬 더 학습 효과를 올리기 위해서 어떤 학습 방법을 시도하면 좋을지 3가지를 제안해주세요. 그것이 효과적인 이유를 전문가로서의 멘탈 모델과 함께 보여주세요.
[역할]
당신은 {전문가 이름} 입니다. 학습, 교육에 전문성이 있습니다.
</code>
</pre>
<hr>
<h3>활동 C — 마무리한 학습법(v3) 공유</h3>
<ul>
<li>각자 "마무리한 학습법이 뭐고, 이전에서 뭘 바꿨는지" 를 페어에게 공유한다.</li>
<li>동료는 "이 학습법으로 수요일 해봤을 때 이런 어려움이 있을 것 같다"를 한 마디씩 나눈다.</li>
</ul>
<hr>
<h2>토론 활동 결과물</h2>
<ul>
<li><strong>학습법 v2</strong> (활동 A): PiFSR·나선형을 적용한 학습법 초안</li>
<li><strong>학습법 v3</strong> (활동 B~C): 작은 시도 + AI 피드백을 반영한 학습법</li>
</ul>
<hr>
<h2>토론 활동 종료 조건</h2>
<ul>
<li class="task-list-item" data-te-task="">학습법 v2와 학습법 v3이 있다</li>
</ul>
<hr>
<h2>산출물</h2>
<blockquote>
<p>토론 활동 산출물의 제출은 토론 당일(화요일) 18:00까지 완료한다.<br>
산출물은 <a href="https://techcourse-lms-plus-web.woowahan.com/crew">LMS+</a> 에 제출한다.</p>
</blockquote>
<ul>
<li class="task-list-item" data-te-task="">개인 학습 주제와 회고 내용</li>
<li class="task-list-item" data-te-task="">오늘 마무리한 학습법 (학습법 v3)</li>
</ul>
</div></div></div></div>

</details>

# 📖 웹앱과 학습법 튜닝 (방탈출 예약 관리)

## 🚀 미션 2-1 : 방탈출 예약 관리

---

# `2. 토론`

1. 
2. 
3. 
4. 

```

```

---

- 글렌

---

- 보예

---

- 캐모

---

- 우디

---

> 컨벤션 > 역할 분리 > 로직

1. 테스트 단위 기준
   가장 작은 단위, 메소드

2. 테스트 제외 기준
   IO 테스트, 중복되거나 하위 부분

3. 테스트 어려움 대응
   기능 분리와 역할 이관

4. 리팩터링 우선 순위
   컨벤션/규칙 > 역할 분리 > 세부 로직
