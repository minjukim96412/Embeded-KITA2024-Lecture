package javabasic.oop.art;

public class Music extends AbstractArt {

	Music(String name){
		this.name = name;
	}
	
	Music(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	@Override
	public void listen() {
		System.out.println(name + "을(를) 듣습니다.");
	}
}
