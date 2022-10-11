package com.spring.db;

interface Calculator {
	int add(int n1, int n2);
}

public class MainClass {

	public static void main(String[] args) {
		
		Car s1 = new Sonata();
		s1.run();
		
		Car s2 = new Sonata();
		s2.run();
		
		Car tesla = new Car() { //이 클래스에서만 사용이 가능한 추상 메소드를 선언
			@Override
			public void run() {
				System.out.println("테슬라가 슝슝 달립니다~");
			}
		};
		
		tesla.run();
		
		new Car() { //일회용 메소드
			@Override
			public void run() {
				System.out.println("포르쉐가 쌩쌩 달립니다~");
			}
		}.run();
		
		Car ferrari = () -> {
			System.out.println("페라리가 씽싱 달립니다~");
		};
		
		ferrari.run();
		
		System.out.println("-------------------------------------------------");
		
		//계산기 인터페이스와 람다식
		Calculator sharp = new Calculator() {
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("샤프 계산기의 덧셈!");
				return n1 + n2;
			}
		};
		
		System.out.println(sharp.add(10, 14));
		
		Calculator casio = (x, y) -> {
			System.out.println("카시오 계산기의 덧셈!");
			return x + y;
		};
		
		System.out.println(casio.add(100, 200));
		
		// 만약 오버라이딩 하는 추상 메소드에 작성할 코드가 단 한 줄이라면
		//return과 괄호가 생략이 가능합니다.
		Calculator xiaomi = (x, y) -> x + y;
		System.out.println(xiaomi.add(30, 50));
		
	}

}
