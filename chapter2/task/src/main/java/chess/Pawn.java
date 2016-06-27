package chess;

import static java.lang.Math.abs;

public class Pawn extends Figure {


	boolean canMove(Figure[][] figure, int fromX, int fromY, int toX, int toY) {
		boolean result = false;
		if(abs(toX - fromX) > 2) result = false;
		if(toX > fromX) {
			for (int index = fromX; index <= toX; index++) {
				if (figure[index][fromY] == null)
					result = true;
				else 
					result = false;
			}
		}
		else if(toX < fromX) {
			for(int index = fromX; index >= toX; index--) {
				if (figure[index][fromY] == null)
					result = true;
				else 
					result = false;
			}
		}
		return result;
	}
	
}