
public class Computer {
	private boolean status;
	private String name;

	public Computer(String name, boolean status) {
		this.status = status;
		this.name = name; }
	
	public void changeStatus(boolean status) {
		this.status = status; }
}
