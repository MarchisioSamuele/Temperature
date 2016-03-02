import java.util.Vector;

/**
 * Created by inf.tomatisl2304 on 01/03/2016.
 */
class MyJGraph extends JGraph {
    double  mY, qY;
    double  mX, qX;

    MyJGraph(int width, int height) {
        super(width,height);
    }

    public void draw(int min, int max, Vector<String[]> rows) {
        min = min - 1;
        max = max + 1;
        mY = (0-getHeight())/((max-min)*1.0);
        qY = -(mY * (max));

        mX = (getWidth()-0)/((24 - (-1))*1.0) ;
        qX = -(mX * (-1));

        drawLine(convX(-1),convY(0),convX(24),convY(0));
        drawLine(convX(0),convY(min),convX(0),convY(max));

        for (int i=0;i<rows.size();i++) {
            int y1 = Integer.parseInt(rows.get(i)[1]);
            int y2 = Integer.parseInt(rows.get(i)[2]);

            drawRectangle(i * 2, y1, i * 2 + 1, y2, i % 2 == 0);
        }
    }
    private int convX(int x) {
        return (int) (x * mX + qX);}

    private int convY(int y) {
        return (int) (y * mY + qY);}

    private void drawRectangle(int x1,int y1,int x2,int y2, boolean fill) {
        drawRect(convX(x1), convY(y2), convX(x2) - convX(x1), convY(y1) - convY(y2), fill);
    }
}