
public class Reefer extends TrainCar{
	//Private instance variable
	private int temp;
	
	//Constructor
	public Reefer(int weight, int temp, String freight) {
		super(weight, freight);
		this.temp = temp;
	}
	
	//Getter
	public int getTemp() {
		return this.temp;
	}
	
	//Setter
	public void setTemp(int newTemp) {
		this.temp = newTemp;
	}

	//String representation
	public String toString() {
		return "<"+this.getFreight()+", "+this.getWeight()+", "+this.getTemp()+"C>";
	}
	
	//Determine whether can connect
	@Override
	public boolean canConnect(TrainCar other) {
		//If can connect based on TrainCar's canConnect()
		if(super.canConnect(other)) {
			return true;
		}
		//If difference in temp is 5 or less
		if(other instanceof Reefer) {
			Reefer otherReefer = (Reefer) other; 
			if((Math.abs(this.getTemp() - otherReefer.getTemp()) <= 5)) {
				return true;
			}
		}
		return false;
	}
	
	//Determine whether identical
	@Override
	public boolean equals(TrainCar other) {
		//Both reefer and equal based on TrainCar's equal and same temp
		if(super.equals(other)) {
			if(other instanceof Reefer) {
				Reefer otherReefer = (Reefer) other; 
				if(this.getTemp() == otherReefer.getTemp()) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
