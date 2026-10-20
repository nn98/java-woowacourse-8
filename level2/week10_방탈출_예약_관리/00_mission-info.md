<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">방탈출 사용자 예약</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>미션 소개</h1>
<ul>
<li>새로운 요구사항을 반영하며 방탈출 예약 애플리케이션을 발전시켜 나간다.</li>
<li>사용자가 직접 방탈출 예약을 할 수 있도록 기능 및 클라이언트를 제공한다.</li>
<li>랭킹, 조건 검색 등을 위한 쿼리를 작성하고, API로 제공한다.</li>
</ul>
<h1>학습 목표</h1>
<ul>
<li class="task-list-item" data-te-task="">
<p><strong>HTTP 프로토콜에 대한 이해와 구현</strong></p>
<ul>
<li class="task-list-item" data-te-task="">HTTP 프로토콜의 HTTP 메소드, 요청과 응답 헤더, 상태 코드 등의 요소가 무엇인지 안다.</li>
<li class="task-list-item" data-te-task="">다양한 HTTP 메서드(GET, POST, PUT, DELETE)의 용도와 차이점을 이해하고 설명할 수 있다.</li>
<li class="task-list-item" data-te-task="">HTTP 상태 코드(200, 404, 500 등)의 의미와 적절한 사용 상황을 이해하고 적용할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>요청에 대한 API를 설계하고 구현</strong></p>
<ul>
<li class="task-list-item" data-te-task="">리소스 중심의 API 설계 방법을 이해하고, URI를 통해 리소스를 표현하는 방법을 설명할 수 있다.</li>
<li class="task-list-item" data-te-task="">Spring MVC가 제공하는 어노테이션을 사용해서 API 설계에 맞는 요청을 받고 응답할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>필요한 데이터 조회를 위한 쿼리 작성</strong></p>
<ul>
<li class="task-list-item" data-te-task="">다양한 데이터 필터링 조건(WHERE, AND, OR, IN, NOT IN)을 사용하여 데이터를 정확하게 조회할 수 있다.</li>
<li class="task-list-item" data-te-task="">JOIN (INNER, LEFT, RIGHT, FULL)을 사용하여 여러 테이블 간의 관계를 이해하고, 관련된 데이터를 결합하여 조회할 수 있다.</li>
<li class="task-list-item" data-te-task="">GROUP BY와 함께 집계 함수(COUNT, SUM, AVG, MAX, MIN)를 사용하여 그룹화된 데이터의 요약 정보를 추출할 수 있다.</li>
<li class="task-list-item" data-te-task="">ORDER BY를 사용하여 쿼리 결과를 특정 기준에 따라 정렬할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>테스트 도구를 사용해서 웹 요청/응답에 대해 자동으로 검증</strong></p>
<ul>
<li class="task-list-item" data-te-task="">개발한 기능을 테스트를 사용해 자동으로 검증할 수 있다.</li>
<li class="task-list-item" data-te-task="">다양한 HTTP 메서드를 사용하는 요청을 보내고, 응답을 검증할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>다양한 학습 자원을 의식적으로 활용</strong></p>
<ul>
<li class="task-list-item" data-te-task="">자료·코드·AI·동료·다른 서비스 등을 학습 단계에 맞게 선택해 활용할 수 있다.</li>
<li class="task-list-item" data-te-task="">각 자원의 한계를 인식하고 다른 자원으로 보완할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>자기 학습법의 강점·약점 진단</strong></p>
<ul>
<li class="task-list-item" data-te-task="">어떤 상황에서 내 학습법이 잘 통하고 안 통하는지 구체적으로 짚을 수 있다.</li>
<li class="task-list-item" data-te-task="">약점을 보완할 구체 전략을 시도하고 효과를 평가할 수 있다.</li>
</ul>
</li>
</ul>
<h1>저장소</h1>
<ul>
<li><a href="https://github.com/woowacourse/spring-roomescape-member" target="_blank">https://github.com/woowacourse/spring-roomescape-member</a></li>
</ul>
<h1>이 미션이 끝났을 때</h1>
<blockquote>
<p>아래의 질문에 대한 자신의 생각을 드러낼 수 있어야 한다.</p>
</blockquote>
<ol>
<li>HTTP 프로토콜이란 무엇이며, 어떤 특성을 가지고 있나요? 이러한 특성이 미션 구현에 어떤 영향을 미쳤나요? 구체적인 사례를 들어 설명해주세요.</li>
<li>좋은 웹 API는 무엇이라고 생각하나요? API를 설계할 때 RESTful 원칙을 어떻게 적용했나요? 이번 미션에서 구현한 API로 예시를 들어 설명해주세요.</li>
<li>에러 처리를 설계할 때 어떤 기준을 고려했나요? 에러 응답에 포함해야 할 정보는 어떤 무엇이며, 이를 포함하는 이유는 무엇인가요?</li>
<li>API 테스트를 작성할 때, 단순 요청-응답 검증 외에 어떤 부분(예: 예외 상황, 인증, 성능, 보안 등)을 추가로 고려했나요? 이번 미션에서 테스트를 작성한 기준을 예시로 들어 설명해주세요.</li>
<li>이번 미션을 진행하며 자신의 학습법을 어떻게 다뤄왔나요? 어떤 학습 자원(자료·코드·AI·동료·다른 서비스 등)을 어떻게 활용했고, 그 과정에서 자기 학습법의 어떤 강점과 약점이 드러났나요? 발견한 약점을 보완하기 위해 시도한 전략과 그 효과를 함께 적어주세요.</li>
</ol>
</div></div></div></div>