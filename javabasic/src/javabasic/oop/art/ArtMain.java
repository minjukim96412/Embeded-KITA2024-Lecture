package javabasic.oop.art;

public class ArtMain {
	public static void main(String[] args) {
		
		
		IArt drawing = new Drawing("절규");
		IArt music = new Music("spot");
		IArt movie = new Movie("범죄도시");
		
		IArt drawing2 = new Drawing("절규", 4);
		IArt music2 = new Music("spot", 3);
		IArt movie2 = new Movie("범죄도시",5);

		drawing2.giveGrades();
		music2.giveGrades();
		movie2.giveGrades();
		
		drawing.draw();
		music.listen();
		movie.watch();
		
		
	}
}
