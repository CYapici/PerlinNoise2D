package com.cagatayyapici.geometry;

/**
 * simple vector2 
 * 
 * @author Cagatay Yapici
 *
 */
public class Vector2 {

	public double x;
	public double y;

	public Vector2() {
		this.x = 0.0f;
		this.y = 0.0f;
	}

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	//
	// public boolean equals(Vector2 other) {
	// return (this.x == other.x && this.y == other.y);
	// }
}
