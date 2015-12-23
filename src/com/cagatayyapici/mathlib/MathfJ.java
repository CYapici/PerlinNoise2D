package com.cagatayyapici.mathlib;

import com.cagatayyapici.geometry.Vector3;

/**
 * Mathematical Functions does not exist in Math Library
 * 
 * @author cagatay yapici
 *
 */
public class MathfJ {

	static public Vector3 Lerp(Vector3 start, Vector3 end, float percent) {
		return (end.mul(percent).sub(start).add(start));
	}

	static public Vector3 Slerp(Vector3 start, Vector3 end, float percent) {
		// the cosine of the angle between 2 vectors.
		float dot = (float) start.dot(end);
		dot = Clamp(dot, -1.0f, 1.0f);
		// Acos(dot) returns the angle between start and end,
		// And multiplying that by percent returns the angle between
		// start and the final result.
		float theta = (float) (Math.acos(dot) * percent);
		Vector3 RelativeVec = end.sub(start.mul(dot));
		RelativeVec.normalize();  
		return ((start.mul(Math.cos(theta))).add((RelativeVec.mul(Math
				.sin(theta)))));
	}

	static public float Clamp(float val, float min, float max) {
		return Math.max(min, Math.min(max, val));
	}

	static public double Lerp(double a, double b, double f) {
		return a + f * (b - a);
	}

	public static double Range(double numberOne, double numberTwo)
			throws Exception {

		if (numberOne == numberTwo) {
			throw new Exception("Both the numbers can not be equal");
		}

		double rand = Math.random();
		double highRange = Math.max(numberOne, numberTwo);
		double lowRange = Math.min(numberOne, numberTwo);

		double lowRand = Math.floor(rand - 1);
		double highRand = Math.ceil(rand + 1);

		double genRand = (highRange - lowRange)
				* ((rand - lowRand) / (highRand - lowRand)) + lowRange;

		return genRand;
	}
}
