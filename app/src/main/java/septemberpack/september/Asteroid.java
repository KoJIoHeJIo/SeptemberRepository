package septemberpack.september;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import junit.framework.TestCase;

import java.util.Random;

/**
 * Created by Vlady on 22.10.2015.
 */

// Данный класс реализует отрисовку астероидов

public class Asteroid {

    Bitmap bitmap;

    // Первый астероид
    private int line1x;
    private int line1y;

    // Второй астероид
    private int line2x;
    private int line2y;

    // Третий астероид
    private int line3x;
    private int line3y;

    private Random random;

    public Asteroid(Bitmap bmp){
        this.bitmap = bmp;
        random = new Random();

        line1x = random.nextInt(880);
        line2x = random.nextInt(880);
        line3x = random.nextInt(880);

        line1y = -random.nextInt(300);
        line2y = -random.nextInt(300)-400; // За пределом экрана минус 400
        line3y = -random.nextInt(300)-800; // За пределом экрана минус 800
    }

    public void draw(Canvas canvas){

        canvas.drawBitmap(bitmap, line1x, line1y, null); // Первая линия
        canvas.drawBitmap(bitmap, line2x, line2y, null); // Вторая линия
        canvas.drawBitmap(bitmap, line3x, line3y, null); // Третья линия
    }

    public void update(){
        if(line1y > 1400) {
            line1y = -80;
            line1x = random.nextInt(880);
        }
        else if(line2y > 1400) {
            line2y = -80;
            line2x = random.nextInt(880);
        }
        else if(line3y > 1400) {
            line3y = -80;
            line3x = random.nextInt(880);
        }

        line1y += GamePanel.speed;
        line2y += GamePanel.speed;
        line3y += GamePanel.speed;
    }

    /*
    * Методы возвращают прямоугольную область астероида по его координатам, для проверки столкновения с кораблем
    * Реализацию можно было уместить в один метод с четырьмя параметрами, но его вызов был бы нечитаемым
    * Поскольку присутствуют всего три астероида, мы имеем возможность сделать для каждого свой метод
    */
    public Rect getAsteroid1(){
        return new Rect(line1x, line1y, line1x + 120, line1y + 120);
    }

    public Rect getAsteroid2(){
        return new Rect(line2x, line2y, line2x + 120, line2y + 120);
    }

    public Rect getAsteroid3(){
        return new Rect(line3x, line3y, line3x + 120, line3y + 120);
    }
}
