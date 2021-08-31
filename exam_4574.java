// 4584번 문제(스도미노쿠)

import java.io.*;
import java.util.*;

public class exam_4574 {
	static int N;
	static int turn=0;
	static int[][] puzzle;
	static boolean[][] domino;
	static boolean[][] row;
	static boolean[][] column;
	static boolean[][] square;
	static boolean end;
	final static int n=9;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			turn++;
			
			int first;
			int[] first_index = new int[2];
			int second;
			int[] second_index = new int[2];
			int not_used = 36;
			
			puzzle = new int[9][9];
			domino = new boolean[10][10];
			row = new boolean[9][10];
			column = new boolean[9][10];
			square = new boolean[9][10];
			end = false;
			
			for(int i =1;i<=9;i++) {
				domino[i][i] = true;
			}
			
			for(int i =0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				first = Integer.parseInt(st.nextToken());
				String tmp = st.nextToken();
				first_index[0] = (int)tmp.charAt(0) - (int)'A';
				first_index[1] = Character.getNumericValue(tmp.charAt(1))-1;
				
				second = Integer.parseInt(st.nextToken());
				tmp = st.nextToken();
				second_index[0] = (int)tmp.charAt(0) - (int)'A';
				second_index[1] = Character.getNumericValue(tmp.charAt(1))-1;
				
				domino[first][second] = true;
				domino[second][first] = true;
				
				puzzle[first_index[0]][first_index[1]] = first;
				puzzle[second_index[0]][second_index[1]] = second;
				
				change(first_index[0],first_index[1],first,true);
				change(second_index[0],second_index[1],second,true);
				not_used--;
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				String tmp = st.nextToken();
				first = i+1;
				first_index[0] = (int)tmp.charAt(0) - (int)'A';
				first_index[1] = Character.getNumericValue(tmp.charAt(1))-1;
				puzzle[first_index[0]][first_index[1]] = first;
				row[first_index[0]][first] = true;
				column[first_index[1]][first] = true;
				square[first_index[0]/3*3 + first_index[1]/3][first] = true;
			}
			
			insert(bw, 0,0,not_used);
		}
		bw.flush();
		bw.close();
	}
	
	static void change(int x, int y, int num, boolean tf) {
		row[x][num] = tf;
		column[y][num] = tf;
		square[cal_squ(x,y)][num] = tf;
	}
	
	static int cal_squ(int x, int y) {
		return x/3*3 + y/3;
	}
	
	public static void insert(BufferedWriter bw,int x, int y,int not_used) throws Exception{
		if(not_used == 0) {
			bw.write("Puzzle " + turn + "\n");
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					bw.write(puzzle[i][j]+"");
				}
				bw.write("\n");
			}
			end = true;
			return;
		}
		if(x==9)
			return;
		
		int empty_x=-1;
		int empty_y=-1;
		
		for(int i=y;i<9;i++) {
			if(puzzle[x][i] == 0) {
				empty_x = x;
				empty_y = i;
				break;
			}
		}
		
		if(empty_x == -1) {
			for(int i=x+1;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(puzzle[i][j] == 0) {
						empty_x = i;
						empty_y = j;
						break;
					}
				}
				if(empty_x != -1)
					break;
			}
		}
		
		for(int i =1;i<=9;i++) {
			if(row[empty_x][i]== false && column[empty_y][i] == false && square[empty_x/3*3 + empty_y/3][i] == false) {
				if(empty_y +1 < 9 && puzzle[empty_x][empty_y + 1] == 0) {
					for(int j =1;j<=9;j++) {
						if(domino[i][j] == false && row[empty_x][j] ==false && column[empty_y + 1][j] == false && square[empty_x/3*3 + (empty_y+1)/3][j] ==false) {
							domino[i][j] = true;
							domino[j][i] = true;
							puzzle[empty_x][empty_y] = i;
							puzzle[empty_x][empty_y+1] = j;
							change(empty_x,empty_y,i,true);
							change(empty_x,empty_y+1,j,true);
							
							if(empty_y+2<9) {
								insert(bw,empty_x,empty_y+2,not_used-1);
								if(end == true)
									return;
							}else {
								insert(bw,empty_x + 1, 0, not_used-1);
								if(end == true)
									return;
							}
							domino[i][j] = false;
							domino[j][i] = false;
							puzzle[empty_x][empty_y] = 0;
							puzzle[empty_x][empty_y+1] = 0;
							change(empty_x,empty_y,i,false);
							change(empty_x,empty_y+1,j,false);
						}
					}
				}
				
				if(empty_x + 1 < 9 && puzzle[empty_x+1][empty_y] == 0) {
					for(int j =1;j<=9;j++) {
						if(domino[i][j] == false && row[empty_x+1][j] ==false && column[empty_y][j] == false && square[(empty_x+1)/3*3 + empty_y/3][j] ==false) {
							domino[i][j] = true;
							domino[j][i] = true;
							puzzle[empty_x][empty_y] = i;
							puzzle[empty_x+1][empty_y] = j;
							change(empty_x,empty_y,i,true);
							change(empty_x+1,empty_y,j,true);
							
							if(empty_y+1<9) {
								insert(bw,empty_x,empty_y+1,not_used-1);
								if(end)
									return;
							}else {
								insert(bw, empty_x + 1, 0, not_used-1);
								if(end)
									return;
							}
							domino[i][j] = false;
							domino[j][i] = false;
							puzzle[empty_x][empty_y] = 0;
							puzzle[empty_x+1][empty_y] = 0;
							change(empty_x,empty_y,i,false);
							change(empty_x+1,empty_y,j,false);
							
						}
					}
				}
			}
		}
		
	}
}
