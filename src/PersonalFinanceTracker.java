import java.util.ArrayList;
import java.util.Scanner;

public class PersonalFinanceTracker{

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> expenseDescriptions = new ArrayList<>();
        ArrayList<Double> expenses = new ArrayList<>();
        ArrayList<String> expenseCategories = new ArrayList<>();
        ArrayList<Double> incomes = new ArrayList<>();

        while (true){
            System.out.println("1-Add Income");
            System.out.println("2-Add Expense");
            System.out.println("3-View Total Report");
            System.out.println("4-List Expenses by Category");
            System.out.println("5-Exit");
            System.out.print("Please make a selection : ");

            int choose = scanner.nextInt();
            scanner.nextLine();
            if (choose==1){
                addIncome(incomes,scanner);
            }else if (choose == 2) {
                addExpense(scanner,expenses,expenseDescriptions,expenseCategories);
            } else if (choose == 3) {
               viewTotalReport(incomes,expenses);
            } else if (choose == 4) {
                listExpenseByCategory(expenses,expenseDescriptions,expenseCategories,scanner);
            } else if (choose == 5) {
                System.out.println("Exiting from program...");
                break;
            }

        }

    }

    public static void addIncome(ArrayList<Double> incomes,Scanner scanner){
        System.out.println("How much money you want to add : ");
        double amount = scanner.nextDouble();
        if (amount>0){
            incomes.add(amount);
            System.out.println("Income Added ! " + amount);
        }else {
            System.out.println("Invalid income! Please enter a positive number");
        }
    }

    public static void addExpense(Scanner scanner,ArrayList<Double> expenses, ArrayList<String> expenseDescription, ArrayList<String> expenseCategory){
        System.out.print("How much your expense : ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Can you description this expense : ");
        String description = scanner.nextLine();
        System.out.println("What is the category for this expense : ");
        String category = scanner.nextLine();

        if (amount>0){
            expenses.add(amount);
            expenseDescription.add(description);
            expenseCategory.add(category);
            System.out.println("Expense added : " + amount + " in category " + category + " with description " + description );
        }else {
            System.out.println("Please enter a positive number");
        }
    }

    public static void viewTotalReport(ArrayList<Double> incomes, ArrayList<Double> expenses){
       double totalIncome = 0;
       for (Double income:incomes){
           totalIncome = totalIncome+income;
       }

       double totalExpense=0;
       for (Double expense : expenses){
           totalExpense= totalExpense+expense;
       }

       double balance = totalIncome-totalExpense;

        System.out.println("_______Tota Report_______");
        System.out.println("Total Income : " + totalIncome);
        System.out.println("Total Expense : " + totalExpense);
        System.out.println("Balance : " + balance);
        System.out.println("--------------------------");

    }

    public static void listExpenseByCategory(ArrayList<Double> expenses,ArrayList<String> expenseDescription,ArrayList<String> expenseCategories ,Scanner scanner){
        System.out.println("Enter a Category Name : ");
        String category = scanner.nextLine();
        for (int i=0;i<expenseCategories.size();i++){
            if (expenseCategories.get(i).equalsIgnoreCase(category)) {
                System.out.println("Expense : " + expenses.get(i) + " Description : " + expenseDescription.get(i));
                return;
            }
        }
        System.out.println("No expense found for this category");
    }

}