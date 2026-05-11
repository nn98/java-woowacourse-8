<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">웹앱과 학습법 튜닝 (방탈출 예약 관리)</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>미션 소개</h1>
<ul>
<li>방탈출 예약을 관리할 수 있는 웹 애플리케이션 API를 만든다.</li>
<li>예약 기능을 1~4단계로 나누어 단계적으로 쌓아가는 경험을 한다.</li>
<li>구현한 기능을 테스트를 통해 검증한다. 브라우저 화면은 이번 미션에서 만들지 않는다.</li>
<li>개인 미션으로 진행하며, 스프링을 처음 만나는 이 한 주를 자기 학습법을 의식적으로 돌아보고 튜닝하는 기회로 삼는다.</li>
</ul>
<h1>학습 목표</h1>
<ul>
<li class="task-list-item" data-te-task="">
<p><strong>스프링부트 프레임워크를 사용해 웹 요청을 받고 응답하기</strong></p>
<ul>
<li class="task-list-item" data-te-task="">URL과 HTTP Method에 따라 이를 처리할 컨트롤러 메서드를 매핑할 수 있다.</li>
<li class="task-list-item" data-te-task="">어노테이션을 사용해 HTTP 요청에 포함된 request parameter, request body를 컨트롤러 메서드에 바인딩할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>웹 애플리케이션에서 DB에 데이터를 저장하고 조회하기</strong></p>
<ul>
<li class="task-list-item" data-te-task="">application.properties 또는 application.yml 파일에서 데이터 베이스 연동에 필요한 정보를 설정 할 수 있다.</li>
<li class="task-list-item" data-te-task=""><code data-backticks="1">JdbcTemplate</code> 을 사용하여 SELECT, INSERT, UPDATE, DELETE 쿼리를 작성하고 실행할 수 있다.</li>
<li class="task-list-item" data-te-task="">Inmemory DB가 무엇인지 이해하고, 애플리케이션 개발에 사용할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>스프링 빈의 의존성 주입이 무엇인지 알고, 코드에 적용</strong></p>
<ul>
<li class="task-list-item" data-te-task="">어노테이션을 사용해 스프링이 관리할 객체를 설정할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>소프트웨어 개발에 일반적으로 적용되는 계층형 아키텍쳐(Layered Architecture)를 알고, 코드에 적용</strong></p>
<ul>
<li class="task-list-item" data-te-task="">예약 관리 애플리케이션에 계층형 아키텍처를 적용해본다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>로컬 환경(localhost)에서 웹 애플리케이션을 실행 및 테스트</strong></p>
<ul>
<li class="task-list-item" data-te-task="">작성한 API를 테스트 코드 또는 HTTP 클라이언트(Postman, IntelliJ HTTP Client 등)로 호출해 응답을 검증할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>자기 학습법을 의식적으로 설계하고 튜닝</strong></p>
<ul>
<li class="task-list-item" data-te-task="">지금까지 내가 써온 학습법을 돌아보고, 충돌 지점을 구체적으로 짚을 수 있다.</li>
<li class="task-list-item" data-te-task="">PiFSR 5원칙과 나선형 학습을 내 학습법에 적용할 수 있다.</li>
<li class="task-list-item" data-te-task="">학습 로그를 작성하며 전략 → 시도 → 평가 → 조정 루프를 반복할 수 있다.</li>
</ul>
</li>
</ul>
<h1>저장소</h1>
<ul>
<li><a href="https://github.com/woowacourse/spring-roomescape-admin" target="_blank">https://github.com/woowacourse/spring-roomescape-admin</a></li>
</ul>
<h1>이 미션이 끝났을 때</h1>
<blockquote>
<p>아래의 질문에 대한 자신의 생각을 드러낼 수 있어야 한다.</p>
</blockquote>
<ol>
<li>웹 클라이언트와 웹 서버란 각각 어떤 역할을 하는 존재인가요? 둘은 어떤 방식(프로토콜)을 통해 통신하며, 요청-응답 과정에서 어떤 정보들이 오고 가나요?<br>
실제로 웹 브라우저에 URL을 입력했을 때 어떤 단계를 거쳐 최종 화면이 렌더링되는지, 자신이 이해한 흐름을 단계별로 설명해보세요.</li>
<li>미션에서 계층형 아키텍처를 적용할 때, 각 계층(Controller, Service, Repository 등)이 어떤 역할을 맡도록 설계했나요? 계층 간의 의존 관계는 적절했다고 생각하나요? 만약 개선할 점이 보인다면 어떤 부분을 어떻게 바꾸고 싶은지 구체적으로 설명해주세요.</li>
<li>Spring Boot가 웹 애플리케이션 개발에서 구체적으로 어떤 문제들을 해결해 주었나요? 웹앱을 구현할 때 웹 프레임워크의 도움을 받았다면, 어떤 기능이 도움이 되었는지 실제로 경험한 사례를 소개해주세요.</li>
<li>In-memory DB를 사용했는데, 실제 개발 환경이나 운영 환경에서는 어떤 데이터베이스를 사용할 계획인가요? 선택한 DB를 사용하려는 이유를 적어주세요.</li>
<li>나만의 학습방법을 찾기 위해, 기존의 학습 스타일에서 벗어나 레벨2에서 새롭게 시도한 방식이 있다면 무엇인가요? 현재까지 경험한 학습 방법 중 효과적이었다고 생각하는 방식은 무엇인가요?</li>
</ol>
</div></div></div></div>