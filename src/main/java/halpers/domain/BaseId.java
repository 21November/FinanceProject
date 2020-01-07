package halpers.domain;

import java.util.UUID;

public class BaseId {
    private UUID uuid;
    public String id;

    public BaseId(String id){
        this.id = id;
        this.validate();
    }

    public BaseId(){

        this.uuid = UUID.randomUUID();
    }

    private void validate(){
        this.uuid = UUID.fromString(this.id);
    }

    public String  getUuid() {
        return this.uuid.toString();
    }
}
