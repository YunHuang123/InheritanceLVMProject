public class PhysicalHardDrives extends LVM{
    private int size;

    public PhysicalHardDrives(String name, int s){
        super(name);
        size = s;
    }
    public int getSize(){
        return size;
    }

    public void printInfo(){
        System.out.println(getName() + "[" + size + "G][" + getUuid() + "]");
    }
}
