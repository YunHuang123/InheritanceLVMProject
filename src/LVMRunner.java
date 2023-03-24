import java.util.Scanner;
import java.util.ArrayList;
public class LVMRunner {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the LVM system");
        System.out.print("cmd#: ");
        String input = s.nextLine();
        ArrayList<PhysicalHardDrives> hardDrives = new ArrayList<PhysicalHardDrives>();
        ArrayList<PhysicalVolume> pVolume = new ArrayList<PhysicalVolume>();
        while (!input.equals("exit")){
            if (input.contains("install-drive")){
                String[] elements = input.split(" ");
                PhysicalHardDrives hd = new PhysicalHardDrives(elements[1], Integer.parseInt(elements[2].substring(0, elements[2].length() - 1)));
                hardDrives.add(hd);
                System.out.println("Drive " + elements[1] + " installed");
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
            if (input.equals("list-drives")){
                for (int i = 0; i < hardDrives.size(); i ++){
                    hardDrives.get(i).printInfo();
                }
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
            if (input.contains("pvcreate")){
                String[] elements = input.split(" ");
                int size = 0;
                for (int i = 0; i < hardDrives.size(); i ++){
                    if (hardDrives.get(i).getName().equals(elements[2])){
                        size = hardDrives.get(i).getSize();
                    }
                }
                PhysicalVolume pv = new PhysicalVolume(elements[1], size);
                pVolume.add(pv);
                System.out.println(elements[1] + " created");
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
            if (input.equals("pvlist")){
                for (int i = 0; i < pVolume.size(); i ++){
                    pVolume.get(i).printInfo();
                }
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
            if (input.contains("vgcreate")){
                String[] elements = input.split(" ");
                int size = 0;
                for (int i = 0; i < pVolume.size(); i ++){
                    if (pVolume.get(i).getName().equals(elements[2])){
                        size = pVolume.get(i).getSize();
                    }
                }
                VolumeGroups vg = new VolumeGroups(elements[1], size);

            }
        }
    }
}

