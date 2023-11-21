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
  - 입력으로 -1이 주어지면 숫자가 아닌 빈칸으로 인식
- checkIsSorted()
  - parameter : none
  - return : boolean
  - member variable로 가지고 있는 정답 배열과 현재 배열을 비교하여 모두 같으면 true, 아니면 false
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
  - 잘못된 입력 검사도 여기서함
    - parse메서드 활용
- printTurnAndPuzzle(turn)
  - parameter : int
  - return : void
  - 현재 turn과 puzzle배열을 출력해주는 메서드
- addPuzzleNums(sb)
  - parameter : StringBuilder
  - return : void
  - parameter로 받은 StringBuilder에 현재 퍼즐의 숫자를 형식에 맞추어 추가해주는 메서드