// 프로그래머스 BFS/DFS 네트워크 문제

import java.util.LinkedList;
import java.util.Queue;

public class Dfsbfs2 {

	public static void main(String[] args) {
		int n=3;
		int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
		int result = solution(n,computers);
		
		System.out.println(result);
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		
		boolean[] check = new boolean[n];
		
		for(int i=0; i<n;i++) {
			
			if(check[i] ==false) {
				Queue<Integer> q = new LinkedList<Integer>();
				for(int j=0;j<computers[i].length;j++) {
					if(computers[i][j]==1 && i!=j) {
						q.add(j);
					}
				}
				check[i] = true;
				while(!q.isEmpty()) {
					int tmp = q.poll();
					check[tmp] = true;
					for(int k=0;k<computers[tmp].length;k++) {
						if(computers[tmp][k]==1 && check[k]==false) {
							q.add(k);
						}
					}
					
				}
				answer++;
			}
		}
		
		
		
		return answer;
	}
}
