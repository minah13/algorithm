// 프로그래머스 Greedy (체육복) 문제

package programmers;

public class Greedy1 {

	public static void main(String[] args) {
		int n=3;
		int[] lost = {3};
		int[] reserve = {1};
		int result = solution(n,lost,reserve);
		
		System.out.println(result);
	}
	
	public static int solution(int n,int[] lost, int[] reserve) {
		int answer = 0;
		int[] student = new int[n];
		for(int i=0;i<n;i++) {
			student[i] = 1;
		}
		
		for(int i=0;i<lost.length;i++) {
			student[lost[i]-1]--;
		}
		
		for(int i=0;i<reserve.length;i++) {
			student[reserve[i]-1]++;
		}
		
		for(int i=0;i<student.length;i++) {
			if(student[i]>=1) {
				answer++;
			}else if(student[i]==0) {
				if(i!=0 && student[i-1]>1) {
					student[i-1]--;
					student[i] = 1;
					answer++;
				}
				if(student[i] != 1 && i!=student.length-1 && student[i+1]>1) {
					student[i+1]--;
					student[i] = 1;
					answer++;
				}
			}
		}
		
		return answer;
	}

}
