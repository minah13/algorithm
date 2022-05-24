// 정렬 (K번째 수) 문제

import java.util.*;

class Sort1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
		for(int i=0;i<commands.length;i++) {
			int x = commands[i][0];
			int y = commands[i][1];
			int k = commands[i][2];
			int[] a = new int[y-x+1];
			int index=0;
			for(int j=x-1;j<y;j++) {
				a[index++] = array[j];
			}
			Arrays.sort(a);
			
			answer[i] = a[k-1];
		}
		return answer;
    }
}
