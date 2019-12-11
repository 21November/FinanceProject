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
}
