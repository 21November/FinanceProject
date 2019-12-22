package halpers.domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

public abstract class Domain <T> {

    public static <T>T fromJSON(Map map) {
        throw new NotImplementedException();
    }

    public static <T>T fromMap(){
        throw new NotImplementedException();
    }
    //TODO: create method which could convert object into Map=)
    //TODO: it will be useful later after moveing from CLI to HTTP service
}
