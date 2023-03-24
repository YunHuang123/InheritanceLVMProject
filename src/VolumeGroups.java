import java.util.ArrayList;
public class VolumeGroups extends LVM{
    private ArrayList<PhysicalVolume> pv;
    private ArrayList<LogicalVolume> lv;
    private int size;

    public VolumeGroups(String name, int s){
        super(name);
        pv = new ArrayList<PhysicalVolume>();
        lv = new ArrayList<LogicalVolume>();
        size = s;
    }

    public int getSize(){
        return  size;
    }

    public void addToLV(LogicalVolume l){
        lv.add(l);
    }

    public void addToPV(PhysicalVolume p){
        pv.add(p);
    }

    public int pvTotal(){
        int total = 0;
        for (int i = 0; i < pv.size(); i ++){
            total += pv.get(i).getSize();
        }
        return total;
    }

    public int lvTotal(){
        int total = 0;
        for (int i = 0; i < lv.size(); i ++){
            total += lv.get(i).getSize();
        }
        return total;
    }

    public void pvPrintInfo(){
        System.out.println("total: [" + pvTotal() + "G][");
    }
}
