public class NBody  {
	public static Double readRadius(String filename) {
		In in  = new In(filename);
		int n = in.readInt();
		double r = in.readDouble();
		return r;
	}

	public static Planet[] readPlanets(String filename) {
		In in  = new In(filename);
		int n = in.readInt();
		double r = in.readDouble();
		Planet[] planets = new Planet[n];

		for (int i = 0; i < n; i++) {
			double p1 = in.readDouble();
			double p2 = in.readDouble();
			double p3 = in.readDouble();
			double p4 = in.readDouble();
			double p5 = in.readDouble();
			String p6 = in.readString();
			planets[i] = new Planet(p1, p2, p3, p4, p5, p6);
		}

		return planets;	
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		StdDraw.setScale(-radius, radius);
		


		StdDraw.enableDoubleBuffering();
		StdAudio.play("audio/2001.mid");
		for(double time = 0; time < T; time += dt) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];

			for(int i = 0; i < planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i = 0; i < planets.length; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			/**Draw the background image.*/
			StdDraw.picture(0, 0, "images/starfield.jpg");
			
			/** Draw all of the planets. */
			for( Planet p : planets) {
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);

		}

		System.out.println(planets.length);
		System.out.printf("%.2e\n",radius);
		for(int i = 0; i < planets.length; i++) {
			System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",planets[i].xxPos,planets[i].yyPos,planets[i].xxVel, planets[i].yyVel,planets[i].mass,planets[i].imgFileName);
			// System.out.println(planets[i].xxPos+ "\t" + planets[i].yyPos+ "\t" + planets[i].xxVel+ "\t" +  planets[i].yyVel+ "\t" + planets[i].imgFileName);
		}
	}
}