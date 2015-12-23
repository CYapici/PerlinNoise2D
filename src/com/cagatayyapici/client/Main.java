package com.cagatayyapici.client;

import com.cagatayyapici.geometry.Vector2;
import com.cagatayyapici.logic.Perlin2D;
/**
 * 
 * @author cagatay yapici
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Perlin2D pp = new Perlin2D(5, true, new Vector2());
		for (int i = 0; i < 300; i += 20) {
			System.out.println(pp.Noise(i, i) * 1000);
		}
	}

}
