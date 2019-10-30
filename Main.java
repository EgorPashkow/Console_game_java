public class Main {
    public static void main (String args []) {
    	Galaxy galaxy = new Galaxy();
    	Updater update = new Updater(galaxy);
    	update.start();
    	Controller controller = new Controller();
    	controller.run(galaxy);
    }
}