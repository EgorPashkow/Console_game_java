import java.util.ArrayList;

public class Galaxy {
    public ArrayList<Planet> planet = new ArrayList<>();
    
    public String toString() {
    	String res = "";
    	for(int i = 0; i < planet.size(); i++){
			res += planet.get(i)+"\n";
		}
		return res;
    }
    
    public void AddPlanet(Planet p){
    	synchronized(planet) {
    		if(!planet.contains(p)){
    			planet.add(p);
    		}
    	}
    }
    
    public void DelPlanet(Planet p){
    	synchronized(planet) {
    		if(p != null) {
    			planet.remove(p);
    		}   
    	}
    }
    
    public Planet GetPlanet(String name){
    	for(int i = 0;i < planet.size(); i++){
    	    if(planet.get(i).name.equals(name)){
    	        return planet.get(i);
    	    }
    	}
        return null;
    }
}