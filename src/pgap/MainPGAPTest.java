package pgap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainPGAPTest extends MainPGAP {

	@Test
	void test1() {
		String[] lines = {
				"5 1",
				"..H.H"
		};
		int answer = 4;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test2() {
		String[] lines = {
				"10 5",
				"....H..H.H"
		};
		int answer = 10;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test3() {
		String[] lines = {
				"20 3",
				"H....HH.HHH......H.."
		};
		int answer = 16;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test4() {
		String[] lines = {
				"50 50",
				".................................................."
		};
		int answer = 50;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test5() {
		String[] lines = {
				"50 50",
				"HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH"
		};
		int answer = 50;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test6() {
		String[] lines = {
				"50 0",
				".................................................."
		};
		int answer = 0;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test7() {
		String[] lines = {
				"50 3",
				".................................................."
		};
		int answer = 9;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test8() {
		String[] lines = {
				"10 3",
				".H.H.H.H.H"
		};
		int answer = 8;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test9() {
		String[] lines = {
				"10 3",
				"..#..#..#."
		};
		int answer = 9;
		assertEquals(answer, MainPGAP.execution(lines));
	}

	@Test
	void test10() {
		String[] lines = {
				"10000000 10000000",
				".".repeat(10000000)
		};
		int answer = 10000000;
		long start = System.currentTimeMillis();
		assertEquals(answer, MainPGAP.execution(lines));
		long end = System.currentTimeMillis();
		assertTrue(end - start <= 2000);
	}

	@Test
	void test11() {
		String[] lines = {
				"10000000 10000000",
				"#".repeat(10000000)
		};
		int answer = 10000000;
		long start = System.currentTimeMillis();
		assertEquals(answer, MainPGAP.execution(lines));
		long end = System.currentTimeMillis();
		assertTrue(end - start <= 2000);
	}

	@Test
	void test12() {
		String[] lines = {
				"10000000 500",
				".#..".repeat(2500000)
		};
		int answer = 2501500;
		long start = System.currentTimeMillis();
		assertEquals(answer, MainPGAP.execution(lines));
		long end = System.currentTimeMillis();
		assertTrue(end - start <= 2000);
	}

	@Test
	void test13() {
		String[] lines = {
				"10000000 2500000",
				".##.".repeat(2500000)
		};
		int answer = 9999999;
		long start = System.currentTimeMillis();
		assertEquals(answer, MainPGAP.execution(lines));
		long end = System.currentTimeMillis();
		assertTrue(end - start <= 2000);
	}

	@Test
	void test14() {
		String[] lines = {
				"10000000 2500000",
				".#.#".repeat(2500000)
		};
		int answer = 7500000;
		long start = System.currentTimeMillis();
		assertEquals(answer, MainPGAP.execution(lines));
		long end = System.currentTimeMillis();
		assertTrue(end - start <= 2000);
	}

	@Test
	void test15() {
		String[] lines = {
				"10000000 1999999",
				"..##.".repeat(2000000)
		};
		int answer = 9999997;
		long start = System.currentTimeMillis();
		assertEquals(answer, MainPGAP.execution(lines));
		long end = System.currentTimeMillis();
		assertTrue(end - start <= 2000);
	}

	@Test
	void test16() {
		String[] lines = {
				"10000000 2000000",
				"..##.".repeat(2000000)
		};
		int answer = 9999999;
		long start = System.currentTimeMillis();
		assertEquals(answer, MainPGAP.execution(lines));
		long end = System.currentTimeMillis();
		assertTrue(end - start <= 2000);
	}

	@Test
	void test17() {
		String[] lines = {
				"10000000 2000001",
				"..##.".repeat(2000000)
		};
		int answer = 10000000;
		long start = System.currentTimeMillis();
		assertEquals(answer, MainPGAP.execution(lines));
		long end = System.currentTimeMillis();
		assertTrue(end - start <= 2000);
	}
}
