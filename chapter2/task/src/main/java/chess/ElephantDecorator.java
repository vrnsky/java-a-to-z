package chess;

/**
 * Created by Egor on 27.06.2016.
 */
public class ElephantDecorator extends FigureDecorator {

    private Figure figure;

    public ElephantDecorator(Figure figure) {
        this.figure = figure;
    }

    @Override
    public boolean canMove(Figure[][] figures, int fromX, int fromY, int toX, int toY) {
        return figure.canMove(figures, fromX, fromY, toX, toY);
    }

}
