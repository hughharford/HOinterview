package com.posco.pramp.drawHTree;
/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *  
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Comparator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point
    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    // private final Comparator<Point> BY_SLOPE = new SlopeComparator();
    // not static, as a new BY_SLOPE for each point
    // see below for the same in the class defintion
    
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {

    	// same point
        if (((this.x == that.x) && (this.y == that.y))) return Double.NEGATIVE_INFINITY;
        // horizontal
        if (that.x - this.x == 0) { return Double.POSITIVE_INFINITY; }
        // vertical
        if (that.y - this.y == 0) { return +0.0; }

        double dy = (that.y - this.y);
        double dx = (that.x - this.x);
        // System.out.println("dy, dx = " + dy + ", " + dx);
        // System.out.println("dy/dx = " + dy/dx);
        
        return dy/dx;
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) {

        // Formally, the invoking point (this.x, this.y) is less than the argument 
        // point (that.x, that.y) 
        // if and only if either this.y < that.y or 
        // if this.y = that.y and this.x < that.x.
        
        // invoking point is ... than the argument point:
        // less than
   	
        if (this.y < that.y) {
        	// System.out.println("LESS THAN v1 (returns -1) \n x0,y0: " + this.x + "," + this.y + ", x1, y1: " + that.x + "," + that.y);
        	return -1;
        }
        if ((this.y == that.y) && (this.x < that.x)) {
        	// System.out.println("LESS THAN v2 (returns -1) \n x0,y0: " + this.x + "," + this.y + ", x1, y1: " + that.x + "," + that.y);
        	return -1;
        }
        // more than
        if (this.y > that.y) { 
        	// System.out.println("MORE THAN v1 (returns 1) \n x0,y0: " + this.x + "," + this.y + ", x1, y1: " + that.x + "," + that.y);
        	return 1;
        }
        if ((this.y == that.y) && (this.x > that.x)) {
        	// System.out.println("MORE THAN v1 (returns 1) \n x0,y0: " + this.x + "," + this.y + ", x1, y1: " + that.x + "," + that.y);
        	return 1;
        }
        
        // equal to
        if ((this.x == that.x) && (this.y == that.y)) {
        	// System.out.println("in COMPARETO ... EQUAL TO (returns -0) \n x0,y0: " + this.x + "," + this.y + ", x1, y1: " + that.x + "," + that.y);
        	return 0; // was -0
        }
        else { 
        	// System.out.println("point.CompareTo case not handled - x0,y0: " + this.x + "," + this.y + ", x1, y1: " + that.x + "," + that.y); 
        return +0;
        }
        
        // return 0;  // added to get past error... 
        // ?? surely the above covers all possibles?
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        return new SlopeComparator();
    }

    // not static, as a new BY_SLOPE for each point
    private class SlopeComparator implements Comparator<Point>
    {
        public int compare(Point q1, Point q2)
        { 
            // Formally, the point (q1.x, q1.y) is less than the point (q2.x, q2.y) 
            // if and only if the slope (q2.y − q1.y) / (q2.x − q1.x) 
            // is less than the slope (q2.y − q1.y) / (q2.x − q1.x). 
            // Treat horizontal, vertical, and degenerate 
            // line segments as in the slopeTo() method
            
            Point q0 = Point.this;
            // setting this to mandate comparison with the invoking point. 
            // DOES THIS ADDITION HELP? NOT SURE THIS IS SENSIBLE...
        	// see below, q1 and q2 still get used throughout
            // defintely sorts differently: 
            //		FCP: Arrays.sort(pointsToCheck, pX.slopeOrder());
            //		        	
            // same points:
        	// to witness points being compared:
            boolean printCompareDetail = false;
            if (printCompareDetail) {
            	System.out.println("q0 >>>  " + Point.this.toString());
            	System.out.println("q1 " + q1.toString() + " and q2: " + q2.toString());
            	System.out.println("slope q1 to q2 gives: " + q1.slopeTo(q2));
            }
        	
        	if (q0.slopeTo(q1) > q0.slopeTo(q2)) return 1;
        	if (q0.slopeTo(q1) < q0.slopeTo(q2)) return -1;
        	if (q0.slopeTo(q1) == q0.slopeTo(q2)) return 0;
        	else return 0;   // was -0
        	
        	// ORIGINAL ATTEMPT HERE: doesn't take account of the invoking p0 point
        	/*
        	// same point:
            if (q1.slopeTo(q2) == Double.NEGATIVE_INFINITY) return -0;
            // horizontal:        	
            if (q1.slopeTo(q2) == Double.POSITIVE_INFINITY) return 0;
            // vertical:
            if (q1.slopeTo(q2) == +0.0) return +0;
            // positive slope:
            if (q1.slopeTo(q2) > 0) return 1;
            // negative slope: 
            if (q1.slopeTo(q2) < 0) return -1;
            
            else {
            	System.out.println("not working as intended >>>>>>>>>>>>>>>>> ");
            	return -80000000;            
            }
        	*/
        }
    }
        

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        if (args.length == 0) { throw new NoSuchElementException("main: no input found"); }

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        // System.out.println("Read in all points array size " + points.length);

        // draw the points
        
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        
        StdDraw.setPenRadius(0.01); 
        
        
        for (Point p : points) {
            p.draw();
            // System.out.println("Drawing point: x,y @ " + p.x + ", " + p.y);
        }
        StdDraw.show();
        

        for (int i = 1; i < n; i++) {
            System.out.println("Point: x0,y0 __ x1, y1 @@@@ >>  " + 
                                  points[i-1].x + ", " + points[i-1].y + 
                     " __>>__ " + points[i].x + ", " + points[i].y);

            System.out.println("Slope for point: " + points[i-1].slopeTo(points[i]));
            // points[i-1].drawTo(points[i]);
        }
        StdDraw.show();
        
        
        /*
        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
        */
        
    }
}
