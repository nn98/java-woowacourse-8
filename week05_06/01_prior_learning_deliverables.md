# 📖 장기 미션

## 🚀 미션 2-1 : 장기

---

## **산출물**

- [x] 설계 초안 (자료구조, 클래스 구상)

```mermaid

class Board - 게임판을 관리, 기물의 `좌표`와 `이동`을 관리
    Map<Piece, Position> piecePositions
    Board() - 초기 상태를 생성하고 그 값으로 위치 초기화
    void choice(String  label) - 특정 기물을 선택, 이동 가능 `위치` 표시
    void move(String  label, int x,int y) - 특정 위치의 기물을 이동
    void capture(String  label, int x,int y) - 특정 위치의 기물을 포기(捕棋)
    // Board(Map<Piece, Position> piecePositions) - 저장된 값, 변경된 값으로 초기화 `DB`
    
abstract class Piece - 기물의 라벨, 이동을 관리
    String label - 동일 기물도 특정하기 위한 별도의 이름
    PieceType type - 기물의 종류(졸 포 차 상 마 사 장)
    abstract List<Position> movablePositions() - 이동 가능한 `위치`들
    
class <T> extends Piece - 기물의 구현체, 특정 기물 표현
    // 기물의 이동 규칙은 기물의 종류(PieceType) 안에서 관리
    @Override List<Position> movablePositions() - 해당 기물의 이동 가능 `위치`들
    
enum PieceType - 기물의 종류, 해당 기물의 이동 규칙 관리
    SOLDIER(new Movements()), ...

class Movements - 기물의 이동 규칙을, 이동 경로를 관리
    List<Direction> directions - 방향을 조합해 이동의 경로를 관리, == 이동 규칙
    List<Position> movablePositions()
    
enum Direction - 개별적인 이동의 모든 경우의 수(8방위) 관리
    E(1,0), 
    W(-1,0),
    ...

record Positon - 기물 및 빈 칸의 좌표 표현
    int x - 행 번호
    int y - 열 번호
    @Override equals(Position position) - 다른 좌표와의 비교

record BoardDTO - 배치된 게임판의 상태 전달
    List<List<String>> boardStatus
    BoardDTO from(Board board)
    BoardDTO of(Board board, List<Position> movablePositions)

class Player - 장기를 플레이할 사용자
    String nickname

class InputView - 필요한 입력을 파싱할 뷰
    List<String> readPlayerNicknames()
    List<Integer> readCoordinate()

```

```mermaid
classDiagram
    class Board {
        -Map~Piece, Position~ piecePositions
        +Board()
        +choice(label: String)
        +move(label: String, x: int, y: int)
        +capture(label: String, x: int, y: int)
    }

    class Piece {
        <<abstract>>
        -String label
        -PieceType type
        +movablePositions()* List~Position~
    }

    class ConcretePiece {
        +movablePositions() List~Position~
    }

    class PieceType {
        <<enumeration>>
        SOLDIER
        CHARIOT
        HORSE
    }

    class Movements {
        -List~Direction~ directions
        +movablePositions() List~Position~
    }

    class Direction {
        <<enumeration>>
        E
        W
        S
        N
        NE
        NW
        SE
        SW
    }

    class Position {
        <<record>>
        -int x
        -int y
        +equals(position: Position) boolean
    }

    class BoardDTO {
        <<record>>
        -List~List~String~~ boardStatus
        +from(board: Board)$ BoardDTO
        +of(board: Board, movablePositions: List~Position~)$ BoardDTO
    }

    class Player {
        -String nickname
    }

    class InputView {
        +readPlayerNicknames() List~String~
        +readCoordinate() List~Integer~
    }

    %% Relationships
    Board *-- Piece : contains
    Board *-- Position : uses
    Piece <|-- ConcretePiece : extends
    Piece *-- PieceType : has
    PieceType *-- Movements : has
    Movements *-- Direction : uses
    BoardDTO ..> Board : depends
    InputView ..> Player : creates/uses
```

  - 실행 흐름 
    - Board() 초기화. 기본값(원래 장기 배치) 에 맞춰 초기 상태 생성 `Map<Piece, Position> piecePositions`
    - 생성된 게임판의 초기 상태를 출력 `BoardDTO`
    - 플레이할 사용자들 닉네임 입력 `Player`
    - 각 플레이어의 턴 교대로 반복 
      - 게임판 상태 출력 `BoardDTO`
      - 이동할 기물 선택 `String label`
      - 기물의 이동 가능한 위치 `List<Positon>` 을 반영해 출력 `BoardDTO`
      - 이동할 위치 선택 `String input` -> `int x` / `int y`
      - 이동한 결과 반영 `Board`
      - 이동한 결과 출력 `BoardDTO`
    - 게임판에 장이 1개가 될 때 까지 반복 

---

- [x] 상태 관리 책임에 대한 내 의견
- [x] 기물별 이동 규칙 정리표
- [x] 예상 조건문 개수와 문제점
- [x] 조건문 없이 처리하는 방법에 대한 아이디어
