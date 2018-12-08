package com.ouyanglol.demo.dao;

import java.io.Serializable;

/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 * @author Ouyang
 * @param <Model> The Model Class 这里是泛型不是Model类
 * @param <PK> The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 */
public interface MyBatisBaseDao<Model, PK extends Serializable> {
    /**
     * 删除
     * @param id 主键
     * @return int
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 添加
     * @param record 实体
     * @return int
     */
    int insert(Model record);

    /**
     * 增加
     * @param record 实体
     * @return int
     */
    int insertSelective(Model record);

    /**
     * 根据主键查询
     * @param id id
     * @return 实体
     */
    Model selectByPrimaryKey(PK id);

    /**
     * 更新
     * @param record 实体
     * @return int
     */
    int updateByPrimaryKeySelective(Model record);

    /**
     * 更新
     * @param record 实体
     * @return int
     */
    int updateByPrimaryKey(Model record);
}