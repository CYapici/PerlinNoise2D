# PerlinNoise2D Java
Perlin Noise 2D implementation with java 1,7(Native Libraries). 
https://en.wikipedia.org/wiki/Perlin_noise.
# Consumption
Perlin2D pp = new Perlin2D(5, true, new Vector2());
		for (int i = 0; i < 300; i += 20) {
			System.out.println(pp.Noise(i, i) * 1000);
		}
		
# Custom Libraries 
Vector2,Vector3 and MathfJ. Mathfj library contains Lerp,Clamp,(vector)Lerp,(vector)Slerp,Range
# Tests:
Accuracy has been tested but there are some tiny floating differences because of float/double conversion.
There can be overflow differences because there are some unsigned operations(bytecode) in Perlin2Djava.
# Live example:
http://alpha-001-dot-perlinnoised2dcagatayyapici.appspot.com/
