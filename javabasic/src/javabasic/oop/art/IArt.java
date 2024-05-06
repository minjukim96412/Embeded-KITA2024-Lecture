package javabasic.oop.art;

public interface IArt extends IDraw, IListen, IWatch{
	//평점을 매긴다.
	public abstract void giveGrades();
	
}
