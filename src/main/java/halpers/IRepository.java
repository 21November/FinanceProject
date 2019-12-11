package halpers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IRepository <T> {
    abstract void insert(T t);

    abstract void update(T t);

    abstract void delete(String name);

    abstract List<T> getAll();

    //было бы не плохо возвращать обьект по id, но UUID слишком сложный
    //может возвра
    abstract Optional<T> getById(long id);


}
