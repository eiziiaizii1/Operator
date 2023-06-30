package hw1;
// Name: AZİZ
// Surname: ÖNDER
// Student ID: 22050141021

enum OperatorType {
	Add, Subtract, Multiply, Divide, Value;
	
	String symbol() {
		switch (this) {
		// student code
			case Add : return " + ";
			case Subtract : return " - ";
			case Multiply : return " * ";
			case Divide : return " / ";
			case Value : return " ";
			default : return " ";
			
		}
	}
}

public class Operator {
	final double value;
	final OperatorType operatorType;
	final Operator leftChild;
	final Operator rightChild;
	
	Operator(double value) {
		// student code
		this.value = value;
		this.operatorType = OperatorType.Value;
		this.leftChild=null;
		this.rightChild=null;
	}
	
	Operator(OperatorType operatorType, Operator leftChild, Operator rightChild) {
		// student code
		this.operatorType = operatorType;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
		this.value = Double.NaN;
	}	
	
	boolean isLeaf() {
		// student code
		if(this.leftChild == null && this.rightChild == null) {
			return true;
		}
		return false;
	}
	
	double getValue() {
		// student code
		if (this.isLeaf()==true) {
			return this.value;
			
		}else {
			switch (this.operatorType) {
			case Add: return this.leftChild.getValue()+this.rightChild.getValue();
			case Subtract: return this.leftChild.getValue()-this.rightChild.getValue();
			case Multiply: return this.leftChild.getValue()*this.rightChild.getValue();
			case Divide: return this.leftChild.getValue()/this.rightChild.getValue();
			//case Value: return Double.NaN;
			default: return Double.NaN;	
			}
	
		}
	}
	
	@Override
	public String toString() {
		// student code
		if(this.isLeaf()==true) {
			return  ""+ this.getValue();
		}
			return "("+this.leftChild+ operatorType.symbol() +
					(this.rightChild.getValue()<0 ? "("+this.rightChild+")":this.rightChild)+")";
	}

}
