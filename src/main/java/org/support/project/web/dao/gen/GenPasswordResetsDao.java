package org.support.project.web.dao.gen;

import java.util.List;

import java.sql.Timestamp;


import org.support.project.web.entity.PasswordResetsEntity;
import org.support.project.ormapping.dao.AbstractDao;
import org.support.project.ormapping.exception.ORMappingException;
import org.support.project.ormapping.common.SQLManager;
import org.support.project.ormapping.common.DBUserPool;
import org.support.project.ormapping.common.IDGen;
import org.support.project.ormapping.config.ORMappingParameter;
import org.support.project.ormapping.connection.ConnectionManager;
import org.support.project.common.util.PropertyUtil;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.aop.Aspect;

/**
 * パスワードリセット
 * this class is auto generate and not edit.
 * if modify dao method, you can edit PasswordResetsDao.
 */
@DI(instance = Instance.Singleton)
public class GenPasswordResetsDao extends AbstractDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;

    /**
     * Get instance from DI container.
     * @return instance
     */
    public static GenPasswordResetsDao get() {
        return Container.getComp(GenPasswordResetsDao.class);
    }

    /**
     * Select all data.
     * @return all data
     */
    public List<PasswordResetsEntity> physicalSelectAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_physical_select_all.sql");
        return executeQueryList(sql, PasswordResetsEntity.class);
    }
    /**
     * Select all data with pager.
     * @param limit limit
     * @param offset offset
     * @return all data on limit and offset
     */
    public List<PasswordResetsEntity> physicalSelectAllWithPager(int limit, int offset) { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_physical_select_all_with_pager.sql");
        return executeQueryList(sql, PasswordResetsEntity.class, limit, offset);
    }
    /**
     * Select data on key.
     * @param  id id
     * @return data
     */
    public PasswordResetsEntity physicalSelectOnKey(String id) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_physical_select_on_key.sql");
        return executeQuerySingle(sql, PasswordResetsEntity.class, id);
    }
    /**
     * Select all data that not deleted.
     * @return all data
     */
    public List<PasswordResetsEntity> selectAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_select_all.sql");
        return executeQueryList(sql, PasswordResetsEntity.class);
    }
    /**
     * Select all data that not deleted with pager.
     * @param limit limit
     * @param offset offset
     * @return all data
     */
    public List<PasswordResetsEntity> selectAllWidthPager(int limit, int offset) { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_select_all_with_pager.sql");
        return executeQueryList(sql, PasswordResetsEntity.class, limit, offset);
    }
    /**
     * Select count that not deleted.
     * @return count
     */
    public Integer selectCountAll() { 
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_select_count_all.sql");
        return executeQuerySingle(sql, Integer.class);
    }
    /**
     * Select data that not deleted on key.
     * @param  id id
     * @return data
     */
    public PasswordResetsEntity selectOnKey(String id) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_select_on_key.sql");
        return executeQuerySingle(sql, PasswordResetsEntity.class, id);
    }
    /**
     * Count all data
     * @return count
     */
    public int physicalCountAll() {
        String sql = "SELECT COUNT(*) FROM PASSWORD_RESETS";
        return executeQuerySingle(sql, Integer.class);
    }
    /**
     * Create row id.
     * @return row id
     */
    protected String createRowId() {
        return IDGen.get().gen("PASSWORD_RESETS");
    }
    /**
     * Physical Insert.
     * it is not create key on database sequence.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity rawPhysicalInsert(PasswordResetsEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_raw_insert.sql");
        executeUpdate(sql, 
            entity.getId(), 
            entity.getUserKey(), 
            entity.getRowId(), 
            entity.getInsertUser(), 
            entity.getInsertDatetime(), 
            entity.getUpdateUser(), 
            entity.getUpdateDatetime(), 
            entity.getDeleteFlag());
        return entity;
    }
    /**
     * Physical Insert.
     * if key column have sequence, key value create by database.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity physicalInsert(PasswordResetsEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_insert.sql");
        executeUpdate(sql, 
            entity.getId(), 
            entity.getUserKey(), 
            entity.getRowId(), 
            entity.getInsertUser(), 
            entity.getInsertDatetime(), 
            entity.getUpdateUser(), 
            entity.getUpdateDatetime(), 
            entity.getDeleteFlag());
        return entity;
    }
    /**
     * Insert.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity insert(Integer user, PasswordResetsEntity entity) {
        entity.setInsertUser(user);
        entity.setInsertDatetime(new Timestamp(new java.util.Date().getTime()));
        entity.setUpdateUser(user);
        entity.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        entity.setDeleteFlag(0);
        entity.setRowId(createRowId());
        return physicalInsert(entity);
    }
    /**
     * Insert.
     * saved user id is auto set.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity insert(PasswordResetsEntity entity) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer userId = (Integer) pool.getUser();
        return insert(userId, entity);
    }
    /**
     * Physical Update.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity physicalUpdate(PasswordResetsEntity entity) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_update.sql");
        executeUpdate(sql, 
            entity.getUserKey(), 
            entity.getRowId(), 
            entity.getInsertUser(), 
            entity.getInsertDatetime(), 
            entity.getUpdateUser(), 
            entity.getUpdateDatetime(), 
            entity.getDeleteFlag(), 
            entity.getId());
        return entity;
    }
    /**
     * Update.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity update(Integer user, PasswordResetsEntity entity) {
        PasswordResetsEntity db = selectOnKey(entity.getId());
        entity.setInsertUser(db.getInsertUser());
        entity.setInsertDatetime(db.getInsertDatetime());
        entity.setDeleteFlag(db.getDeleteFlag());
        entity.setUpdateUser(user);
        entity.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        return physicalUpdate(entity);
    }
    /**
     * Update.
     * saved user id is auto set.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity update(PasswordResetsEntity entity) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer userId = (Integer) pool.getUser();
        return update(userId, entity);
    }
    /**
     * Save. 
     * if same key data is exists, the data is update. otherwise the data is insert.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity save(Integer user, PasswordResetsEntity entity) {
        PasswordResetsEntity db = selectOnKey(entity.getId());
        if (db == null) {
            return insert(user, entity);
        } else {
            return update(user, entity);
        }
    }
    /**
     * Save. 
     * if same key data is exists, the data is update. otherwise the data is insert.
     * @param entity entity
     * @return saved entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public PasswordResetsEntity save(PasswordResetsEntity entity) {
        PasswordResetsEntity db = selectOnKey(entity.getId());
        if (db == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }
    /**
     * Physical Delete.
     * @param  id id
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void physicalDelete(String id) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/PasswordResetsDao/PasswordResetsDao_delete.sql");
        executeUpdate(sql, id);
    }
    /**
     * Physical Delete.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void physicalDelete(PasswordResetsEntity entity) {
        physicalDelete(entity.getId());

    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param user saved userid
     * @param  id id
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer user, String id) {
        PasswordResetsEntity db = selectOnKey(id);
        db.setDeleteFlag(1);
        db.setUpdateUser(user);
        db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        physicalUpdate(db);
    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * @param  id id
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(String id) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer user = (Integer) pool.getUser();
        delete(user, id);
    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(Integer user, PasswordResetsEntity entity) {
        delete(user, entity.getId());

    }
    /**
     * Delete.
     * if delete flag is exists, the data is logical delete.
     * set saved user id.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void delete(PasswordResetsEntity entity) {
        delete(entity.getId());

    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * set saved user id.
     * @param user saved userid
     * @param  id id
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer user, String id) {
        PasswordResetsEntity db = physicalSelectOnKey(id);
        db.setDeleteFlag(0);
        db.setUpdateUser(user);
        db.setUpdateDatetime(new Timestamp(new java.util.Date().getTime()));
        physicalUpdate(db);
    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * @param  id id
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(String id) {
        DBUserPool pool = Container.getComp(DBUserPool.class);
        Integer user = (Integer) pool.getUser();
        activation(user, id);
    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * set saved user id.
     * @param user saved userid
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(Integer user, PasswordResetsEntity entity) {
        activation(user, entity.getId());

    }
    /**
     * Ativation.
     * if delete flag is exists and delete flag is true, delete flug is false to activate.
     * @param entity entity
     */
    @Aspect(advice = org.support.project.ormapping.transaction.Transaction.class)
    public void activation(PasswordResetsEntity entity) {
        activation(entity.getId());

    }

}
