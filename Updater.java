public class Updater extends Thread {
	Galaxy galaxy;
	
	public Updater(Galaxy temp) {
		galaxy = temp;
	}
	
	public void run() {
		while(true) {
			for (Planet planet : galaxy.planet) {
				for (Colony colony : planet.colonies) {
					for (Resurce resurce : colony.res) {
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