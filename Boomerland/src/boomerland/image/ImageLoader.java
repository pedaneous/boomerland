package boomerland.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public BufferedImage loadImage(String file) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Resources/"+file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
}
