package ToDoApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> tasks = new ArrayList<>();
    static ArrayList<Boolean> completed = new ArrayList<>();
    static final String FileName = "tasks.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadTaskFromFile();
        while(true)
        {
            System.out.println("===To-Do List===");
            System.out.println("1 -> Add Task");
            System.out.println("2 -> View Task");
            System.out.println("3 -> Delete Task");
            System.out.println("4 -> Mark as Done");
            System.out.println("5 -> Exit");
            System.out.println("Enter Your Choice");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1 :
                    System.out.println("Enter Your Task");
                    String task = sc.nextLine();
                    tasks.add(task);
                    completed.add(false);
                    System.out.println("✅Task Added");
                    break;
                case 2:
                    System.out.println("\uD83D\uDCCB Your Tasks:");
                    if(tasks.isEmpty())
                    {
                        System.out.println("No Task Yet!");
                    }
                    else
                    {
                        for(int i=0; i<tasks.size(); i++)
                        {
                            String status = completed.get(i)?"✅":"❌";
                            System.out.println((i+1)+". "+tasks.get(i)+" "+status);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter Task number to delete");
                    int deleteIdx = sc.nextInt();
                    if(deleteIdx>=1 && deleteIdx<=tasks.size())
                    {
                        tasks.remove(deleteIdx-1);
                        completed.remove(deleteIdx-1);
                        System.out.println("🗑️ Task deleted.");
                    }
                    else
                    {
                        System.out.println("❌ inValid Task Number");
                    }
                    break;
                case 4:
                    System.out.println("Enter task number to mark as complete: ");
                    int doneIndex = sc.nextInt();
                    if(doneIndex>=1 && doneIndex<=tasks.size())
                    {
                        completed.add(doneIndex-1,true);
                        System.out.println("\uD83C\uDFAF Task Marked as complete: ");
                    }
                    else
                    {
                        System.out.println("\uD83D\uDC4B Invalid Task Number: ");
                    }
                    break;
                case 5:
                    saveTaskToFile();
                    System.out.println("\uD83D\uDC4B Exiting..... Bye!");
                    return;
                default:
                    System.out.println("Please choose correct option");
                    break;
            }
        }
    }

    static void loadTaskFromFile(){
        try
        {
            File file = new File(FileName);
            if(!file.exists()) return;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine())!=null)
            {
                String[] parts = line.split(",",2);
                tasks.add(parts[0]);
                completed.add(Boolean.parseBoolean(parts[1]));
            }
            reader.close();
        }
        catch (IOException e)
        {
            System.out.println("❌ Error loading tasks: " + e.getMessage());
        }
    }

    static void saveTaskToFile(){
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FileName));
            for(int i=0; i<tasks.size(); i++)
            {
                writer.write(tasks.get(i)+","+completed.get(i));
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("❌ Error saving tasks: " + e.getMessage());
        }
    }

}
