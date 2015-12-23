package com.cagatayyapici.tests;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cagatayyapici.geometry.Vector2;
import com.cagatayyapici.logic.Perlin2D;
import com.cagatayyapici.util.TextReader;

public class TestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() throws Exception {
		Perlin2D pp = new Perlin2D(5, true, new Vector2()); 
		String yourpath="\\..\\Outputs.txt";
		List<Double> data2Test = TextReader.GetTestList(new File(yourpath));
		int len = data2Test.size();
		for (int i = 0; i < len; i++) {
			if (data2Test.get(i) != pp.Noise(i, i) * 1000) {
				fail("Randomness Fail...");
			}
		}

		/**
		 * TODO continue from here
		 */

	}

}
