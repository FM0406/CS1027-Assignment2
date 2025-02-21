/*
CS 1027B – Assignment 2
Name: Felix Ma
Student Number: 251413859
Email: fma56@uwo.ca
Created: February 21, 2025
*/

public class Train {
	//Private instance variables
	private DoubleNode<TrainCar> locomotive;
	private DoubleNode<TrainCar> caboose;
	
	//Constructor
	public Train() {
		this.locomotive = null;
		this.caboose = null;
	}
	
	//Getters
	public DoubleNode<TrainCar> getLocomotive(){
		return this.locomotive;
	}
	public DoubleNode<TrainCar> getCaboose(){
		return this.caboose;
	}
	
	//Add car to train
	public void addCar(TrainCar car) {
		//If it's the first car being added
		if(locomotive == null) {
			locomotive = new DoubleNode<>(car);
			caboose = locomotive;
		}else {
			//Create newNode to add
			DoubleNode<TrainCar> newNode = new DoubleNode<>(car);
			//If can't connect throw TrainException
			if(!(caboose.getElement().canConnect(car))) {
				throw new TrainException(car+" could not be added.");
			}else {
				caboose.setNext(newNode); //Set current caboose to point forward to newNode
				newNode.setPrevious(caboose); //newNode points back to current caboose 
				caboose = newNode; //newNode becomes new caboose
			}
		}
		
	}
	
	//Try to add car to train
	public boolean tryAddCar(TrainCar car) {
		try {
			addCar(car);
			return true;
		}catch (TrainException e) {
			return false;
		}
	}
	
	//Remove car
	public void removeCar(TrainCar car) {
		DoubleNode<TrainCar> current = locomotive;
		
		//Go through the list
		while(current != null) {
			if(current.getElement().equals(car)) {
				//Case 1: First car
				if(current == locomotive) {
					//If its the only car
					if(locomotive == caboose) {
						locomotive = null;
						caboose = null;
					}else {
						locomotive = current.getNext();
						locomotive.setPrevious(null);
					}
				}
				//Case 2:Last car
				else if(current == caboose) {
					caboose = caboose.getPrevious();
					caboose.setNext(null);
				}
				//Case 3: Middle of locomotive and removing it would not affect the connection
				else {
	                if (!current.getPrevious().getElement().canConnect(current.getNext().getElement())) {
	                    throw new TrainException(car+" could not be removed.");
	                }
	                current.getPrevious().setNext(current.getNext());
	                current.getNext().setPrevious(current.getPrevious());
	            }
				
				return;
			}
			current = current.getNext();
		}
		throw new TrainException(car+" could not be removed.");
	}
	
	//Try to remove car
	public boolean tryRemoveCar(TrainCar car) {
		try {
			removeCar(car);
			return true;
		}catch(TrainException e) {
			return false;
		}
	}
	
	//String representation
	@Override
	public String toString() {
		String train = ""; 
		if(locomotive == null) {
			return "The train is empty.";
		}else {
			DoubleNode<TrainCar> current = locomotive;
			//Add the string representation of each car to the String
			while(current != null) {
				train += current.getElement().toString();
				if(current.getNext() != null) {
					train += ", ";
				}		
				current = current.getNext();
			}
		}
		return train;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
