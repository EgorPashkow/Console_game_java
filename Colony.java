import java.util.ArrayList;

public class Colony {
    public ArrayList<Resurce> res = new ArrayList<>();
    public ArrayList<Build> building = new ArrayList<>();
    public String name;
    
    public Colony(String temp){
    	name = temp;
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
    	if(!res.contains(r)){
    		res.add(r);
    	}
    }
    
    public void DelResorce(Resurce r){
    	if(r != null){
    		res.remove(r);
    	}
    }
    
    public void AddBuilding(Build b){
    	if(!building.contains(b)){
    		building.add(b);
    	}
    }
    
    public void DelBuilding(Build b){
    	if(b != null) {
    		building.remove(b);
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
