package com.tianyi.common.base;

import java.util.List;

/**
 * 业务层基类
 * @author : Hens
 * @date : 2019/9/15 20:40
 */
public interface BaseService<T> {
    /**
     * 查询所有
     * @return
     */
    List<T> list();

    /**
     * 新增
     * @param entity
     * @return
     */
    ResponseResult save(T entity);

    /**
     * 删除
     * @param id
     */
    int remove(Long id);

    /**
     * 批量删除
     * @param ids
     */
    int removeMulti(String[] ids);

    /**
     * 查看
     * @param id
     * @return
     */
    T get(Long id);

    /**
     * 修改
     * @param entity
     */
    int update(T entity);

    /**
     * 分页
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<T> page(int currentPage, int pageSize);

    /**
     * 统计
     * @param entity
     * @return
     */
    int count(T entity);
}
