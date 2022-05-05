// 이분 탐색 (입국심사) 문제

package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearch1 {

	public static void main(String[] args) {
		int n=3;
		int[] times = {1,99,99};
		long result = solution(n,times);
		System.out.println(result);
	}

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		
		//오름차순 정렬
		Arrays.sort(times);
		
		// 이분 탐색을 위한 변수
		long start = 1;
		long end = (long)times[times.length-1]*n;  // 타입 long으로 저장되도록 형변환!!
		
		
		while(start<=end) {
			// 주어진 시간 내에 심사받을 수 있는 사람 수
			long person = 0;
			
			// 주어진 시간
			long mid = (start+end)/2;
			
			for(int i=0;i<times.length;i++) {
				person += mid/times[i];
				if(person>=n)
					break;
			}
			if(person<n) {   // 주어진 시간 내에 n명을 심사할 수 없다면
				start = mid+1;
			}
			else {           // 주어진 시간 내에 n명을 심사할 수 있다면
				end = mid-1;
				if(answer>mid) {	  // mid 시간 내에는 n명을 심사할 수 있다.				
					answer = mid;
					
				}
			}
		}
		
		return answer;
	}
}
