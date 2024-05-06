package javabasic.oop.art;

public abstract class AbstractArt implements IArt{
	
	String name;
	int score;

	@Override
	public void giveGrades() {
		System.out.println(name + "의 평점은 " + score + " 입니다.");
	}

	@Override
	public void draw() {
		}
	
	@Override
	public void listen() {
		}

	@Override
	public void watch() {
		}
	
	
	
}
