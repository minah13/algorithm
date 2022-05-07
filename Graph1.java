// Graph(가장 먼 노드) 문제

package programmers;

import java.util.ArrayList;

public class Graph1 {
	
	public static void main(String args[]) {
		int n = 6;
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		int result = solution(n,edge);
		System.out.println(result);
	}
	
	public static int solution(int n, int[][] edge) {
		// 가장 멀리 떨어지 노드 개수
		int answer = 0;
		// 붙어 있는 노드 리스트
		ArrayList<int[]> edgelist = new ArrayList<int[]>();
		// 다음에 봐야할 노드
		ArrayList<Integer> nextnode = new ArrayList<Integer>();
		// 이미 방문한 노드
		boolean[] visited = new boolean[n+1];
		
		for(int i=0;i<edge.length;i++) {
			edgelist.add(edge[i]);
		}
		nextnode.add(1);
		visited[1] = true;
		int farnode=0;
		while(!nextnode.isEmpty()) {
			answer = farnode;
			farnode = 0;
			int index = nextnode.size();
			ArrayList<Integer> curnextnode = new ArrayList<Integer>();
			for(int j=0;j<index;j++) {
				int current = (int)nextnode.get(j);
				for(int i=0;i<edgelist.size();i++) {
					int[] tmp = (int[])edgelist.get(i);
					if(tmp[0]==current) {
						if(!visited[tmp[1]]) {
							curnextnode.add(tmp[1]);
							farnode++;
							visited[tmp[1]] = true;
						}
						edgelist.remove(i--);
					}else if(tmp[1] == current) {
						if(!visited[tmp[0]]) {
							curnextnode.add(tmp[0]);
							farnode++;
							visited[tmp[0]] = true;
						}
						edgelist.remove(i--);
					}
				}
			}
			
			nextnode.clear();
			nextnode.addAll(curnextnode);
		}
		
		
		return answer;
	}
	
}
