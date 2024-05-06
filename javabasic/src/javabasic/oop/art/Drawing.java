package javabasic.oop.art;

public class Drawing extends AbstractArt {
	Drawing(String name) {
		this.name = name;
	}

	Drawing(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public void draw() {
		System.out.println(name + "을(를) 그립니다.");
	}
}
