### Q. 본인 브랜치의 방탈출 미션 코드는 동작 가능한 상태인가요? 본인 코드의 구조를 한눈에 설명할 수 있나요?

네.  
요구사항을 충족하고, 테스트가 정상 실행되며, 명세된 API가 모두 동작합니다.

네.  
애그리거트 루트 개념을 도입하다 실패한 구조라 독립된 루트들의 진입점이 Session 으로 통일되어 있고,  
SessionService가 ApplicationService 역할을 수행하며 다른 서비스들을 조율하고 있으나  
도메인 객체는 Session 이 Reservation 과 Waiting 에 필드로 참조되고 있는 구조입니다.

### Q. 방탈출 미션 코드 중 JPA 전환에서 건드릴 부분과 그대로 둘 부분의 경계를 적어주세요. 무엇을 바꿀 예정이고 무엇은 유지할 예정인가요?

lazy-loading 이랑 N+1 때문에 변경하지 못했던 참조 관계 역전(예약 > 세션 → 예약 < 세션)을 진행하고  
객체 기반 참조 구조나 이를 기반으로 한 도메인 객체 매핑 로직은 유지  
쿼리를 직접 작성했던 부분들을 추상화하고 은닉하는게 가장 큰 변경이지 않나

### Q. 본인 코드의 Repository에서 가장 자주 등장하는 SQL 패턴은 무엇인가요?

find > exist > save/update/delete 라 생각했는데

find/select 20  
save/delete 5 / 5  
update 3  
exists 2

실제는 위와 같이 압도적인 find, 소수의 exists. 빈발하는 패턴은 find/select

### Q. 객체 참조로 옮겼을 때 더 자연스러워지는 곳은 어디인가요?

식별자 기반 메서드들. 현재로선 SessionId 를 받는

    boolean isExistsBySessionId(long sessionId);

    Waiting findFirstBySessionId(long sessionId);

    List<Waiting> findAllBySessionId(long sessionId);

위 세개 메서드

---

# 매핑 변환

마스터 데이터(Theme, TimeSlot) 저장소를 JPA 로 변환

- 도메인 객체 엔티티화(어노테이션 추가, 가변 객체로 변경, NoArg 추가)
- 저장소 JpaRepository 상속, 기존 구현체 제거
- JpaRepository 기본 제공 메서드 외 기능은 개별 정의, 처리 로직 작성
    - 커스텀 컬럼값으로 조회 : 메서드 정의
    - 집계 + JOIN 쿼리 : SQL 작성
    - `DTO 반환 쿼리` : 프로젝션 처리 후 서비스에서 DTO 매핑
- update 메서드 save 의 merge 로 통합

## 읽기 전용 객체(DTO) 의 활용이 보편적인가?

현재 `예약 가능한 슬롯` 을 표현하기 위한 `AvailableTimeSlot` DTO 가 존재.  
저장소는 엔티티를 반환하다보니 DTO 반환으로는 못맞추나? 프로젝션으로 처리하고 서비스가 매핑

프로젝션이 필요한 구조라면 사용하지 않는 것이 바람직한걸까?

`배경과 근거, 방`  
JPA 엔티티는 JPA 영속성 컨텍스트의 관리를 받는다. 변경 감지(dirty checking)가 동작한다는 뜻.  
조회만 해서 전달할 용도인 읽기 객체의 책임을 엔티티로 처리하면 불필요한 관리 비용이 발생.  
CQS 측면에서도 읽기(Query)만 하면 될 기능에 쓰기(Command)에 사용되는 엔티티를 사용할 필요가 없다,

이 상황에서 JPA 가 읽기 로직을 엔티티 없이 처리하는 세 가지 방식이 존재.

- interface projection(현재)
- DTO projection (JPQL new)
- Class projection (record)

현재 방식을 채택한 이유는 해당 DTO의 구조 때문. JPQL 키워드가 나온 이상 아마 변경될 것 같지만  
방식의 변경이 필요한 것이지 읽기 객체 구조 자체의 문제는 아니라 보고, 더 합리적이고 바람직하다.

### Q. 예약 생성 시 콘솔에 찍히는 INSERT SQL이 방탈출 미션과 어떻게 같고 어떻게 다른가요?

