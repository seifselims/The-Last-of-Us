package model.world;

abstract public class Cell { 
private boolean isVisible;
public void setVisible(boolean isVisible) {
	this.isVisible = isVisible;
}

public boolean isVisible() {
	return isVisible;
}
public Cell() {
	
}
}
