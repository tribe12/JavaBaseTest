package cn.wgh.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class Exercises {
	/**
	 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
	 * 
	 * @throws Exception
	 */
	@Test
	public void testName() throws Exception {
		Double h = 100d;
		Double l = 0d;
		for (int i = 1; i <= 10; i++) {
			l += h;
			h = h / 2;
			if (i != 10) {
				l += h;
			}
		}
		System.out.println("它在第10次落地时，共经过:"+l+"米");
		System.out.println("第10次反弹高度:"+h+"米");
	}
}
