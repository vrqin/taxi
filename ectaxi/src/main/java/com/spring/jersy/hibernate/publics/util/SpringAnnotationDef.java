package com.spring.jersy.hibernate.publics.util;

/**
 * Created by Administrator on 2016/1/10.
 */
public interface SpringAnnotationDef {
    String SCOPE_PROTOTYPE = "prototype";

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_SESSION = "session";

    String SCOPE_REQUEST = "request";

    String BASE_DAO = "baseDao";

    String USER_DAO = "userDao";

    String USER_SERVICE = "userService";
}
