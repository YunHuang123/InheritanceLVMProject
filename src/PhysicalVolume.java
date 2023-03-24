public class PhysicalVolume extends LVM{
    private int size;
    public PhysicalVolume(String name, int s){
        super(name);
        size = s;
    }

    public int getSize(){
        return size;
    }

    public void printInfo(){
        System.out.println(getName() + " [" + getSize() + "G][" + getUuid() + "]");
    }
}
