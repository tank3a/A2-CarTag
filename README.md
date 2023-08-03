# A2-CarTag

안녕하세요🙌🏻 현대 오토에버 2팀 **CarTag** 🚙 (~~칼퇴~~)입니다.

## 프로젝트 소개

> 내가 탈 차, 이제 감이 아닌 **데이터**로.

현대만의 데이터로 차량견적을 산출할 수 있는 서비스를 개발하였습니다.

[기획/디자인 링크](https://www.figma.com/file/UPMMnkNQegdhJXFuZqQqph/Car-ta-log_Hand-off?type=design&node-id=1-6&mode=design&t=sBmZzwne4kOQ0Cub-0)

## 팀원 소개

| <img src="https://avatars.githubusercontent.com/u/63107805?s=400&u=a6d46e70c79e2efbe7baf3c1f41eea4196306a63&v=4" width="100px"> | <img src="https://avatars.githubusercontent.com/u/77661228?v=4" width="100px"> | <img src="https://avatars.githubusercontent.com/u/43626362?v=4" width="100px"> | <img src="https://item.kakaocdn.net/do/93f6fdee16edbf3cb096127b68c495bdce9463e040a07a9462a54df43e1d73f1" width="100px"> |
| ------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------- |
| [FE-김다예](https://github.com/kimdaye77)                                                                                       | [FE-박지성](https://github.com/jijiseong)                                      | [BE-김종원](https://github.com/tank3a)                                         | [BE-이용재](https://github.com/dydwo0740)                                                                               |

## 👇🏻 그라운드 룰

### Check In/Out

- 10:00 까지 모든 준비(노트북 세팅등 작업을 시작할 준비, 스크럼 시작전 코멘트 준비 등)가 완료된 상태로 프로젝트 룸에서 대기합니다.
- 12:30 부터 14:00 까지 점심 식사 및 휴식을 취합니다.
- 18:00 이전까지 회고를 할 준비를 끝내도록 합니다. 단, 그룹 내 피어세션은 동일 시간 금요일에 진행되므로 제외합니다.
- 19:00 까지 스크럼에서 정한 일들을 모두 끝냈을 때 귀가합니다. 단, 그렇지 못한 경우에는 그룹 구성원 모두 남아서 과제를 수행합니다.
- **귀가 관련 사항은 2주차부터 적용됩니다. 1주차에는 자율적으로 목표를 맞추어 일정에 차질이 생기지 않도록 합니다.**

### 팀 내에서 태도

- 소통을 통해 모르는 내용을 바로 물어보는 태도를 취합니다. (단, 팀원들에게 부담을 줄이기 위해서 질문 이전에 찾아보려는 노력을 하도록 합니다.)
- 러버덕 디버깅을 적용하여 팀원들과 소통하면서 문제 해결능력을 높이는 방안을 채택합니다.
- 프로젝트 기간동안 좋은 분위기를 위해서 팀원을 배려하는 태도를 가집니다.
- 계획 수정시에는 팀원과 협의를 통해 수정합니다.

### 팀 내 규칙

- 1일 1커밋하기 (최소 기준이기 때문에 더 많은 과제를 수행하도록 노력합니다.)
- 이슈를 만들고 팀원들과 함께 각 이슈의 소요시간 예측하도록 합니다.
- 프론트/백엔드 간 데이터 전달 시 API 명세 반드시 하도록 합니다.
- 수정사항은 수정 시작 전에 미리 팀원들에게 알리도록 합니다.
- 도메인 네임 규칙 지켜서 개발하도록 합니다.

## 📝 Convention

### Commit Convention

- 커밋 메시지 첫 줄 컨벤션은 다음과 같습니다.
  `[태그] #{issue number}: 커밋 메시지`의 형태이며 `:`뒤에만 space가 있음에 유의합니다.

#### 예시

`[FEAT] #1: 작업 내용`

#### Commit Tag

- 태그는 영어로 쓰되 대문자로 합니다.
- 태그 종류는 다음과 같습니다.
  - `FEAT`: 기능 구현
  - `FIX`: 버그 수정
  - `DOCS`: 문서 작업
  - `REFACTOR`: 리팩토링
  - `TEST`: 테스트 코드
  - `CHORE`: 빌드 업무 수정, 패키지 매니저 수정
  - `ADD`: assets, data 파일 추가하는 경우
  - `STYLE`: 코드 포맷팅, 세미콜론 누락, UI 디자인 변경 &rarr; 코드 변경이 없는 경우

## 🤝 협업 전략

### branch 전략

- Git Flow 전략을 응용합니다.

### Pull Request

- Pull Request 같은 파트 다른 팀원이 리뷰 후 approve/revert 합니다.

### 매주 계획하기

- 매주 월요일 스프린트 계획 회의에 정한 내용을 Github Issue로 정리합니다.

## 📖 브랜치 룰

### Branch Type

- `main` : 배포 가능한 상태의 브랜치
- `dev` : 개발 과정 중 하나의 feature/bug를 완료하고 merge하는 브랜치
- `feat` : 하나의 기능을 구현하는 브랜치
- `hotfix` : main에서 긴급한 수정사항이 생겼을 때 수정하는 브랜치
- `bugfix` : 개발 과정 중 발생한 버그를 수정하는 브랜치

### Naming method

- branch 양식
  `{옵션}/{브랜치 명}` (소문자, kebab-case)
  ex) `feat/option-selection`