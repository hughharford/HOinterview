package com.posco.pramp.drawHTree;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/*
 * NOTES FROM PRAMP on time and space complexity
 * 
 * Time Complexity: 
 * 			every call of drawHTree invokes 9 expressions whose time complexity 
 * 			is O(1) and 4 calls of drawHTree until depth (denoted here as D) 
 * 			reaches to 0. Therefore: T(D) = 9 + 4 * T(D-1), where T is the time 
 * 			complexity function and D is the depth of the H-Tree. Now, if we 
 * 			expand T(D-1) recursively all the way to T(0), it’ll be easy to see 
 * 			that T(D) = O(4^D).
 * 
 * Space Complexity: 
 * 			recursive calls add overhead since we store them in the execution stack. 
 * 			The space occupied in the stack will be then O(D), in the worst case 
 * 			scenario. The stack space occupied will be no more than O(D) at any 
 * 			given point since a sibling drawHTree will not be called before the 
 * 			current one being executed returns (i.e. finishes its execution).
 * 
 */
public class DrawHTree {

	public static void main( String args[] ) {
		
		System.out.println( "Practice makes Perfect! \n\n" );

		double length = 150;
		double depth = 5;

		DrawHTree newTree = new DrawHTree();
		newTree.readyOutput();
		newTree.drawHTree(0, 0, length, depth);
	}

	private void drawHTree(double x, double y, double length, double depth) {

		if (depth == 0) return;  // exit if done

		double[] horiz = {0.0, 0.0, 0.0, 0.0};
		double[] verts1 = {0.0, 0.0, 0.0, 0.0};
		double[] verts2 = {0.0, 0.0, 0.0, 0.0};

		System.out.println("Depth: " + depth + ", Length: " + length);

		horiz = this.findHorizontalEndPoints(x, y, length);
		// find and draw the Horizontal
		this.drawLine(horiz[0], horiz[1], horiz[2], horiz[3]);
		// find and draw both Verticals
		verts1 = this.findVerticalEndPoints(horiz[0], horiz[1], length);
		this.drawLine(verts1[0], verts1[1], verts1[2], verts1[3]);
		
		verts2 = this.findVerticalEndPoints(horiz[2], horiz[3], length);
		this.drawLine(verts2[0], verts2[1], verts2[2], verts2[3]);

		// adjust length
		double newLength = Math.floor(length / Math.sqrt(5));

		// draw an H for each end of vertical
		// DrawHTree topLeftBranch = new DrawHTree();
		this.drawHTree(verts1[0], verts1[1], newLength, depth-1);
		this.drawHTree(verts1[2], verts1[3], newLength, depth-1);
		this.drawHTree(verts2[0], verts2[1], newLength, depth-1);
		this.drawHTree(verts2[2], verts2[3], newLength, depth-1);
}


private double[] findHorizontalEndPoints(double x1, double y1, double length) {
	double[] left = {0.0, 0.0}; 
	double[] right = {0.0, 0.0};

	// vertical 
	left[0] = x1 - length/2;
	right[0] = x1 + length/2;
	// horizontal so no change for y-axis
	left[1] = y1;
	right[1] = y1;

	double[] startPointsHorizontal = {left[0], left[1], right[0], right[1]};
	return startPointsHorizontal;
}

private double[] findVerticalEndPoints(double x1, double y1, double length) {
	double[] top = {0.0, 0.0}; 
	double[] bottom = {0.0, 0.0};

	// horizontal so no change for x-axis
	top[0] = x1;
	top[1] = y1 + length/2;
	bottom[0] = x1;
	bottom[1] = y1 - length/2;

	double[] startPointsVertical = {top[0], top[1], bottom[0], bottom[1]};
	return startPointsVertical;
}

private void drawLine(double x1, double y1, double x2, double y2) {
	Point points1 = new Point((int) x1, (int) y1);
	Point points2 = new Point((int) x2, (int) y2);
	LineSegment segment = new LineSegment(points1,points2);

	// print and draw the line segments
	// StdOut.println(segment);

	segment.draw();
	StdDraw.show();
}

private void readyOutput() {
	// ready to draw 
	StdDraw.enableDoubleBuffering();
	StdDraw.setXscale(-300, 300);   // -32768, 32768
	StdDraw.setYscale(-300, 300);
	StdDraw.setPenRadius(0.005); 
}

}

