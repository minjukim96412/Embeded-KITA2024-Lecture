package javabasic.oop.animal;

public abstract class AbstractPlant implements ILife{
	
	String name;
	
	@Override
	public void breath() {
		System.out.println(name + "(이)가 숨을쉰다!");
	}

	@Override
	public void growth() {
		System.out.println(name + "(이)가 성장 한다!");
	}

	@Override
	public void light() {
		System.out.println(name + "(이)가 광합성 한다!");
	}
}
