import java.util.Scanner;
import java.util.ArrayList;
public class LVMRunner {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the LVM system");
        System.out.print("cmd#: ");
        String input = s.nextLine();
        ArrayList<PhysicalHardDrives> hardDrives = new ArrayList<PhysicalHardDrives>();
        while (!input.equals("exit")){
            if (input.contains("install-drive")){
                String[] elements = input.split(" ", 3);
                PhysicalHardDrives hd = new PhysicalHardDrives(elements[1], Integer.parseInt(elements[2].substring(0, elements[2].length() - 1)));
                hardDrives.add(hd);
                System.out.println("Drive " + elements[1] + " installed");
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
            else if (input.equals("list-drives")){
                for (int i = 0; i < hardDrives.size(); i ++){
                    hardDrives.get(i).printInfo();
                }
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
        }
    }
}
