package AP.group30.StardewValley;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSplitter {
    public static void main(String[] args) {
        String inputImagePath = "/home/hamed/University/StardewValley/assets/item/Oak_Stage_5.png"; // Change to your image file path
        String outputDirPath = "trees";

        int tileWidth = 100;
        int tileHeight = 188;

        try {
            BufferedImage originalImage = ImageIO.read(new File(inputImagePath));

            int imgWidth = originalImage.getWidth();
            int imgHeight = originalImage.getHeight();

            int cols = imgWidth / tileWidth;
            int rows = imgHeight / tileHeight;

            File outputDir = new File(outputDirPath);
            if (!outputDir.exists()) {
                outputDir.mkdirs();
            }

            int count = 0;
            System.out.println(rows + " " + cols + " " + tileWidth + " " + tileHeight);
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    int tileX = x * tileWidth;
                    int tileY = y * tileHeight;

                    BufferedImage subImage = originalImage.getSubimage(tileX, tileY, tileWidth, tileHeight);
                    File outputFile = new File(outputDir, "tree(2)" + count + ".png");
                    ImageIO.write(subImage, "png", outputFile);

                    count++;
                }
            }

            System.out.println("Successfully split the image into " + count + " squares.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
