# CodeSquad_15puzzle

--- 

## 1. V1 전략
1. 1-8 까지의 숫자를 가진 배열 생성
2. 위 배열을 무작위로 섞는다
3. 배열 출력
4. 사용자로부터 두 숫자 입력받음
5. 입력받은 두 숫자의 자리를 교환
6. 만약 배열이 오름차순으로 정렬?

   yes. 종료

   no. 3번으로

## 사용할 클래스
--- 
## Puzzle
  ### variables
  - puzzle
    - type : List\<Integer\>
    - 1-8까지의 숫자 배열을 저장(랜덤하게 섞여있음)
  - answer
    - type : final List\<Integer\>
    - 1-8까지 오름차순으로 정렬된 배열 저장(final)
    - 정답인지 확인하기 위해
  ### methods
  - constructer()
    - puzzle과 answer초기화
    - puzzle shuffle도 이때 수행
  - change(num1, num2)
    - parameter : int, int
    - return : void
    - num1과 num2숫자의 자리를 바꿈
  - checkIsSorted()
    - parameter : none
    - return : boolean
    - member variable로 가지고 있는 정답 배열과 현재 배열을 비교하여 모두 같으면 true, 아니면 false
- getPuzzle()
  - parameter : none
  - return List\<Integer>
  - 현재 퍼즐을 복사해서 반환해주는 메서드


## Game
### variables
- br
  - type : final BufferedReader
  - 유저의 입력을 받기위한 스트림 변수
- puzzle
  - type : final Puzzle
  - Puzzle클래스의 객체

### methods
- doGame()
  - parameter : none
  - return : void
  - throws : IOException, NumberFormatException
  - 게임의 진행을 총괄하는 메서드
- userInput()
  - parameter : none
  - return : List\<Integer>
  - throws : IOException, NumberFormatException
  - 유저의 입력을 받는 메서드
  - 잘못된 입력 검사도 여기서함
    - parse메서드 활용
- parse(str)
  - parameter : String
  - return : List\<Integer>
  - throws : NumberFormatException
  - 유저의 입력을 파싱해서 숫자 두개로 파싱하는 메서드
  - List에 담아서 반환함
- printTurnAndPuzzle(turn)
  - parameter : int
  - return : void
  - 현재 turn과 puzzle배열을 출력해주는 메서드
- addPuzzleNums(sb)
  - parameter : StringBuilder
  - return : void
  - parameter로 받은 StringBuilder에 현재 퍼즐의 숫자를 형식에 맞추어 추가해주는 메서드
  

## Main
### methods
- main
  - paramter : String[]
  - return : void
  - throws : IOException, NumberFormatException
  - 프로그램의 시작점인 main메서드
  - Game객체를 만들어 게임을 시작한다


--- 
## 2. V2 전략
- 우선 V1의 코드를 재활용하기 위해 인터페이스를 활용할 예정

## 사용할 Interface
## Puzzle
- change(int, int)
  - parameter : int, int
  - return : void
  - 주어진 두 숫자의 자리를 바꿈
  - parameter로 0이 주어지면 숫자가 아닌 빈칸으로 인식
- checkIsSorted()
  - parameter : none
  - return : boolean
  - member variable로 가지고 있는 정답 배열과 현재 배열을 비교하여 모두 같으면 true, 아니면 false
- getPuzzle()
  - parameter : none
  - return List\<Integer>
  - 현재 퍼즐을 복사해서 반환해주는 메서드

## Game
- doGame()
  - parameter : none
  - return : void
  - throws : IOException, NumberFormatException
  - 게임의 진행을 총괄하는 메서드
- userInput()
  - parameter : none
  - return : List\<Integer>
  - throws : IOException, NumberFormatException
  - 유저의 입력을 받는 메서드
- printTurnAndPuzzle(turn)
  - parameter : int
  - return : void
  - 현재 turn과 puzzle배열을 출력해주는 메서드
- addPuzzleNums(sb)
  - parameter : StringBuilder
  - return : void
  - parameter로 받은 StringBuilder에 현재 퍼즐의 숫자를 형식에 맞추어 추가해주는 메서드

--- 
## 프로그램 흐름
1. 0-15의 수를 가진 배열 생성
2. 위 배열을 무작위로 섞음
3. 섞인 1차원 배열을 4*4의 2차원 배열로 만든다(0은 빈칸)
4. 사용자로부터 숫자 하나 입력받음
   1. 상하좌우에 빈칸(0)이 존재할 경우 5번으로
   2. 없을 경우 잘못된 입력이므로 4번으로
5. 빈칸(0)과 입력받은 숫자의 자리 교환
6. 만약 배열이 정렬?
   1. yes 종료
   2. no 4번으로

--- 
## 사용할 클래스
## PuzzleV2
### variables
- puzzle
  - type : List\<Integer>
  - 0-15까지의 숫자를 담고있는 4*4 2차원 배열
- answer
  - type : final List\<Integer>
  - 0-15까지의 숫자가 정렬된 4*4 2차원 배열

### methods
- Puzzle interface override한 메서드들
- constructer()
  - puzzle과 answer초기화
  - shuffle도 이때 수행
- canMove(int)
  - parameter : int, int[]
  - return : int[]
  - parameter로 받은 숫자의 상하좌우에 빈칸(0)이 있는지 확인
  - int[]는 받은 숫자의 index를 보관
  - 있으면 해당 좌표를 int배열에 담아서 보냄
  - 없으면 null반환
- findNumIndex(int)
  - parameter : int
  - return : int[]
  - parameter로 받은 숫자의 인덱스를 배열에 담아 return
  - length : 2, {row, col}형식
- inRange(int, int)
  - parameter : int, int
  - return : boolean
  - parameter로 받은 row, col이 0~3까지의 숫자인지 확인
- change()
  - parameter : int, int
  - return : void
  - parameter로 받은 두 숫자의 자리를 바꿈
  - V2에서는 parameter중 하나가 반드시 0이어야함
    - 아닐시 IllegalArgumentException
  - findNumIndex 메서드를 활용하여 움직일 숫자의 위치를 찾음


## GameV2
### variables
- br
  - type : final BufferedReader
  - 사용자의 입력을 받기위한 스트림변수
- puzzle
  - type : final Puzzle
  - PuzzleV2클래스의 객체

### methods
- Game interface override한 메서드들
- checkCorrectInput(String)
  - parameter : String
  - return : int
  - throw : IllegalArgumentException
  - 유저가 입력한 String을 받아 올바른 값을 입력했는지 판별해주는 함수
  - 올바른 값이면 int로 바꿔서 반환
  - 아니면 IllegalArgumentException