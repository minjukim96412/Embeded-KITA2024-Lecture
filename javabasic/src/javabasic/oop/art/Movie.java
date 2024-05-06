package javabasic.oop.art;

public class Movie extends AbstractArt {
	
	Movie(String name){
		this.name = name;
	}
	
	Movie(String name, int score){
		this.name = name;
		this.score = score;
	}

	@Override
	public void watch() {
		System.out.println(name + "을(를) 시청합니다.");
	}

	
	
}
