package model.world;

abstract public class Cell { 
private static boolean isVisible;
public static void setVisible(boolean isVisible) {
	isVisible = isVisible;
}

public static boolean isVisible() {
	return isVisible;
}
public Cell() {
	isVisible = false;
}
}
