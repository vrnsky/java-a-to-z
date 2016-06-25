package chess;

public class Pawn extends Figure {


	boolean canMove(Figure[][] figure, int fromX, int fromY, int toX, int toY) {
		boolean result = false;
		if(toX - fromX > 2) result = false;
		else {
			for (int index = fromX; index <= toX; index++) {
				if (figure[index][fromY] == null)
					result = true;
			}
		}
		return result;
	}
}