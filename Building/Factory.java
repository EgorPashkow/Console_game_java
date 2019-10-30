public abstract class Factory extends Build {
	public Integer performance;
    public Factory(String temp) {
		super(temp);
	}
    public String toString() {
		return name + " " + this.getClass().getSimpleName() + ": " + performance;
    }
}