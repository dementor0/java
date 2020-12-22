import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
    private final BufferedImage image;            //final - не может иметь подклассов  Класс BufferedImage управляет
                                                  //изображением, содержимое которого можно записать.
    public BufferedImage getImage() {
        return image;
    }

    public JImageDisplay(int w, int h){             //w-ширина h-высота
        if (w <= 0)
            throw new IllegalArgumentException("w must be > 0; got " + w); //Вызывает исключение

        if (h <= 0)
            throw new IllegalArgumentException("h must be > 0; got " + h); //Вызывает исключение

        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);       //переопределяем объект BufferedImage новым
                                                                           //изображением с этой шириной и высотой TYPE_INT_RGB-определяет цвет пикселя
        Dimension dimension = new Dimension(w, h);                              // передаем наши значения вобьект java.awt.Dimension что бы отображалось изображение целиком

        super.setPreferredSize(dimension);
    }
    @Override                                                                     // переопредление метода
    protected void paintComponent(Graphics g) {                                   //protected- модификатор что бы класс был виден только в пределах пакета или же в пределах всех классов наследников
        super.paintComponent(g);

        g.drawImage (image, 0, 0, image.getWidth(), image.getHeight(), null); //После вызова версии суперкласса, можно нарисовать изображение в компоненте, используя следующую операцию
    }

    public void clearImage() {
        Graphics2D imageGraphics = image.createGraphics();                          // создает новый графический обьект
        imageGraphics.setColor(new Color(0, 0, 0));

        imageGraphics.fillRect(0, 0, image.getWidth(), image.getHeight());     //Заливка прямоугольника черным цветом
    }

    public void drawPixel (int x, int y, int rgbColor){
        image.setRGB(x, y, rgbColor);                                                          //изменяем цвет пикселя в нужный нам, используя параметры подаваемые на вход
    }
}
