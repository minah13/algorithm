// 스택/큐 (기능개발) 문제

package programmers;

import java.util.*;
import java.io.*;

public class Stackqueue1 {
	public static void main(String[] args) {
		int[] progresses = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1};
		
		int[] s = solution(progresses,speeds);
		
		System.out.println("----------------");
		for(int i=0;i<s.length;i++) {
			System.out.println(s[i]);
		}
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int[] result;
		answer = new int[progresses.length];
		Queue<Integer> work = new LinkedList<Integer>();
		
		for(int i=0;i<progresses.length;i++) {
			work.add(progresses[i]);
		}
		int answer_i = 0;
		int index = 0;
		int day = 0;
		
		while(work.peek() !=null) {
			int prog = work.poll() + speeds[index]*day;
			int w=0;
			while(prog<100) {
				prog += speeds[index];
				day++;
			}
			System.out.println(day + "일 지남!");
			w++;
			index = index+1;
			while(work.peek()!=null && work.peek()+speeds[index]*day>=100) {
				index = index+1;
				w++;
				work.poll();
			}
			answer[answer_i++] = w;
			
		}
		
		result = new int[answer_i];
		for(int i=0;i<answer_i;i++) {
			result[i] = answer[i];
		}
		return result;
	}
}
