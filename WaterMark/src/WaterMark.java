import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * Created by cowlog on 18-2-24.
 * Demo
 */
public class WaterMark{
    public static void main(String[] args) {
        String srcImgPath = "";
        String logoText = "";
        String targerPath = "";
        WaterMark.markByText(logoText, srcImgPath, targerPath);
    }

    static void markByText(String logoText, String srcImgPath,
                                  String targerPath) {
        markByText(logoText, srcImgPath, targerPath, null);
    }

    static void markByText(String logoText, String srcImgPath,
                                  String targerPath, Integer degree) {
        InputStream is = null;
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = buffImg.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg
                    .getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            if (null != degree) {
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2, (double) buffImg
                                .getHeight() / 2);
            }
            g.setColor(Color.red);
            g.setFont(new Font("宋体", Font.BOLD, 30));
            float alpha = 0.5f;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            g.drawString(logoText, 150, 300);
            g.dispose();
            os = new FileOutputStream(targerPath);
            ImageIO.write(buffImg, "JPG", os);
            System.out.println("ojbk");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
