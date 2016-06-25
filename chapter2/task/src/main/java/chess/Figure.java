package chess;

abstract class Figure {
	
	abstract boolean canMove(Figure[][] figures,int fromX, int fromY, int toX, int toY);
	
}