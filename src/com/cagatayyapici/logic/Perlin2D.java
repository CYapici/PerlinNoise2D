package com.cagatayyapici.logic;

import com.cagatayyapici.geometry.Vector2;
import com.cagatayyapici.mathlib.MathfJ;

/**
 * PERLIN NOISE 2D
 * https://en.wikipedia.org/wiki/Perlin_noise
 * @author cagatay yapici 
 */
public class Perlin2D {
	private double scale;
	private double persistence = 0.5f;
	private int octaves = 3;
	private Vector2 offset;

	public Vector2 getOffset() {
		return offset;
	}

	public void setOffset(Vector2 offset) {
		this.offset = offset;
	}

	/**
	 * You can use random values with the parameter randomValues
	 * 
	 * @param scale
	 *            demonstrates scale factor of perlin noise
	 * @param randomize
	 *            randomize automatically generates values for you
	 * @param randomValues
	 * @throws Exception
	 */

	public Perlin2D(double scale, boolean randomize, Vector2 randomValues)
			throws Exception {
		this.scale = scale;
		if (randomize)
			offset = new Vector2(MathfJ.Range(-100f, 100f), MathfJ.Range(-100f,
					100f));
		else
			offset = randomValues;

	}

	public Perlin2D SetPersistence(double persistence) {
		this.persistence = persistence;
		return this;
	}

	public Perlin2D SetOctaves(int octaves) {
		this.octaves = octaves;
		return this;
	}

	public double Noise(double x, double y) {
		x = x * scale + offset.x;
		y = y * scale + offset.y;
		double total = 0;
		double frq = 1, amp = 1;
		for (int i = 0; i < octaves; i++) {
			if (i >= 1) {
				frq *= 2;
				amp *= persistence;
			}
			total += InterpolatedSmoothNoise(x * frq, y * frq) * amp;
		}
		return total;
	}

	private static double InterpolatedSmoothNoise(double X, double Y) {
		int ix = (int) Math.floor(X);
		double fx = X - ix;
		int iy = (int) Math.floor(Y);
		double fy = Y - iy;

		double v1 = SmoothNoise(ix, iy);
		double v2 = SmoothNoise(ix + 1, iy);
		double v3 = SmoothNoise(ix, iy + 1);
		double v4 = SmoothNoise(ix + 1, iy + 1);

		double i1 = (double) MathfJ.Lerp(v1, v2, fx);
		double i2 = MathfJ.Lerp(v3, v4, fx);

		return MathfJ.Lerp(i1, i2, fy);
	}

	private static double SmoothNoise(int x, int y) {
		double corners = (Noise(x - 1, y - 1) + Noise(x + 1, y - 1)
				+ Noise(x - 1, y + 1) + Noise(x + 1, y + 1)) / 16f;
		double sides = (Noise(x - 1, y) + Noise(x + 1, y) + Noise(x, y - 1) + Noise(
				x, y + 1)) / 8f;
		double center = Noise(x, y) / 4f;
		return corners + sides + center;
	}

	// the original implementation made by Ken Perlin
	// https://en.wikipedia.org/wiki/Ken_Perlin
	private static double Noise(int x, int y) {
		int n = x + y * 57;
		n = (n << 13) ^ n;
		return (1 - ((n * (n * n * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824f);
	}

}
