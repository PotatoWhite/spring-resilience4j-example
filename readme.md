# Resilience4j
- 말도 많고 불편하지만 fault tolerant 계의 대명사였던 hystrix의 후계자.  
- 2018년 netflix가 hystrix가 지원중단을 발표하고 resilience4j를 추천함 [Hystrix Official](https://github.com/Netflix/Hystrix)



# Fault Tolerant System

- Fault Tolerant 란 결한감내 또는 내결함성이 있는 시스템을 말한다. 
- fault! failure가 아니다. 고장난 시스템을 고쳐주지 않는다. 한국말로하면 뭔가 되게 강력해 보이는데 그 강력함을 오해해선 안된다. 슈퍼맨 아니다. 
- 실제는 fault를 tolerant한다. 실제는 결함 백신이 아니라, 부분적인 결함을 우회하도록 도와주는 Helper로 이해하면 쉽다.

```yaml
// Spring Actuator의 Health 기능과 연동하기 위한 설정
registerHealthIndicator: true   

// 이벤트버퍼 크기
eventConsumerBufferSize: 10

// HalfOpen 사용여부 설정
automaticTransitionFromOpenToHalfOpenEnabled: true

// 실패 비율 50% 이상이면 Circuit Open하겠다.
failureRateThreshold: 50

// 5건이상 들어와야 Circuit Open 여부를 판단하겠다.
minimumNumberOfCalls: 5

// HalfOpen상태 사용할 수 있는 요청 수
permittedNumberOfCallsInHalfOpenState: 3

// HalfOpen상태에서 사용할 수 있는 최대 시간(최대시간 이후 다시 Open으로)
maxWaitDurationInHalfOpenState

// Circuit이 Close 상태(정상) 일떄 요청 결과 저장 크기
slidingWindowSize: 10

// Open->HalfOpen 전이를 위한 대기시간
waitDurationInOpenState: 5s

// COUNT_BASED OR TIME_BASED
slidingWindowType: COUNT_BASED
```