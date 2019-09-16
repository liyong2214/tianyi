package com.tianyi.common.base;

import java.util.List;

/**
 * 基类
 * @author : Hens
 * @date : 2019/9/15 20:36
 */
public interface BaseDao<T extends BaseEntity> {
    /**
     * 查询所有信息
     * @return
     */
    List<T> list();

    /**
     * 新增信息
     * @param entity
     */
    int save(T entity);

    /**
     * 删除信息
     * @param id
     */
    int remove(Long id);

    /**
     * 批量删除信息
     * @param ids
     * @return
     */
    int removeMulti(String[] ids);
    /**
     * 修改信息
     * @param entity
     */
    int update(T entity);

    /**
     * 查询信息
     * @param id
     * @return
     */
    T get(Long id);

    /**
     * 统计总数
     * @param entity
     * @return
     */
    int count(T entity);

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<T> page(int currentPage, int pageSize);
}
