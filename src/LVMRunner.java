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
        ArrayList<VolumeGroups> vGroups = new ArrayList<VolumeGroups>();
        while (!input.equals("exit")){
            ArrayList<String> existedNames = new ArrayList<String>();
            String[] elements = new String[3];
            if (input.contains("install-drive") && !existedNames.contains(elements[1])){
                elements = input.split(" ");
                PhysicalHardDrives hd = new PhysicalHardDrives(elements[1], Integer.parseInt(elements[2].substring(0, elements[2].length() - 1)));
                existedNames.add(elements[1]);
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
            else if (input.contains("pvcreate") && !existedNames.contains(elements[1])){
                elements = input.split(" ");
                int size = 0;
                for (int i = 0; i < hardDrives.size(); i ++){
                    if (hardDrives.get(i).getName().equals(elements[2])){
                        size = hardDrives.get(i).getSize();
                    }
                }
                PhysicalVolume pv = new PhysicalVolume(elements[1], size);
                existedNames.add(elements[1]);
                pVolume.add(pv);
                System.out.println(elements[1] + " created");
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
            else if (input.equals("pvlist")){
                for (int i = 0; i < pVolume.size(); i ++){
                    pVolume.get(i).printInfo();
                }
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
            else if (input.contains("vgcreate")){
                elements = input.split(" ");
                int size = 0;
                for (int i = 0; i < pVolume.size(); i ++){
                    if (pVolume.get(i).getName().equals(elements[2])){
                        size = pVolume.get(i).getSize();
                    }
                }
                VolumeGroups vg = new VolumeGroups(elements[1], size);
                existedNames.add(elements[1]);
                vGroups.add(vg);
                System.out.println(elements[1] + " created");
                System.out.print("cmd#: ");
                input = s.nextLine();
            }
            else if (input.contains("vgextend")){
                elements = input.split(" ");

            }
            else{
                if (input.contains("install") || input.contains("create")){
                    System.out.println("Name already existed.");
                    System.out.print("cmd#: ");
                    input = s.nextLine();
                }
                else{
                    System.out.println("Command does not exist.");
                    System.out.print("cmd#: ");
                    input = s.nextLine();
                }
            }
        }
    }
}

