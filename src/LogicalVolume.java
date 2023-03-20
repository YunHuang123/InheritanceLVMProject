public class LogicalVolume extends LVM{
    private int size;

    public LogicalVolume(String name, int s){
        super(name);
        size = s;
    }

    public int getSize(){
        return size;
    }
}
