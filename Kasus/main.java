package Kasus;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	private static final String[] Jenis_Kopi = {
	        "Americano / Long Black ", "Avocado Coffee", "Latte", "Cappuccino", "Caramel Latte"
	    };
	
	private static final String[] Rasa_Kopi = {
	        "Strong","Lite"
	    };
	
	private static final String[] Topping_Kopi = {
			"Reguler","Large"
	    };
	
	
	private static final int[][] hargaKopi = {
	    // Harga untuk Americano / Long Black (Strong, Lite)
	    {16000, 12000, 19000, 15000},
	    
	    // Harga untuk Avocado Coffee (Strong, Lite)
	    {24000, 18000, 27000, 21000},
	    
	    // Harga untuk Latte (Strong, Lite)
	    {21000, 18000, 24000, 21000},
	    
	    // Harga untuk Cappuccino (Strong, Lite)
	    {19000, 17000, 22000, 20000},
	    
	    // Harga untuk Caramel Latte (Strong, Lite)
	    {24000, 22000, 27000, 25000}
	};

	Scanner sc = new Scanner(System.in);
	ArrayList<Order> Kopi = new ArrayList<>();
	
	public int cek() {
		
		int salah = 0;
		try {
			salah = sc.nextInt();	
		}catch(Exception e) {
			salah = -1;
			System.out.println("Input must be numeric!");
		}
		sc.nextLine();
		return salah;
	}
	public static boolean isOrderNumberExist(ArrayList<Order> orders, int number) {
	    for (Order order : orders) {
	        if (order.getNoOrder() == number) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void Order() {
		int number,Type,rasa,topping,qty;	
		
		do {
			System.out.printf("Input 'No Order' [1-10000] : ");
			number = sc.nextInt();
			System.out.println();
		}while(!(number>=1) || !(number <=10000) || isOrderNumberExist(Kopi, number));
		

		do {
			System.out.printf("Type (1. Americano / Long Black 2. Avocado Coffee  3.Latte 4. Cappuccino 5. Caramel Latte): ");
			Type = sc.nextInt();
		
			 if (Type >= 1 && Type <= Jenis_Kopi.length) {
				 	String Selectedtype = Jenis_Kopi[Type - 1];
	                System.out.println("Anda memilih tipe Kopi: " + Selectedtype);
	            	System.out.println();
	            } else if (Type != 0) {
	                System.out.println("Pilihan tidak valid.");
	            }
		}while(!(Type>=1) || !(Type<=5));			
		
		do {
			System.out.printf("Strong/Lite (1. Strong 2. Lite) : ");
			rasa = sc.nextInt();
			 if (rasa >= 1 && rasa <= Rasa_Kopi.length) {
	                String selectedIceCup = Rasa_Kopi[rasa - 1];	             
	                System.out.println("Anda memilih Rasa Kopi: " + selectedIceCup);
	            	System.out.println();
	            } else if (rasa != 0) {
	                System.out.println("Pilihan tidak valid.");
	            }
		}while(!(rasa>=1) || !(rasa<=2));			
		
		do {
			System.out.printf("Topping (1. Reguler 2. large) : ");
			topping = sc.nextInt();
			 if (topping >= 1 && topping <= Topping_Kopi.length) {
	                String selectedToppingkopi = Topping_Kopi[topping - 1];                
	                System.out.println("Anda memilih topping " + selectedToppingkopi);
	            	System.out.println();
	            } else if (topping != 0) {
	                System.out.println("Pilihan tidak valid.");
	            }
		}while(!(topping>=1) || !(topping<=2));			
		do {
			System.out.printf("Quantity : ");
			qty = sc.nextInt();
			System.out.println();
		}while(!(qty>=1));
		
		int harga= hargaKopi[Type - 1][rasa - 1 + (topping - 1) * 2];
		int total = harga * qty;

		Order iceOrder = new Order(number, Jenis_Kopi[Type-1], Rasa_Kopi[rasa-1], Topping_Kopi[topping-1], qty, harga, total);
		Kopi.add(iceOrder);
	}
	
	public void history() {
		int totalqty = 0;
		if(Kopi.isEmpty()) {
			 System.out.println("There was no order.");
			 sc.nextLine();
		 }else {
			 System.out.println("=============================================================================================================");
			 System.out.printf("|%-3s|%-8s|%-23s|%-13s|%-13s|%-13s|%-9s|%-6s|\n",
			 "No","No Order", "Coffee Type", "Strong/Lite", "Reguler/Large", "Quantity", "Price", "Total");
			 System.out.println("=============================================================================================================");
			 int i = 0;
			 for (Order o : Kopi) {
				 i++;
				 totalqty += o.getQty();
				 System.out.printf("|%-3s|%-8s|%-23s|%-13s|%-13s|%-13s|%-9s|%-6s|\n",i,o.getNoOrder(), o.getCoffetype(), o.getFlavor(), o.getTopping(), o.getQty(), o.getPrice(), o.getTotal());
				 System.out.println("=========================================================================================================");
				 
			 }System.out.println("JumlahItem :" + totalqty);
	}
	}
	public main() {
		// TODO Auto-generated constructor stub
		int pilih = 0;
		
		do {
		System.out.println("1. Order");
		System.out.println("2. OrderHistory");
		System.out.println("3. Exit");

			
		do {
			System.out.println("Chosse>>");
			pilih = cek();
			
		}while (pilih<1 || pilih>5);
		switch(pilih) {
		case 1 :
			Order();
			break;
		case 2 :
			history();
			break;
		case 3 :
			break;
		}
			
		}while( pilih !=3 );
		
		}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
