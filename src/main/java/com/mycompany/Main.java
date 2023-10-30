package com.mycompany;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Employee> emps = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        Player player;
        Shop shop = null;
        int day = 1;

        System.out.print("Bienvenidx!, ¿Cuál es tu nombre?: ");
        player = new Player(inp.next());
        System.out.println("<-------------------------->");
        System.out.println("Vamos a crear tu tienda " + player.getName() + "!");
        System.out.print("\nDame el nombre de tu tienda: ");
        String name = inp.next();
        char opc = 'a';

        while (opc != 'q'){
            System.out.println("\n¿Qué tipo de empleado quieres agregar? \n\t\ta.Tiempo Completo b.Medio tiempo \n\t\tq.Salir");
            char opc2 = inp.next().charAt(0);

            switch (opc2){
                case 'a' -> {
                    System.out.print("Dame el nombre del empleado: ");
                    String empName = inp.next();

                    System.out.print("Dame su salario mensual: $");
                    double sal = inp.nextDouble();

                    Employee employee = new EmployeeFull(empName, sal);

                    emps.add(employee);
                }
                case 'b' -> {
                    System.out.print("Dame el nombre del empleado: ");
                    String empName = inp.next();

                    System.out.print("Dame su salario por hora: $");
                    double sal = inp.nextDouble();

                    Employee employee = new EmployeePart(empName, sal);

                    emps.add(employee);
                }
                case 'q' -> {
                    if (!emps.isEmpty()){
                        System.out.println("\nNúmero de empleados en la lista: " + emps.size());
                        System.out.println("Continuemos...");
                        opc = 'q';
                    }else {
                        System.out.println("No has ingresado ningun empleado, por favor ingresa al menos 1.");
                    }
                }
            }
        }
        shop = new Shop(name, player);
        shop.setEmployees(emps);
        player.setShop(shop);

        System.out.println("\nVamos a agregar los productos de ["+shop.getName()+"]!");

        char opc3 = 'a';
        while (opc3 != 'n'){
            System.out.print("\nDame el nombre de tu producto: ");
            String nameProd = inp.next();

            System.out.print("Dame precio del producto: $");
            double priceProd = inp.nextDouble();

            Product prod = new Product(nameProd, priceProd);
            products.add(prod);

            System.out.println("\nQuieres agregar mas productos? (\u001B[32mS/N\u001B[0m)");
            opc3 = inp.next().charAt(0);
        }
        shop.setProducts(products);

        while (true){
            Scanner inpc = new Scanner(System.in);
            List<Integer> opcCC = new ArrayList<>();
            int pointsAdded = 0;
            int pointsSubtracted = 0;
            int level = 1;
            char opcC2;
            boolean gameOut = false;
            Customer cus = new Customer();

            System.out.println("<--------DÍA "+ day +"-------->");

            while (!gameOut) {
                System.out.println("\u001B[32mUn nuevo cliente está entrando a "+ shop.getName() +"!\u001B[0m\n");

                System.out.println("\u001B[36mHola!, ¿Qué tal?\u001B[0m");
                cus.askProduct(shop.getProducts());

                System.out.println("\nElige el producto que ordenó el cliente \u001B[36m(1-"+ shop.getProducts().size() +")\u001B[0m:");

                // Display the coffee options
                for (int i = 0; i < products.size(); i++) {
                    System.out.println("\u001B[33m" + (i + 1) + ". \u001B[0m" + products.get(i).getName());
                }
                System.out.print("\n");

                // Initialize isCorrectChoice based on the current customer's order
                boolean[] isCorrectChoice = new boolean[shop.getProducts().size()];
                Product[] currentOrder = cus.getOrder().getProducts();
                for (Product product : currentOrder) {
                    for (int j = 0; j < shop.getProducts().size(); j++) {
                        if (product.getName().equalsIgnoreCase(shop.getProducts().get(j).getName())) {
                            isCorrectChoice[j] = true;
                        }
                    }
                }

                // Collect the customer's choices
                int numOptions = currentOrder.length;
                do {
                    for (int i = 0; i < numOptions; i++) {
                        System.out.print("\u001B[36mOpción " + (i + 1) + ": \u001B[0m");
                        int choice = inpc.nextInt();
                        if (choice < 1 || choice > shop.getProducts().size()) {
                            System.out.println("\u001B[31mOpción no válida. Elige una opción válida.\u001B[0m");
                            i--;
                        } else {
                            opcCC.add(choice);
                        }
                    }

                    System.out.println("\nConfirmar la orden: (\u001B[32mS/N\u001B[0m):");
                    for (int choice : opcCC) {
                        System.out.println("\u001B[33m" + shop.getProducts().get(choice - 1).getName() + "\u001B[0m");
                    }

                    opcC2 = inpc.next().charAt(0);

                    if (opcC2 == 'n' || opcC2 == 'N') {
                        opcCC.clear();
                    }
                } while (opcC2 != 's' && opcC2 != 'S');

                // Check if the choices were correct and update points accordingly
                boolean choicesCorrect = true;

                for (int choice : opcCC) {
                    if (isCorrectChoice[choice - 1]) {
                        pointsAdded += 2;
                    } else {
                        pointsSubtracted += 1;
                        choicesCorrect = false;
                        System.out.println("\u001B[31m¡Yo no quería un " + shop.getProducts().get(choice - 1).getName() + "!\u001B[0m");
                    }
                }

                if (choicesCorrect) {
                    System.out.println("\u001B[32m¡Es justo lo que ordené!\u001B[0m");
                    System.out.println("\u001B[36mPuntos sumados: " + pointsAdded + "\u001B[0m");
                } else {
                    System.out.println("\u001B[31mPuntos restados: " + pointsSubtracted + "\u001B[0m");
                }

                int totalPoints = pointsAdded - pointsSubtracted;
                System.out.println("\u001B[36mPuntaje total: " + totalPoints + "\u001B[0m");

                if (totalPoints % 10 == 0) {
                    level++;
                    System.out.println("\u001B[36m¡Has subido de nivel! Nivel actual: " + level + "\u001B[0m");
                }

                opcCC.clear();
                inpc.nextLine();
                System.out.println("\n¿Deseas atender a otro cliente? (\u001B[32mS/N\u001B[0m): ");
                String response = inpc.nextLine();

                if (!response.equalsIgnoreCase("S")) {
                    gameOut = true;
                }
            }

            System.out.println("\nDía " + day + " completado!, muy bien!\n¿Quieres seguir jugando?... (\u001B[32mS/N\u001B[0m)");
            char op = inp.next().charAt(0);
            day++;

            if(op == 'n' || op == 'N'){
                System.out.println("Saliendo del juego...");
                System.exit(0);
            }

        }
    }
}
