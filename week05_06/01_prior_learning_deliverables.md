## **산출물**

- [x] 설계 초안 (자료구조, 클래스 구상)

```mermaid

class Board - 게임판을 관리, 기물의 좌표와 이동을 관리
    // Pieces pieces - 기물들의 위치를 관리하는 일급 컬렉션 : 그냥 통합
    Map<Piece, Position> piecePositions
    // void choice(String  label) - 특정 기물을 선택, 이동 가능 위치 표시
    // void move(String  label, int x,int y) - 특정 위치의 기물을 이동
    // void capture(String  label, int x,int y) - 특정 위치의 기물을 포기(捕棋)
    Board() - 초기 상태를 생성하고 그 값으로 위치 초기화
    // Board(Map<Piece, Position> piecePositions) - 저장된 값, 변경된 값으로 초기화
    
abstract class Piece - 기물의 라벨, 이동을 관리
    String label - 동일 기물도 특정하기 위한 별도의 이름
    // abstract List<Position> movablePositions() - 이동 가능한 좌표들 리턴
    
class <T> extends Piece
    List<MovementRule> movementRules - 해당 기물의 이동 규칙(이동 경로의 리스트) 
    // @Override List<Position> movablePositions() - 해당 기물의 이동 가능한 좌표를 리턴

```

- [x] 상태 관리 책임에 대한 내 의견
- [x] 기물별 이동 규칙 정리표
- [x] 예상 조건문 개수와 문제점
- [x] 조건문 없이 처리하는 방법에 대한 아이디어
