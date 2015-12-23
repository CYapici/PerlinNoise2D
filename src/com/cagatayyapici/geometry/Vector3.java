package com.cagatayyapici.geometry;

/**
 * advanced vector3
 * 
 * @author Cagatay Yapici
 *
 */
public class Vector3 {

	double xyzArray[] = new double[3];

	public Vector3() {
		xyzArray[0] = 0;
		xyzArray[1] = 0;
		xyzArray[2] = 0;
	}

	public Vector3(double x, double y, double z) {
		xyzArray[0] = x;
		xyzArray[1] = y;
		xyzArray[2] = z;
	}

	public Vector3(double[] array) {
		if (array.length != 3)
			throw new RuntimeException("Element size must match with 3 .");

		xyzArray[0] = array[0];
		xyzArray[1] = array[1];
		xyzArray[2] = array[2];
	}

	public double[] array() {
		return (double[]) xyzArray.clone();
	}

	/*
	 * THE OPERATORS
	 *  
	 */
	public Vector3 add(Vector3 a) {
		return new Vector3(xyzArray[0] + a.xyzArray[0], xyzArray[1]
				+ a.xyzArray[1], xyzArray[2] + a.xyzArray[2]);
	}

	public Vector3 sub(Vector3 a) {
		return new Vector3(xyzArray[0] - a.xyzArray[0], xyzArray[1]
				- a.xyzArray[1], xyzArray[2] - a.xyzArray[2]);
	}

	public Vector3 neg() {
		return new Vector3(-xyzArray[0], -xyzArray[1], -xyzArray[2]);
	}

	public Vector3 mul(double c) {
		return new Vector3(c * xyzArray[0], c * xyzArray[1], c * xyzArray[2]);
	}

	public Vector3 div(double c) {
		return new Vector3(xyzArray[0] / c, xyzArray[1] / c, xyzArray[2] / c);
	}

	public double dot(Vector3 a) {
		return xyzArray[0] * a.xyzArray[0] + xyzArray[1] * a.xyzArray[1]
				+ xyzArray[2] * a.xyzArray[2];
	}

	public Vector3 cross(Vector3 a) {
		return new Vector3(xyzArray[1] * a.xyzArray[2] - xyzArray[2]
				* a.xyzArray[1], xyzArray[0] * a.xyzArray[2] - xyzArray[2]
				* a.xyzArray[0], xyzArray[0] * a.xyzArray[1] - xyzArray[1]
				* a.xyzArray[0]);
	}

	/*
	 * OTHER METHODS
	 * 
	 */
	public boolean equals(Object checker) {
		if (checker instanceof Vector3) {
			Vector3 rhs = (Vector3) checker;

			return xyzArray[0] == rhs.xyzArray[0]
					&& xyzArray[1] == rhs.xyzArray[1]
					&& xyzArray[2] == rhs.xyzArray[2];
		} else {
			return false;
		}

	}

	public double norm() {
		return Math.sqrt(this.dot(this));
	}

	public Vector3 normalize() {
		return this.div(norm());
	}

	public double x() {
		return xyzArray[0];
	}

	public double y() {
		return xyzArray[1];
	}

	public double z() {
		return xyzArray[2];
	}

}