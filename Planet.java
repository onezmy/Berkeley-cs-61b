public class Planet {

	public double xxPos; // Its current x position
	public double yyPos; // Its current y position
	public double xxVel; // Its current velocity in the x direction
	public double yyVel; // Its current velocity in the y direction
	public double mass; // Its mass
	public String imgFileName; // The name of the file that corresponds to the image that depicts the planet
	private static double G = 6.67e-11;


	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		double dist = this.calcDistance(p);
		if (dist == 0){
			return 0;
		}
		return G*mass*p.mass/(dist*dist);
	}

	public double calcForceExertedByX(Planet p){
		double F_total = this.calcForceExertedBy(p);
		double dist = this.calcDistance(p);
		if (this.equals(p)){
			return 0;
		}
		return (p.xxPos-xxPos)*F_total/dist;
	}

	public double calcForceExertedByY(Planet p){
		double F_total = this.calcForceExertedBy(p);
		double dist = this.calcDistance(p);
		if (this.equals(p)){
			return 0;
		}
		return (p.yyPos-yyPos)*F_total/dist;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double F_x = 0;
		for (int i = 0; i < allPlanets.length; i++){
			F_x = F_x + this.calcForceExertedByX(allPlanets[i]);
		}
		return F_x;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double F_y = 0;
		for (int i = 0; i < allPlanets.length; i++){
			F_y = F_y + this.calcForceExertedByY(allPlanets[i]);
		}
		return F_y;
	}

	public void update(double dt, double Fx, double Fy){
		double a_x = Fx/mass;
		xxVel = xxVel + a_x*dt;
		xxPos = xxPos + dt*xxVel/2;

		double a_y = Fy/mass;
		yyVel = yyVel + a_y*dt;
		yyPos = yyPos + dt*yyVel/2;
	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
	}



}