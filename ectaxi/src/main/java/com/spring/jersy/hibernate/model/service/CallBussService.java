package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.*;
import com.spring.jersy.hibernate.publics.bean.*;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by Administrator on 2016/3/17.
 */
public interface CallBussService {

    public Callbuss findBybillId(String id);

    public Callbuss findByKabnumPhone(String phone, String kabnum);

    public PageList findPageList(int page, int size, String sort, String order, String key, String begintime, String endtime, Integer type, Integer ordertype) throws Exception;

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception;

    public PageList findListByOpruser(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception;

    public PageList findListByDate(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception;

    public PageList findListByMsid(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception;

    public List<Callbuss> findListByToMsid(String sort, String order, String key, String begintime, String endtime, Integer status, Integer ordertype, Integer type, Integer clientid) throws Exception;

    public PageList findCallsBymsid(int page, int size, String sort, String order, String msid) throws Exception;

    public List<Callbuss> findCallBussByTime(String begintime, String endtime, int status) throws Exception;

    public List<CallBussReport> findCallBuss(String begintime, String endtime);

    public List<DateCallBussReport> findDateCallBuss(String begintime, String endtime, Integer clientid);

    public List<DriverCallBussReport> findDriverCallBuss(String begintime, String endtime, Integer clientid);

    public List<DriverCallBussReport> findDriverCallBuss(String begintime, String endtime, Integer clientid, Integer page, Integer rows);

    //查询driver总数
    public Integer findCount(Integer clientid);

    public List<PassengerCallBussReport> findPassengerCallBuss(String begintime, String endtime);

    public List<SeatCallBussReport> findSeatCallBuss(String begintime, String endtime, Integer clientid);

    public List<PasserCallBussReport> findPasserCallBuss(String begintime, String endtime, Integer clientid);

    public List<EvaluateBean> findEvaluate(String begintime, String endtime);

    public List<CallBussStatBean> findCallBussStat(String begintime);

    public List<Callbuss> findCallBussNewStatistical(String begintime, Integer length, Integer clientid) throws Exception;

    public List<CallbussBean> findCallBussHisStatistical(String begintime, Integer length, Integer clientid) throws Exception;

    public List<CallbussBean> findCallBussProStatistical(String begintime, Integer length, Integer clientid) throws Exception;

    public List<OperatingBean> findOperating(String begintime, String endtime) throws Exception;

    public List<PayBean> findPay(String begintime, String endtime) throws Exception;

    public List<DriverCommuting> findCommuting(String begintime, String endtime) throws Exception;

    public List<OperatDetails> findOperatsDeails(String begintime, String endtime, int clientid) throws Exception;

    //    public List<PassPayDetails> findPassPayDetails(String begintime, String endtime, int clientid) throws Exception;
    public PageList findPassPayDetails(int page, int rows, String begintime, String endtime, int clientid) throws Exception;

    public List<DriverIncome> findDriverIncomeList(int page, int rows, String begintime, String endtime, int clientid) throws Exception;

    public PageList findDriverIncomeListByPageList(int page, int rows, String begintime, String endtime, int clientid) throws Exception;

    public PageList findDriverIncomeDetail(int page, int rows, String begintime, String endtime, int clientid) throws Exception;

    public List<DriverIncomeStatis> findDriverIncomeStatis(String begintime, String endtime, int clientid, String key) throws Exception;

    public List<DriverIncomeStatisMonth> findDriverIncomeStatisMonth(String begintime, String endtime, int clientid, String key) throws Exception;

    public List<DriverIncomeStatisDay> findDriverIncomeStatisDay(String begintime, String endtime, int clientid, String key) throws Exception;


    public List<DriverIntegrity> findDriverIntegrity(int clientid, String key) throws Exception;

    public List<Callbuss> findCallBuss(String sort, String order, String key, String begintime, String endtime, Integer type, Integer ordertype, Integer clientid, Integer status) throws Exception;


}
