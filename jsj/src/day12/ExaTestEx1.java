package day12;

public class ExaTestEx1 {

	public static void main(String[] args) {
		ExaShape s1 = new ExaShape(0, 0, 10, 10);
		s1.print();
		ExaShape s2 = new ExaShape(10, 10, 0, 0);
		s2.print();
		s2.move(10, 10);
		s2.print();
		s2.reseize(20, 20, 3);
		s2.print();
		s2.reseize(10, 10, 2);
		s2.print();
		s2.reseize(5, 5, 1);
		s2.print();
		s2.reseize(3, 3, 4);
		s2.print();
		
		ExaRect r1 = new ExaRect(0, 0, 10, 10);
		r1.print();
		r1.move(10, 10);
		r1.print();
		r1.reseize(30, 30, 3);
		r1.print();
		
		ExaEllipse e1 = new ExaEllipse(0, 0, 10, 10);
		e1.print();
		e1.move(20, 30);
		e1.print();
		e1.reseize(15, 25, 2);
		e1.print();
	}

}
