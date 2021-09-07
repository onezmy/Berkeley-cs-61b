public class NBody {
	public static double readRadius(String path){
		In in = new In(path);
		int N = in.readInt();
		double R = in.readDouble();
		return R;
	}
	
	public static Planet[] readPlanets(String path){
		In in = new In(path);
		int N = in.readInt();
		double R = in.readDouble();

		double xxPos; 
	    double yyPos; 
	 	double xxVel; 
		double yyVel; 
		double mass; 
		String imgFileName;

		Planet allPlanets[] = new Planet[N];

		for(int i = 0; i < N; i++){
			xxPos = in.readDouble();
			yyPos = in.readDouble();
			xxVel = in.readDouble();
			yyVel = in.readDouble();
			mass = in.readDouble();
			imgFileName = in.readString();
			allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}

		return allPlanets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double Radius = NBody.readRadius(filename);
		Planet[] allPlanets = NBody.readPlanets(filename);
		int N = allPlanets.length;
		
		StdDraw.setScale(-Radius, Radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "./images/starfield.jpg"); 
		for (int i = 0; i < allPlanets.length; i++){
			allPlanets[i].draw();
		}

		StdDraw.enableDoubleBuffering();
		double Time = 0;
		

		double xForces[] = new double[N];
		double yForces[]  = new double[N];

		while(Time < T){
			for (int i = 0; i < allPlanets.length; i++){
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}
			for (int i = 0; i < allPlanets.length; i++){
				allPlanets[i].update(dt, xForces[i], yForces[i]);
				allPlanets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			StdDraw.clear();
			StdDraw.picture(0, 0, "./images/starfield.jpg");
			Time = Time + dt; 
		}

		StdOut.printf("%d\n", allPlanets.length);
		StdOut.printf("%.2e\n", Radius);
		for (int i = 0; i < allPlanets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
            allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
		}

	}
}