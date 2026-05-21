<div class="max-width-md mx-auto pt-10 px-5"><h1 class="display-2 pt-5 pb-7 text-bold">방탈출 예약 대기</h1> <div class="mt-5"><div><div class="tui-editor-contents"><h1>학습 목표</h1>
<ul>
<li class="task-list-item" data-te-task="">
<p><strong>복잡한 도메인을 모델링하고 구현</strong></p>
<ul>
<li class="task-list-item" data-te-task="">도메인에 새로운 상태 개념을 추가하고, 상태 전이 규칙을 코드로 표현할 수 있다.</li>
<li class="task-list-item" data-te-task="">새 개념을 기존 도메인에 통합할지 분리할지 데이터 모델링 관점에서 판단할 수 있다.</li>
<li class="task-list-item" data-te-task="">다른 변동에 따라 재정렬되는 순서·순번 데이터를 관리할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>트랜잭션 경계를 판단하고 적용</strong></p>
<ul>
<li class="task-list-item" data-te-task="">@Transactional을 사용해 여러 데이터 변경을 하나의 작업 단위로 묶을 수 있다.</li>
<li class="task-list-item" data-te-task="">어떤 작업을 하나의 트랜잭션으로 묶을지 자기 기준으로 판단할 수 있다.</li>
<li class="task-list-item" data-te-task="">트랜잭션 실패 시에도 데이터 일관성이 유지되도록 대응할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>웹 애플리케이션의 테스트 전략을 수립하고 적용</strong></p>
<ul>
<li class="task-list-item" data-te-task="">단위 테스트·통합 테스트·E2E 테스트가 각각 무엇을 검증하는지 구분해 설명할 수 있다.</li>
<li class="task-list-item" data-te-task="">DB 연동 코드를 어떻게 테스트할지(실제 DB / 인메모리 / Mock) 자기 기준으로 선택해 적용할 수 있다.</li>
<li class="task-list-item" data-te-task="">@SpringBootTest, @WebMvcTest 등 Spring이 제공하는 테스트 도구를 상황에 맞게 사용할 수 있다.</li>
<li class="task-list-item" data-te-task="">무엇을 테스트하지 않을지(비용 대비 가치)도 자기 기준으로 결정할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>사용자 관점에서 엣지 케이스를 식별하고 처리</strong></p>
<ul>
<li class="task-list-item" data-te-task="">요구사항에 명시되지 않은 엣지 케이스를 스스로 식별하고 코드로 처리할 수 있다.</li>
<li class="task-list-item" data-te-task="">작업 실패 시 사용자에게 어떤 응답·상태를 보여줄지 자기 기준으로 결정할 수 있다.</li>
<li class="task-list-item" data-te-task="">시스템 상태 변경을 사용자에게 알리는 방식(알림 여부 자체 포함)을 자기 기준으로 결정할 수 있다.<br>
<br></li>
</ul>
</li>
<li class="task-list-item" data-te-task="">
<p><strong>자기만의 학습 방법을 정리</strong></p>
<ul>
<li class="task-list-item" data-te-task="">미션을 거치며 다듬어온 학습법을 자기만의 형태로 정리할 수 있다.</li>
<li class="task-list-item" data-te-task="">새로운 기술이나 문제 영역을 만났을 때 어떻게 접근할지 자기 기준이 있다.</li>
</ul>
</li>
</ul>
<h1>저장소</h1>
<ul>
<li><a href="https://github.com/woowacourse/spring-roomescape-waiting">https://github.com/woowacourse/spring-roomescape-waiting</a></li>
</ul>
<h1>이 미션이 끝났을 때</h1>
<blockquote>
<p>아래의 질문에 대한 자신의 생각을 드러낼 수 있어야 한다.</p>
</blockquote>
<ol>
<li>예약 대기 기능을 설계할 때 가장 중요하게 고려한 요소는 무엇인가요? 현재 설계에서 문제가 발생할 가능성이 있는 부분이 있다면, 어떤 상황에서 문제가 될 수 있는지 분석하고, 이를 해결할 수 있는 방법을 제안해주세요.</li>
<li>여러 데이터가 함께 변경되어야 하는 작업이 있을 때, 이 변경들을 하나의 작업 단위로 묶을지, 분리할지 어떻게 판단했나요? 중간에 실패할 경우 어떤 일이 벌어지는지 인지하고 어떻게 대응했는지 함께 적어주세요.</li>
<li>이번 미션에서 선택한 테스트 방식과 그 이유를 설명해주세요. 테스트를 통해 검증하고자 했던 핵심 요소는 무엇이었나요? 선택한 테스트 방식이 나의 테스트 목적을 달성하는 데 효과적이었나요?</li>
<li>예약 대기 시스템에서 상태가 변할 때(승인·거절·순번 변동) 사용자에게 알릴지, 어떤 방식으로 알릴지를 자기 기준으로 결정해보았나요? 또는 작업이 실패했을 때 사용자에게 어떤 응답·상태를 보여줄지 어떤 기준으로 결정했나요? 그렇게 결정한 이유를 적어주세요.</li>
<li>앞으로 새로운 기술(e.g.새로운 프로그래밍 언어, 새로운 프레임워크 등)을 학습해야 할 때, 이를 효과적으로 익히기 위해 어떻게 접근할 것인가요?</li>
</ol>
</div></div></div></div>
