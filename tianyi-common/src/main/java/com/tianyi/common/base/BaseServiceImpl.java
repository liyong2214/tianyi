package com.tianyi.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/15 20:54
 */
public abstract class BaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    private D dao;

    @Override
    public List<T> list(){
        return dao.list();
    }

    @Override
    public int remove(Long id) {
        return dao.remove(id);
    }

    @Override
    public int removeMulti(String[] ids) {
        return removeMulti(ids);
    }

    @Override
    public T get(Long id) {
        return dao.get(id);
    }

    @Override
    public int update(T entity) {
        return dao.update(entity);
    }

    @Override
    public List page(int currentPage, int pageSize) {
        return dao.page(currentPage, pageSize);
    }

    @Override
    public int count(T entity) {
        return dao.count(entity);
    }


}
