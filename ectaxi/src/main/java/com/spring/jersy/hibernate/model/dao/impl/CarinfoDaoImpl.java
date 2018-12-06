package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.CarinfoDao;
import com.spring.jersy.hibernate.model.entity.Carinfo;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class CarinfoDaoImpl extends BaseDaoImpl<Carinfo, Integer> implements CarinfoDao {
    public CarinfoDaoImpl() {
        super(Carinfo.class);
    }

    public CarinfoDaoImpl(Class<Carinfo> entity) {
        super(entity);
    }


    //    //单表联合主键批量删除
    //    public int delBatch(List<Driver> list){
    //        Session session = getSession();
    //        StringBuffer sql = new StringBuffer();
    //        sql.append("delete from tab_carinfo_driver ");
    //        Iterator iteraor = list.iterator();
    //        for(int i = 0;iteraor.hasNext();i++){
    //            Driver driver = (Driver)iteraor.next();
    //            sql.append("where (driverid = :driverid_"+i+" and id= :id_"+i+") or");
    //        }
    //    //delete from tab_carinfo_driver where (driverid = :driverid_i and id=:id_i)
    //        sql.lastIndexOf("or");
    //        Query query = session.createSQLQuery(sql.toString());
    //        for(int i=0;i<list.size();i++){
    //            query.setParameter(":driverid_"+i,list.get(i).getDriverid());
    //            query.setParameter(":id_"+i,+list.get(i).getKabnumid());
    //        }
    //
    //        int dels = query.executeUpdate();
    //        return dels;
    //    }
}
