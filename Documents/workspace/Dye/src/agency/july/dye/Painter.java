package agency.july.dye;

public class Painter {

	void paint (String what, String color) {

		String output;
		String[] command;
		
		RGB rgb = new RGB(color);
		System.out.println("Initial color >> " + rgb.getHex());

		double br = rgb.getBrightness(1.5)-0.5;

		double rest = rgb.setPureColor(67);
		System.out.println("Pure color >> " + rgb.getHex());
		
//		System.out.println("Brightness >> " + br);
//		System.out.println("Rest >> " + rest);
		br += rest*3/255;
//		System.out.println("Brightness >> " + br);
//*		
		double br3 = br*br; //*br
		double p1 = 1/br3;
		String part1 = String.format( "%.2f", p1 );
		String part2 = String.format( "%.2f", 1-p1 );
		
//		System.out.println("Brightness3 >> " + String.format( "%.2f", br3 ));
//		System.out.println("line >> " + part1);
//		System.out.println("sin >> " + part2);
//*		
		String greyImg = what + "_grey.png";
		String blackImg = what + "_black.png";
		String resultImg = what + "_" + color + ".png";
		
//		command = new String[]{"/opt/local/bin/convert", color_greyImg, blackImg, "-fx", "1-(((1-#" + color + ")*(1-u)*2.256)+(1-v))", resultImg};
		command = new String[]{"/opt/local/bin/convert", greyImg, blackImg, "-fx", "1-(((1-#" + rgb.getHex() + ")*(1-u)*2.256)+(1-("+ part1 + "*v+" + part2 + "*sin(v*pi/2))))", resultImg};
//		command = new String[]{"/opt/local/bin/convert", color_greyImg, blackImg, "-fx", "1-(((1-#" + color + ")*(1-("+ part1 + "*u+" + part2 + "*sin(v*pi/2)))*2.256)+(1-("+ part1 + "*v+" + part2 + "*sin(v*pi/2))))", resultImg};
		output = Executor.executeCommand(command);
		command = new String[]{"/opt/local/bin/composite", resultImg, what + ".jpg", resultImg};
		output = Executor.executeCommand(command);
		
		command = new String[]{"/opt/local/bin/convert", resultImg, "-fill", "#"+color, "-draw", "rectangle 58,32 181,155", resultImg};
		output = Executor.executeCommand(command);
		
		System.out.println(output);
		
		System.out.println("Done");
//*/
	}
	
}
