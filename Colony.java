import java.util.ArrayList;

public class Colony {
    public ArrayList<Resurce> res = new ArrayList<>();
    public ArrayList<Build> building = new ArrayList<>();
    public String name;
    
    public Colony(String temp){
    	name = temp;
    	AddResorce(new Electric());
		AddResorce(new Matter());
		AddResorce(new People());
    }
    
    public String toString() {
    	String result = name + "\n";
    	for(int i = 0; i < res.size(); i++) {   
			result += res.get(i).getClass().getSimpleName() + " " + res.get(i).count + "\n";
		}
    	result += "\n";
    	for(int i = 0; i < building.size(); i++) {   
			result += building.get(i).getClass().getSimpleName() + " " + building.get(i).name + "\n";
		}
		return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj instanceof Colony) {
            Colony temp = (Colony) obj;
            if(!temp.name.equals(name)) return false;
            return true;
        }
        return false;
    }
    
    public void AddResorce(Resurce r){
    	synchronized(res) {
    		if(!res.contains(r)){
    			res.add(r);
    		}
    	}
    }
    
    public Resurce GetResurce(String name){
    	for (Resurce temp : res) {
    		if(temp.getClass().getSimpleName()==name) {
    			return temp;
    		}
    	}
    	return null;
    }
    
    public void DelResorce(Resurce r){
    	synchronized(res) {
    		if(r != null){
    			res.remove(r);
    		}
    	}
    }
    
    public boolean CreateBuilding(Build b){
    	synchronized(building) {
    		if(!building.contains(b)){
    			if(b.getClass().getSimpleName() == "MatterExtractor" && GetResurce("Matter").count >= b.cost
    					&& GetResurce("People").count >= b.cost) {
    				GetResurce("Matter").count += -b.cost;
    				GetResurce("People").count += -b.cost;
    				building.add(b);
    				return true;
    			}
    			if(b.getClass().getSimpleName() == "PowerStation" && GetResurce("Electric").count >= b.cost
    					&& GetResurce("People").count >= b.cost) {
    				GetResurce("Electric").count += -b.cost;
    				GetResurce("People").count += -b.cost;
    				building.add(b);
    				return true;
    			}
    			if(b.getClass().getSimpleName() == "House") {
    				GetResurce("People").count += 300;
    				building.add(b);
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void DelBuilding(Build b){
    	synchronized(building) {
    		if(b != null) {
    			building.remove(b);
    		}
    	}
    }
    
    public Build GetBuilding(String name){
    	for(int i = 0;i < building.size(); i++){
    	    if(building.get(i).name.equals(name)){
    	        return building.get(i);
    	    }
    	}
        return null;
    }
}
