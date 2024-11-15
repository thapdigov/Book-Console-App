package az.turing.dao;

import java.util.Collection;

public interface Dao<E, I> {

    E create(E e);

    E delete(I id);

    E update(E e);

    E getId(I id);

    Collection<E> getAll();


}
