public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet (double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet (Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;		
	}

	public double calcDistance(Planet p) {
		double dx = (p.xxPos - this.xxPos);
		double dy = (p.yyPos - this.yyPos);
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double calcForceExertedBy(Planet p) {
		double g = 6.67e-11;
		double r = this.calcDistance(p);
		return (g * this.mass * p.mass / (r * r));
	}

	public double calcForceExertedByX(Planet p) {
		double r = this.calcDistance(p);
		double dx = (p.xxPos - this.xxPos);
		double f = this.calcForceExertedBy(p);
		return (f * dx / r) ;

	}

	public double calcForceExertedByY(Planet p) {
		double r = this.calcDistance(p);
		double dy = (p.yyPos - this.yyPos);
		double f = this.calcForceExertedBy(p);
		return (f * dy / r) ;

	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double fxnet = 0;
		for (int i = 0; i < allPlanets.length; i++){
			if (!this.equals(allPlanets[i])) {
				fxnet += this.calcForceExertedByX(allPlanets[i]);
			}
		}

		return fxnet;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double fynet = 0;
		for (int i = 0; i < allPlanets.length; i++){
			if (!this.equals(allPlanets[i])) {
				fynet += this.calcForceExertedByY(allPlanets[i]);
			}
		}

		return fynet;
	}

	public void update(double dt, double fx, double fy) {
		double ax = fx/this.mass;
		double ay = fy/this.mass;
		this.xxVel = this.xxVel + dt * ax;
		this.yyVel = this.yyVel + dt * ay;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;

	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
	}
}







