import java.util.ArrayList;
public class VolumeGroups extends LVM{
    private ArrayList<PhysicalVolume> pV;
    private ArrayList<LogicalVolume> lV;

    public VolumeGroups(String name){
        super(name);
        lV = new ArrayList<LogicalVolume>();
    }

    public void addToLV(LogicalVolume l){
        lV.add(l);
    }

    public void addToPV(PhysicalVolume p){
        pV.add(p);
    }

}
