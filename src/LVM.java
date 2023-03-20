import java.util.UUID;
public class LVM {
    private String name;
    private UUID uuid;

    public LVM(String n){
        name = n;
        uuid = UUID.randomUUID();
    }

    public String getName(){
        return name;
    }

    public UUID getUuid(){
        return uuid;
    }
}
