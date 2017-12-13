import java.util.Scanner;
public class Cloth {
private int lowestTemp;
private int highestTemp;  
private boolean formal;
private int layer;
private String name;
private boolean suitable;
public static int u = 0;

public Cloth(int lowTemp, int highTemp, boolean formal, int layer, String name) {
	this.lowestTemp = lowTemp;
	this.highestTemp = highTemp;
	this.formal = formal;
	this.layer = layer;
	this.name = name;
	this.suitable = false;
}
public static String clothSuggestion(Cloth[] store, int temperature, boolean rain, boolean formal) {
	Cloth[] layer1 = new Cloth[9];
	Cloth[] layer2 = new Cloth[9];
	Cloth[] layer3 = new Cloth[9];
	int x = 0;
	int y = 0;
	int z = 0;
	String selection = "";
	if(temperature > 40) {
		System.out.println("people wont blame you for being naked:)");
	}
	if(temperature < -10) {
		System.out.println("it's too dangerous outside! Stay home and stay cozy!");
	}
	for(int i = 0; i < store.length; i++) {
		if(temperature >= store[i].lowestTemp && temperature <= store[i].highestTemp) {
			store[i].suitable = true;
		}
	}
	if(rain == true && formal == true) {
		for(int i = 0; i < store.length; i++) {
			if(store[i].suitable == true && store[i].formal == true) {
				if(store[i].layer == 1) {
					layer1[x] = store[i];
					x++;
				}
				if(store[i].layer == 2) {
					layer2[y] = store[i];
					y++;
				}
				if(store[i].layer == 3) {
					layer3[z] = store[i];
					z++;
				}
				selection += store[i].name + " ";
				if(u == 0 && temperature > 20) {
					System.out.println("Maybe you should wear shirt outside");
					u++;
				}
				if(u < 1) {
				System.out.println("Bring yourself an umbrella");
				}
				u++;
			}
		}
	}
	if (rain == false && formal == true) {
		for(int i = 0; i < store.length; i++) {
			if(store[i].suitable == true && store[i].formal == true) {
				if(store[i].layer == 1) {
					layer1[x] = store[i];
					x++;
				}
				if(store[i].layer == 2) {
					layer2[y] = store[i];
					y++;
				}
				if(store[i].layer == 3) {
					layer3[z] = store[i];
					z++;
				}
				selection += store[i].name + " ";
				if(u == 0 && temperature > 20) {
					System.out.println("Maybe you should wear shirt outside");
					u++;
				}
				u++;
			}
		}
	}
	if (rain == false && formal == false) {
		for(int i = 0; i < store.length; i++) {
			if(store[i].suitable == true) {
				if(store[i].layer == 1) {
					layer1[x] = store[i];
					x++;
				}
				if(store[i].layer == 2) {
					layer2[y] = store[i];
					y++;
				}
				if(store[i].layer == 3) {
					layer3[z] = store[i];
					z++;
				}
				selection += store[i].name + " ";
				if(u == 0 && temperature > 20) {
					System.out.println("Maybe you should wear T-shirt outside");
					u++;
				}
				u++;
			}
		}
	}
	if (rain == true && formal == false) {
		for(int i = 0; i < store.length; i++) {
			if(store[i].suitable == true) {
				if(store[i].layer == 1) {
					layer1[x] = store[i];
					x++;
				}
				if(store[i].layer == 2) {
					layer2[y] = store[i];
					y++;
				}
				if(store[i].layer == 3) {
					layer3[z] = store[i];
					z++;
				}
				selection += store[i].name + " ";
				if(u == 0 && temperature > 20) {
					System.out.println("Maybe you should wear T-shirt outside");
					u++;
				}
				if(u < 1) {
				System.out.println("Bring yourself an umbrella");
				}
				u++;
			}
		}
	}
	if (selection.equals("")) {
		System.out.println("it's time to purchase some new clothes!");
	}
	if(z > 0) {
	System.out.println("You should wear " + layer3[(int)(Math.random()*z)].name + " outside");
	}
	if(y > 0) {
	System.out.println("You should wear " + layer2[(int)(Math.random()*y)].name + " inside your outerwear");
	}
	if(x > 0) {
	System.out.println("You should wear " + layer1[(int)(Math.random()*x)].name + " to your skin");
	}
	return selection;
}
 
public static void main(String args[]) {
	Cloth Tshirt = new Cloth(-10, 40, false, 1, "Tshirt");
	Cloth tank = new Cloth(-10, 40, false, 1, "Tank");
	Cloth formalShirt = new Cloth(-10, 30, true, 1, "formalShirt");
	Cloth casualShirt = new Cloth(-10, 30, false, 1, "casualShirt");
	Cloth sweater = new Cloth(10, 20, false, 2, "sweater");
	Cloth hoodie = new Cloth(10, 20, false, 2, "hoodie");
	Cloth trenchCoat = new Cloth(5, 20, true, 3, "trenchCoat");
	Cloth coachJacket = new Cloth(5, 20, false, 3, "coachJacket");
	Cloth bikerJacket = new Cloth(5, 20, false, 3, "bikerJacket");
	Cloth bomberJacket = new Cloth(5, 20, false, 3, "bomberJacket");
	Cloth downJacket = new Cloth(-10, 5, false, 3, "downJacket");
	Cloth coat = new Cloth(-5, 10, true, 3, "coat");
	Cloth shearlingJacket = new Cloth(-5, 10, false, 3, "shearlingJacket");
	Cloth suitJacket = new Cloth(-5, 25, true, 3, "suitJacket");
	Cloth[] hailanzhijia = {Tshirt, tank, formalShirt, casualShirt, sweater, hoodie, 
							trenchCoat, coachJacket, bomberJacket, bikerJacket, downJacket, 
							coat, shearlingJacket, suitJacket};
	boolean xiba = false;
	do {
		Scanner sc = new Scanner(System.in);
	System.out.println("Please enter the temperature today.");
	int temperature = sc.nextInt();
	System.out.println("Will it rain today?");
	boolean ifRain = sc.nextBoolean();
	System.out.println("Is there any formal event today?");
	boolean ifFormal = sc.nextBoolean();
	clothSuggestion(hailanzhijia, temperature, ifRain, ifFormal);
	System.out.println("Are you satisfied with your cloth Selection?");
	xiba = sc.nextBoolean();
} while(xiba == false);
}
}
