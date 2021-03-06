package org.support.project.web.dao;

import java.util.List;

import org.support.project.di.Container;
import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.ormapping.common.SQLManager;
import org.support.project.web.dao.gen.GenUserNotificationsDao;
import org.support.project.web.entity.NotificationsEntity;

/**
 * ユーザへの通知
 */
@DI(instance = Instance.Singleton)
public class UserNotificationsDao extends GenUserNotificationsDao {

    /** SerialVersion */
    private static final long serialVersionUID = 1L;
    /**
     * Get instance from DI container.
     * @return instance
     */
    public static UserNotificationsDao get() {
        return Container.getComp(UserNotificationsDao.class);
    }
    
    /**
     * 指定のユーザの通知件数を取得
     * @param loginUserId ログインユーザID
     * @return 件数
     */
    public int count(Integer loginUserId) {
        String sql = "SELECT COUNT(*) FROM USER_NOTIFICATIONS WHERE USER_ID = ? AND DELETE_FLAG = 0";
        return executeQuerySingle(sql, Integer.class, loginUserId);
    }
    /**
     * 指定のユーザの指定ステータスの通知件数を取得
     * @param loginUserId ログインユーザID
     * @param status ステータス
     * @return 件数
     */
    public int countOnStatus(Integer loginUserId, int status) {
        String sql = "SELECT COUNT(*) FROM USER_NOTIFICATIONS WHERE USER_ID = ? AND DELETE_FLAG = 0 AND STATUS = ?";
        return executeQuerySingle(sql, Integer.class, loginUserId, status);
    }

    /**
     * 指定ユーザの通知の取得
     * @param loginUserId ログインユーザID
     * @param offset オフセット
     * @param limit リミット
     * @return 通知
     */
    public List<NotificationsEntity> selectOnUser(Integer loginUserId, int limit, int offset) {
        String sql = SQLManager.getInstance().getSql("/org/support/project/web/dao/sql/UserNotificationsDao/UserNotificationsDao_selectOnUser.sql");
        return executeQueryList(sql, NotificationsEntity.class, loginUserId, limit, offset);
        
    }



}
