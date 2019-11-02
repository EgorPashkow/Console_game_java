public class Updater extends Thread {
	Galaxy galaxy;
	
	public Updater(Galaxy temp) {
		galaxy = temp;
	}
	
	public void run() {
		while(true) {
			synchronized(galaxy.planet) {
				for (Planet planet : galaxy.planet) {
					synchronized(planet.colonies) {
						for (Colony colony : planet.colonies) {
							synchronized(colony.res) {
								for (Resurce resurce : colony.res) {
									synchronized(colony.building) {
										for (Build build : colony.building) {
											if(build.getClass().getSimpleName() == "PowerStation" && resurce.getClass().getSimpleName() == "Electric") {
												PowerStation factory = (PowerStation) build;
												resurce.count += factory.performance;
											}
											if(build.getClass().getSimpleName() == "MatterExtractor" && resurce.getClass().getSimpleName() == "Matter") {
												MatterExtractor factory = (MatterExtractor) build;
												resurce.count += factory.performance;
											}
											try {
												sleep(5000);
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}