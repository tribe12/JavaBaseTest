package cn.wgh.java8.StreamTest2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class StreamTest2 {
	@Test
	public void testName() throws Exception {
		final Collection< Task > tasks = Arrays.asList(
				    new Task( Status.OPEN, 5 ),
				    new Task( Status.OPEN, 13 ),
				    new Task( Status.CLOSED, 8 ) 
				);
	}
}
