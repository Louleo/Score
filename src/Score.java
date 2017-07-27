import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Input your exam marks");
		String s = scan.next();
		double exam = Double.parseDouble(s);
		double[] quiz = {0.0,0.0,0.0,4.0,0.0,0.0};
		double[] workshop = {1.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,0.0,0.0,0.0};
		double[] lab = {10.0,6.0,9.0,8.0,10.0};
		for(int i = 0; i<quiz.length;i++){
			quiz[i] = Math.max(quiz[i], 4.0*exam/100);
		}
		for(int i=0; i<workshop.length;i++){
			workshop[i] = Math.max(workshop[i], exam/100);
		}
		double q;
		q = (10.0/24.0)*(sum(quiz));
		System.out.println("quiz mark is"+q);
		double w;
		w = (10.0/12.0)*(sum(workshop));
		System.out.println("workshop mark is"+w);
		double l;
		l = (20.0/50.0)*(sum(lab));
		System.out.println("lab mark is"+l);
		double fin;
		fin = q + w + l + (0.6*exam);
		System.out.println("Your final mark is" + fin);
	}
	public static double sum(double[] x){
		double y = 0.0;
		for(int i=0;i<x.length;i++){
			y = y+x[i];
		}
		return y;
		
	}

}
