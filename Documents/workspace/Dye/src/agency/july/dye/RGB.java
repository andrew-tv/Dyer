package agency.july.dye;

public class RGB {
	
	int red = 0;
	int green = 0;
	int blue = 0;
	
	RGB () {}

	RGB (String hexColor) {
		red = Integer.parseInt(hexColor.substring(0, 2), 16);
		green = Integer.parseInt(hexColor.substring(2, 4), 16);
		blue = Integer.parseInt(hexColor.substring(4, 6), 16);		
	}

	double getBrightness() {
//		return Math.hypot(red, Math.hypot(green, blue))/255;
		return ((double) (red*red/4+green*green/2+blue*blue/4)) / 21675;
	}
	
	double getBrightness(double min) {
		double br = getBrightness();
		return br<min ? min : br;
	}
	
	void setPureColor() {
		int maxBrightness = Math.max(Math.max(red, green), blue);
		int minDarkness = 255-maxBrightness;
		red += minDarkness;
		green += minDarkness;
		blue += minDarkness;
	}
	
	int setPureColor(int edge) {
		int maxBrightness = Math.max(Math.max(red, green), blue);
		int minDarkness = 255-maxBrightness;
		if (minDarkness < edge) {
			red += minDarkness;
			green += minDarkness;
			blue += minDarkness;
			return edge - minDarkness;
		} else {
			red += edge;
			green += edge;
			blue += edge;			
			return 0;
		}
	}
	
/*	
	void setPureColor(int edge) {
		red += edge;
		green += edge;
		blue += edge;
		red = red > 255 ? 255 : red;
		green = red > 255 ? 255 : green;
		blue = red > 255 ? 255 : blue;
	}
*/	
	
	String getHex () {
		return Integer.toHexString(red*65536 + green*256 + blue);
	}
	
}
