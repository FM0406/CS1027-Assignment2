
public class TrainCar {
	//Private instance variables
	private int weight;
	private String freight;
	
	//Constructor
	public TrainCar(int weight, String freight) {
		this.weight = weight;
		this.freight = freight;
	}
	
	//Getters
	public int getWeight() {
		return this.weight;
	}
	public String getFreight() {
		return this.freight;
	}
	
	//Setters
	public void setWeight(int newWeight) {
		this.weight = newWeight;
	}
	public void setFreight(String newFreight) {
		this.freight = newFreight;
	}
	
	//String representation
	public String toString() {
		return "<"+this.freight+", "+this.weight+">";
	}
	
	//Determine whether can connect
	public boolean canConnect(TrainCar other) {
		//Same weight
		if(this.weight == other.weight) {
			return true;
		}
		//Same freight type
		if(this.freight.equals(other.freight)) {
			return true;
		}
		return false;
	}
	
	//Determine whether equal
	public boolean equals(TrainCar other) {
		//Same weight and freight and is TrainCar object
		if(other instanceof TrainCar) {
			if(this.weight == other.weight && this.freight.equals(other.freight)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
