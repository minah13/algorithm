//프로그래머스 BFS/DFS 타겟넘버 문제

public class Dfsbfs1 {

	public static void main(String[] args) {
		int[] numbers = {4,1,2,1};
		int target = 4;
		int result = solution(numbers,target);
		
		System.out.println(result);

	}
	
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(numbers[0]);
		q.add(-numbers[0]);
		
		for(int i=1;i<numbers.length;i++) {
			int count = q.size();
			for(int j=0;j<count;j++) {
				int tmp = q.poll();
				int a = tmp + numbers[i];
				int b = tmp - numbers[i];
				q.add(a);
				q.add(b);
			}
		}
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if(tmp == target)
				answer++;
		}
		
		
		return answer;
	}

}
