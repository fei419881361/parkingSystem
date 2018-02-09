package com.parking.system.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * * 表示一个公共的DAO接口
 * @param <k> 表示主键
 * @param <v> 操作对象
 * */
public interface BaseDAO<K,V> {
    /**
     * 实现数据增加操作
     * @param vo 表示要执行操作的对象
     * @return 成功返回true 失败返回 false
     * @throws SQLException
     * */
    boolean doCreate(V vo) throws SQLException;
    /**
     * 实现数据操作
     * @param vo 当前操作对象
     * @return 成功返回true 失败返回false
     * @throws SQLException
     * */
    boolean doUpdate(V vo) throws SQLException;
    /**
     * 实现批量删除
     * @param ids 表示执行删除的集合
     * @return 成功返回true 失败返回false
     * @throws SQLException
     * */
    boolean doRemove(Set<?> ids)throws SQLException;
    /**
     * 用户根据ID进行查询
     * */
    V findById(K id) throws SQLException;

    List<V> finaAll()throws SQLException;
    /**
     * 数据分页查询
     * @param colum 查询列
     * @param curentPage 当前页
     * @param keyWord 查询关键字
     * @param lineSize 每页显示记录数据
     * @return 成功返回满足条件数据 失败返回null
     * */
    List<V> findAllBySplit(String colum,String keyWord,Integer curentPage,Integer lineSize)throws SQLException;
    /**
     * 实现数据量统计操作
     * @param colum 表示要操作执行统计列
     * @param keyWord 查询关键字
     * @return 成功返回关键数据量 失败返回0
     * */
    Integer getAllCount(String colum,String keyWord)throws SQLException;
}
