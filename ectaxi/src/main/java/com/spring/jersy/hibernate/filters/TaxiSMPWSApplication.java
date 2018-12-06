package com.spring.jersy.hibernate.filters;

import com.spring.jersy.hibernate.servlet.StartupServlet;
import org.apache.log4j.Logger;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Administrator on 2016/12/20.
 */

@ApplicationPath("/")
public class TaxiSMPWSApplication extends ResourceConfig {
    private static final Logger LOGGER = Logger.getLogger(TaxiSMPWSApplication.class);
    public TaxiSMPWSApplication() {

        super(MultiPartFeature.class);

        LOGGER.warn("------------configured!!!!!-------------");
        // 服务类所在的包路径
        packages("com.spring.jersy.hibernate.resource");
        // packages("com.spring.jersy.hibernate.exception");

        register(CorsFilter.class);

        // 注册JSON转换器
        register(JacksonJsonProvider.class);
        
    }


}
