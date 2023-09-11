package blog;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author hyy
 * @Classname ImageGenerator
 * @Description TODO
 * @Date 2023/9/11 9:59:25
 */
public class ImageGenerator {
    public static void main(String[] args) {
        String text = "你好，世界！"; // 要显示的文字
        String backgroundImageFilePath = "src/main/java/blog/bg.png"; // 默认背景图片的文件路径
        String outputFilePath = "src/main/java/blog/test.png"; // 生成的图片的输出路径

        ImageGenerator.generateImage(text, backgroundImageFilePath, outputFilePath);
    }
    public static void generateImage(String text, String backgroundImageFilePath, String outputFilePath) {
        try {
            // 读取背景图片
            BufferedImage backgroundImage = ImageIO.read(new File(backgroundImageFilePath));

            // 创建一个Graphics2D对象，用于在背景图片上绘制文字
            Graphics2D g2d = backgroundImage.createGraphics();

            // 设置字体和颜色
            Font font = new Font("宋体", Font.PLAIN, 36).deriveFont(Font.PLAIN);
            g2d.setFont(font);
            g2d.setColor(Color.BLACK); // 设置文字颜色

            // 获取文字的尺寸
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            int textHeight = fm.getHeight();

            // 计算文字的位置使其居中显示
            int x = (backgroundImage.getWidth() - textWidth) / 2;
            int y = (backgroundImage.getHeight() + textHeight) / 2;

            // 在指定位置绘制文字
            g2d.drawString(text, x, y);

            // 释放资源
            g2d.dispose();

            // 保存生成的图片
            ImageIO.write(backgroundImage, "png", new File(outputFilePath));

            System.out.println("图片生成成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

