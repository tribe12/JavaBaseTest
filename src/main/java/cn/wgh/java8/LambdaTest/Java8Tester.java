package cn.wgh.java8.LambdaTest;

public class Java8Tester {

	public static void main(String args[]) {
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	public int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}