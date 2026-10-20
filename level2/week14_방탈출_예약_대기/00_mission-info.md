<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">🚀 사이클2 - 미션 (예약 대기 승인)</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>사이클2: 미션 (예약 대기 승인)</h1>
<blockquote>
<p><strong>트랜잭션 경계 규칙을 적용하면서 예약 대기를 승인해 예약으로 전환하고, 예약 대기 순번을 재정렬한다.</strong></p>
</blockquote>
<hr>
<h2>진행 방식</h2>
<ul>
<li>미션은 <strong>과제 진행 요구 사항</strong>, <strong>기능 요구 사항</strong>, <strong>프로그래밍 요구 사항</strong> 세 가지로 구성되어 있다.</li>
<li>세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋하는 방식으로 진행한다.</li>
<li><strong>기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.</strong> 이번 사이클은 자동 전환·수동 승인 중 어떤 방식을 선택할지, 어디까지를 하나의 트랜잭션으로 묶을지를 직접 결정한다.</li>
</ul>
<hr>
<h2>목표</h2>
<p>단순히 대기 승인 기능을 만드는 것이 아니라, <strong>"이 작업들이 왜 함께 일어나야 하는가"의 판단 근거를 가지는 것</strong>이 핵심이다.</p>
<ul>
<li>이번 토론 활동에서 정한 <strong>트랜잭션 경계 규칙을 코드에 적용</strong>한다.</li>
<li>트랜잭션 경계 결정마다 <strong>"왜 이것들을 함께 묶었는가/분리했는가"</strong> 를 PR 본문에 한두 줄로 남긴다.</li>
<li>지금까지 쌓아온 규칙(API 설계, 에러 처리, 테스트 전략)을 이 기능에 통합 적용한다.</li>
</ul>
<hr>
<h2>기능 요구 사항</h2>
<p>지금까지는 사용자가 본인의 예약과 대기를 관리할 수 있었지만, <strong>대기는 영원히 대기로 머무른다</strong>. 이번 사이클부터는 대기를 예약으로 <strong>전환</strong>하는 흐름을 추가하고, 전환·취소 시 슬롯의 <strong>대기 순번이 재정렬</strong>되도록 한다.</p>
<p>이번 사이클의 작업도 <strong>백엔드 API 추가/변경</strong>과 <strong>사용자가 보는 화면</strong>을 함께 진행한다. API에 맞춰 사용자가 사용하는 클라이언트 화면을 만들고, 대기 전환과 순번 재정렬이 화면에서 사용자에게 자연스럽게 보이는 것까지 확인한다. 화면 작성에는 AI를 활용해도 좋다.</p>
<h3>1단계 - 예약 대기 승인</h3>
<ul>
<li>예약 대기를 승인하여 예약으로 전환한다.
<ul>
<li><strong>자동 전환</strong>(예약 취소 시 대기 1번이 자동으로 예약 전환) 또는 <strong>수동 승인</strong>(관리자가 대기를 확인하고 승인/거절) 중 직접 선택해 구현한다.</li>
</ul>
</li>
<li>대기가 예약으로 전환되면 해당 슬롯의 <strong>나머지 대기 순번이 재정렬</strong>된다.</li>
<li>예약이 취소되면 해당 슬롯의 <strong>대기 순번이 재정렬</strong>된다.</li>
<li>요구사항에 명시되지 않은 엣지 케이스를 스스로 식별하고 처리한다.</li>
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
<li>이번 사이클에서 구현한 API에 대한 요구사항 테스트를 작성한다.</li>
<li><strong>테스트 전략에 맞춰 단위·통합 테스트 범위</strong>를 결정해 테스트를 작성한다.</li>
</ul>
<h3>추가된 요구 사항</h3>
<ul>
<li>토론에서 정한 <strong>트랜잭션 경계</strong>에 맞춰 함께 일어나야 하는 데이터 변경을 묶고, 중간 실패 시 데이터 일관성이 유지되는지 테스트로 확인한다.</li>
</ul>
<hr>
<h2>과제 진행 요구 사항</h2>
<ul>
<li>구현을 시작하기 전에 <strong>기능 요구 사항을 분석하여 기능 목록을 정리</strong>한다.</li>
<li>README.md 파일에 구현할 기능 목록과 <strong>자기 API 명세</strong>를 정리해 추가한다.</li>
<li>Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
<ul>
<li><a href="https://gist.github.com/stephenparish/9941e89d80e2bc58a153">AngularJS Git Commit Message Conventions</a> 참고해 커밋 메시지를 작성한다.</li>
</ul>
</li>
<li>PR 본문에 <strong>트랜잭션 경계 결정</strong>, <strong>자동 전환·수동 승인 중 선택</strong>과 각각의 이유를 한두 줄씩 남긴다.</li>
</ul>
<hr>
<h2>미션 중 할 일</h2>
<ol>
<li>토론 활동에서 정한 트랜잭션 경계 규칙을 의식하며 코드 작성</li>
<li>지금까지의 규칙이 이번 기능에 적용되는/적용되지 않는 순간 기록</li>
<li>스스로 식별한 엣지 케이스와 처리 방향 기록</li>
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