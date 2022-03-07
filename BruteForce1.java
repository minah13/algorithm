// 프로그래머스 브루트포스 (모의고사) 문제

public class BruteForce1 {

	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		int[] result = math(answers);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] math(int[] answers) {
		int[] answer = {};
		
		int[] stu1 = {1,2,3,4,5};
		int[] stu2 = {2,1,2,3,2,4,2,5};
		int[] stu3 = {3,3,1,1,2,2,4,4,5,5};
		int[] score= new int[3];
		
		int max=0;
		int max_index=0;
		
		for(int i=0;i<answers.length;i++) {
			if(stu1[i%5]==answers[i]) {
				score[0]++;
			}
			if(stu2[i%8]==answers[i]) {
				score[1]++;
			}
			if(stu3[i%10]==answers[i]) {
				score[2]++;
			}
		}
		
		for(int i=0;i<score.length;i++) {
			if(max<score[i]) {
				max=score[i];
				max_index=1;
			}else if(max==score[i]) {
				max_index++;
			}
		}
		
		answer = new int[max_index];
		
		int tmp=0;
		for(int i=0;i<score.length;i++) {
			if(score[i]==max) {
				answer[tmp++] = i+1;
			}
		}
		
		return answer;
	}
}
