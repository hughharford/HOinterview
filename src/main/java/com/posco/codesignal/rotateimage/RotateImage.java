package com.posco.codesignal.rotateimage;

import java.util.Arrays;

public class RotateImage {

	public static void main(String[] args) {
		RotateImage r = new RotateImage();
		int[][] a = {{1,2,3}, 
				 {4,5,6}, 
				 {7,8,9}};
		int[][] b = {{1,2,3,4}, 
				{5,6,7,8}, 
				{9,10,11,12},
				{13,14,15,16}};
		int[][] c = {{1,2,3,4,5}, 
				{6,7,8,9,10}, 
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}};
		int[][] d = {{1,2,3,4,5,6}, 
				{7,8,9,10,11,12}, 
				{13,14,15,16,17,18},
				{19,20,21,22,23,24},
				{25,26,27,28,29,30},
				{31,32,33,34,35,36}};
		int[][] e = {{1,2,3,4,5,6,7}, 
				{8,9,10,11,12,13,14}, 
				{15,16,17,18,19,20,21},
				{22,23,24,25,26,27,28},
				{29,30,31,32,33,34,35},
				{36,37,38,39,40,41,42},
				{43,44,45,46,47,48,49}};
		int[][] forUse = e;
		r.output(forUse);
		r.output(r.rotateArray(forUse));
	}

	public int[][] rotateArray(int[][] arr) {
		
		int n = arr[0].length;
		if (n == 1) return arr;
		final int MID;
		int[][] ans = new int[n][n];

		boolean OddSides = (n % 2 == 0) ? false : true;
		// System.out.println("\nOddSides is " + OddSides);
		if (OddSides) MID = ((int) Math.ceil(n/2.0)) - 1;
		else MID = n/2;
		// System.out.println("mid = " + MID);

		System.out.println();

		// new approach
		int row = 0;
		int col = 0;
		int lastRow = 0;
		for (int rLoop = 0; rLoop < MID; rLoop++) {
			for (int cLoop = rLoop; cLoop < n-rLoop-1; cLoop++) {
				if (rLoop + 1 != MID) {
					row = rLoop;
					col = cLoop;
				} else {
					lastRow = rLoop;
					break;
				}
				// System.out.print(row + "," + col + "; ");
				ans = rotateOneIndexX4(arr, col, row, MID, n);
			}
		}
		System.out.println("\n");
		if (OddSides) {
			// rotate 2 of the 3
			ans = rotateOneIndexX4(arr, MID-1, lastRow, MID, n);
			ans = rotateOneIndexX4(arr, MID, lastRow, MID, n);
		} else {
			// rotate 1 of the 2
			ans = rotateOneIndexX4(arr, MID-1, lastRow, MID, n);
		}
		return ans;
	}

	private int[][] rotateIndices(int c, int r, int mid, int n) {
		int [][] ind = {{c},{r}};
		// rotating each by 90 degrees
		// identify dist from mid-point (col) => colMidDist
		int colMidDist = mid - c;
		double evenAdj = (n % 2 != 0) ? 0 : 0.01;
		ind[0][0] = r;
		ind[1][0] = (int) Math.floor((double) mid + colMidDist - evenAdj);
		return ind;
	}
	
	private int[][] rotateOneIndexX4(int[][] a, int c, int r, int mid, int n) {
		int [][] ind = {{0},{0}};
		// rotate a set of target vertices, one for each side

		ind[0][0] = r;
		ind[1][0] = c;
		int col;
		int row;
		int beingMoved;
		int nextToMove;

		beingMoved = a[ind[0][0]][ind[1][0]]; 
		// System.out.println("beingMoved: " + ind[0][0] + "," + ind[1][0] + " gives " + a[ind[0][0]][ind[1][0]]);
		for (int no = 0; no < 4; no++) {
	
			ind = rotateIndices(ind[0][0], ind[1][0], mid, n);
			row = ind[0][0];
			col = ind[1][0];
			// 					System.out.println(row + ", " + col);
			// make swap, keeping transfered one
			nextToMove = a[row][col]; 
			// System.out.println("nextToMove: " + ind[0][0] + "," + ind[1][0] + " gives " + a[ind[0][0]][ind[1][0]]);
			a[row][col] = beingMoved;
			beingMoved = nextToMove;
		}
		return a;
	}


	public void output(int[][] a) {
		int len = a.length;
		// System.out.println("len = " + len);
		System.out.print("[");
		for (int r = 0; r < len; r++) {
			System.out.print(r==0 ? "[" : " [");
			for (int c = 0; c < len; c++) {
				System.out.print(a[r][c]);
				System.out.print(c==len-1 ? "]" : ", ");
			}
			System.out.print(r==len-1 ? "]" :",\n");
		}
		System.out.println();
	}
}
