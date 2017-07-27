import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Input your exam marks:");
		String s = scan.next();
		final double exam = Double.parseDouble(s);

		scan.close();

		double[] quiz = {0.0,0.0,0.0,4.0,0.0,0.0};
		double[] workshop = {1.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,1.0,0.0,0.0,0.0};
		double[] lab = {10.0,6.0,9.0,8.0,10.0};


		double l = (20.0/50.0)*(sum(lab));
		// double q = quizmark(quiz,exam);
		// double w = workshopmark(workshop,exam);
		double[] psq = quiz;
		double[] psw = workshop;
		System.out.println("Your exam mark should be "+passmark(psq,psw,l)+" for passing this course");
		System.out.println("Your exam mark should be "+supplymark(psq,psw,l)+" for taking a supplyment exam in this course");

		// double l = (20.0/50.0)*(sum(lab));
		// for (int i=0;i<quiz.length ;i++ ) {
		// 	System.out.println(quiz[i]);
		// }
		double q = quizmark(quiz,exam);
		double w = workshopmark(workshop,exam);
		double perquiz = 0.04*exam;
		double perworkshop = 0.01*exam;

		System.out.println("redeemable quiz mark is "+perquiz+" per quiz");

		System.out.println("redeemable workshop mark is "+perworkshop+" per workshop");

		System.out.println("quiz mark is "+ q);

		System.out.println("workshop mark is "+ w);

		System.out.println("lab mark is "+l);

		double fin;
		fin = (quizmark(quiz,exam) + workshopmark(workshop,exam) + l )+ (0.6*exam);
		System.out.println("Your final mark is " + fin);

	}

	public static double quizmark(double[] q, double e){
		double qe = e;
		double[] qmarks;
		double m = 0.0;
		qmarks = q;
		for(int i = 0; i<qmarks.length;i++){
			m = Math.max(qmarks[i], 0.04*qe) + m;
		}
		double qmark;
		qmark = (10.0/24.0)*(m);
		qmarks = null;
		return qmark;
	}

	public static double workshopmark(double[] w, double e){
		double we = e;
		double[] wmarks = w;
		double m2 = 0.0;
		for(int i=0; i<wmarks.length;i++){
			m2 = Math.max(wmarks[i], we/100) + m2;
		}
		double wmark;
		wmark = (10.0/12.0)*(m2);
		wmarks = null;
		return wmark;
	}

	public static double passmark(double[] q, double[] w, double l){
		double e = 0.0;
		double[] pq = q;
		double[] pw = w;
		double f;
		f = quizmark(pq,e) + workshopmark(pw,e) + l + (0.6*e);
		while(f < 60.0){
			e = e + 1.0;
			f = quizmark(pq,e) + workshopmark(pw,e) + l + (0.6*e);
		}
		pq = null;
		pw = null;
		return e;
	}

	public static double supplymark(double[] q, double[] w, double l){
		double e = 0.0;
		double[] sq = q;
		double[] sw = w;
		double f;
		f = quizmark(sq,e) + workshopmark(sw,e) + l + (0.6*e);
		while(f < 45.0){
			e = e + 1.0;
			f = quizmark(sq,e) + workshopmark(sw,e) + l + (0.6*e);
		}
		sq = null;
		sw = null;
		return e;
	}

	public static double sum(double[] x){
		double y = 0.0;
		for(int i=0;i<x.length;i++){
			y = y+x[i];
		}
		return y;
	}

}
