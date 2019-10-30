import java.util.ArrayList;

public class Planet {
    public ArrayList<Colony> colonies = new ArrayList<>();
    public String name;
    
    public Planet(String temp){
    	name = temp;
    }
    
    public String toString() {
    	String res = name + "\n";
    	for(int i = 0; i < colonies.size(); i++){   
			res += colonies.get(i)+"\n";
		}
		return res;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj instanceof Planet) {
            Planet temp = (Planet) obj;
            if(!temp.name.equals(name)) return false;
            return true;
        }
        return false;
    }
    
    public void AddColony(Colony c){
    	if(!colonies.contains(c)){
    		colonies.add(c);
    	}
    }
    
    public void DelColony(Colony c){
    	if(c != null) {
    		colonies.remove(c);
    	}
    }
    
    public Colony GetColony(String name){
    	for(int i = 0;i < colonies.size(); i++){
    	    if (colonies.get(i).name.equals(name)){
    	        return colonies.get(i);
    	    }
    	}
        return null;
    }
}