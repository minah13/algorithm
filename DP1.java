// 프로그래머스 DP (N으로 표현) 문제

import java.util.ArrayList;

public class DP1 {

	public static void main(String[] args) {
		int N=2;
		int number =11;
		int result = solution(N,number);
		System.out.println(result);

	}
	
	public static int solution(int N, int number) {
		int answer = -1;
		
		ArrayList<ArrayList<Long>> m = new ArrayList<>();
		ArrayList<Long> n = new ArrayList<>();
		
		int index=1;
		
		long tmp = N;
		
		n.add(tmp);
		m.add(n);
		
		while(true) {
			int x=0;
			int y=index-1;
			n = new ArrayList<>();   // 새로 넣을 Array
			tmp = tmp*10+N;
			n.add(tmp);
			while(x<=y) {
				ArrayList<Long> l = m.get(x++);   // 
				ArrayList<Long> r = m.get(y--);
				
				for(int i=l.size()-1;i>=0;i--) {
					for(int j=r.size()-1;j>=0;j--) {
						long bigger = r.get(j);
						long smaller = l.get(i);
						if(l.get(i)>r.get(j)) {
							bigger = l.get(i);
							smaller = r.get(j);
						}
						
						long plus = bigger + smaller;
						long minus = bigger - smaller;
						long gub = bigger * smaller;
						long divide = bigger/smaller;
						if(plus==number || minus==number || gub==number || divide==number)
							return index+1;
						if(plus<Integer.MAX_VALUE && !n.contains(plus) && plus>0)
							n.add(plus);
						if(minus<Integer.MAX_VALUE && !n.contains(minus) && minus>0)
							n.add(minus);
						if(gub<Integer.MAX_VALUE && !n.contains(gub) && gub>0)
							n.add(gub);
						if(divide<Integer.MAX_VALUE && !n.contains(divide) && divide>0)
							n.add(divide);
					}
				}
			} // 오른쪽 index가 더 작아질때까지
			m.add(n);
			index++;
			if(index>7)
				break;
			
			
		} // 무한 루프 while절 끝
		
		
		return answer;
	}

}
