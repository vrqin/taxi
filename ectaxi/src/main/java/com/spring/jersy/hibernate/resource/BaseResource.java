package com.spring.jersy.hibernate.resource;

//import com.spring.jersy.hibernate.publics.util.JsonUtils;


import com.spring.jersy.hibernate.model.entity.LogAbnormal;
import com.spring.jersy.hibernate.model.entity.LogOperation;
import com.spring.jersy.hibernate.publics.util.JsonUtils;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/8.
 */
public abstract class BaseResource {


    public String PrcUrl = "/TaxiSMPWS/file_stream/upload/drivers/";
    public String ExcUrl = "/TaxiSMPWS/file_stream/excel/drivers/";
    public String DiscountUrl = "/TaxiSMPWS/file_stream/picture/discountcoupon/";
    /**
     * 文件上传使用
     */
    public File[] upload;
    public String[] uploadContentType;
    public String[] uploadFileName;
    public String OPERATION_ADD_NAME = "添加";
    public int OPERATION_ADD = 1;
    public String OPERATION_DEL_NAME = "删除";
    public int OPERATION_DEL = 2;
    public String OPERATION_EDIT_NAME = "修改";
    public int OPERATION_EDIT = 3;
    public String OPERATION_QUERY_NAME = "查询";
    public int OPERATION_QUERY = 4;
    public String OPERATION_IMP_NAME = "导入";
    public int OPERATION_IMP = 5;
    public String OPERATION_OUT_NAME = "导出";
    public int OPERATION_OUT = 6;
    protected String fileName;
    protected InputStream excelFile;
    protected int total;//总数
    private LogOperation logOperation;
    private LogAbnormal logAbnormal;
    private String savePath = "/upload";

    public String ReturePageList(int total, List list) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map
        jsonMap.put("total", total); // total 存放总记录数，必须的
        jsonMap.put("rows", list);// rows 存放每页记录 list
        return JsonUtils.bean2json(jsonMap);
        //        return null;
    }


}
