import java.util.Arrays;

/* 프로그래머스 참고 간결 코드 */

class Programmers1102_s {
    public int solution(int distance, int[][] scope, int[][] times) {
        for (int i = 1; i <= distance; i++) {
            for (int j = 0; j < scope.length; j++) {
                Arrays.sort(scope[j]);
                if (i >= scope[j][0] && i <= scope[j][1] && !(i % (times[j][0] + times[j][1]) > times[j][0] || i % (times[j][0] + times[j][1]) == 0)) {
                    return i;
                }
            }
        }
        return distance;
    }
}

/*
** 참고 코드보고 내 코드 피드백**
- 조건을 만족시키는 가장 큰 distance값을 찾아내야 한다.
- 하지만 이때 scope의 배열이 정렬되어 있지 않기 때문에 scope의 모든 배열을 살펴보거나 scope 배열 자체를 모두 정렬시켜야 한다.
- 내가 짠 코드의 경우 scope의 모든 배열을 살펴보는 방법을 선택하여 시간이 엄청 오래걸리는 코드였다.
- 위 코드의 경우에도 scope의 모든 배열을 살펴보긴하지만 아예 큰 반복문을 distance로 만들어서 필요없는 반복을 줄였다.
- 또, times 배열 비교의 경우에도 간단 연산을 사용함으로써 반복문 사용을 없앴다.
*/
