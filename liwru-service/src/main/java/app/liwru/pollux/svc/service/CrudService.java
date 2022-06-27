package app.liwru.pollux.svc.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<C, K> {
/*    void create(T t);
    void update(T t);
    void delete(ID id);
    T findById(ID id);
    List<T> findAll();*/

    //Anterior

    public Optional<C> findById(K k);
    public Optional<List<C>> findAll();

    public C saveOrUpdate(C c);
    public boolean deleteById(K k);


}

