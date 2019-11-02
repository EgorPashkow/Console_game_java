import java.util.Scanner;

public class Controller {
	public static String Parse() {
        return new Scanner(System.in).nextLine();
	}
	
	public static void Help(String point) {
		if(point.equals("Galaxy")){
			System.out.print("Get planet\nCreate planet\nSelect planet\nDelete planet\nExit\n");
		}
		if(point.equals("Planet")){
			System.out.print("Get colony\nCreate colony\nSelect colony\nDelete colony\nExit\n");
		}
		if(point.equals("Colony")){
			System.out.print("Get building\nCreate building\nCheck building\nDelete building\nExit\n");
		}
	}
	
	public static void galaxy(Galaxy galaxy) {
		while(true){
    		System.out.print("Galaxy menu \n");
    		String inp = Parse();
    		if(inp.equals("Get planet")){
    			System.out.print(galaxy);
    		}
    		if(inp.equals("Create planet")){
    			System.out.print("\nName planet: ");
    			Planet planet = new Planet(Parse());
    			galaxy.AddPlanet(planet);
    		}
    		if(inp.equals("Delete planet")){
    			System.out.print("\nName planet: ");
    			galaxy.DelPlanet(galaxy.GetPlanet(Parse()));
    		}
    		if(inp.equals("Select planet")){
    			System.out.print("\nName planet: ");
    			planeting(galaxy.GetPlanet(Parse()));
    		}
    		if(inp.equals("Help")){
    			Help("Galaxy");
    		}
    		if(inp.equals("Exit")){
    			return;
    		}
    	}
	}
	
	public static void planeting(Planet planet) {
		if(planet==null) {
			System.out.print("Null object");
			return;
		}
    	while(true){
    		System.out.print("Planet menu \n");
    		String inp = Parse();
    		if(inp.equals("Get colony")){
				System.out.print(planet);
			}
			if(inp.equals("Create colony")){
				System.out.print("\nName colony: ");
				Colony colony = new Colony(Parse());
				planet.AddColony(colony);
			}
			if(inp.equals("Delete colony")){
				System.out.print("\nName colony: ");
				planet.DelColony(planet.GetColony(Parse()));
			}
			if(inp.equals("Select colony")){
    			System.out.print("\nName colony: ");
    			colony(planet.GetColony(Parse()));
    		}
			if(inp.equals("Help")){
    			Help("Planet");
    		}
			if(inp.equals("Exit")){
    			return;
    		}
    	}
	}
	
	public static void colony(Colony colony) {
		if(colony==null) {
			System.out.print("Null object");
			return;
		}
    	while(true){
    		System.out.print("Colony menu \n");
    		String inp = Parse();
    		if(inp.equals("Get building")){
    			System.out.print(colony);
    		}
    		if(inp.equals("Create building")){
    			System.out.print("\nType building: ");
    			String type = Parse();
    			System.out.print("\nName building: ");
    			String name = Parse();
    			boolean good = false;
    			if(type.equals("House")){
    				good = colony.CreateBuilding(new House(name));
    			}
    			if(type.equals("Matter")){
    				good = colony.CreateBuilding(new MatterExtractor(name));
    			}
    			if(type.equals("Electric")){
    				good = colony.CreateBuilding(new PowerStation(name));
    			}
    			if(!good){
    				System.out.println("Not enough resources\n");
    			}
    		}
    		if(inp.equals("Delete building")){
    			System.out.print("\nName building: ");
    			colony.DelBuilding(colony.GetBuilding(Parse()));
    		}
    		if(inp.equals("Check building")){
    			System.out.print("\nName building: ");
    			System.out.print(colony.GetBuilding(Parse()));
    		}
    		if(inp.equals("Help")){
    			Help("Colony");
    		}
    		if(inp.equals("Exit")){
    			return;
    		}
    	}
	}
	public static void run(Galaxy temp) {
    	galaxy(temp);
    }
}
