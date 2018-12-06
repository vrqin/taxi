/**
 * PhoenixWSCallbackHandler.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.speedtalk.services;

/**
 * PhoenixWSCallbackHandler Callback class, Users can extend this class and implement
 * their own receiveResult and receiveError methods.
 */
public abstract class PhoenixWSCallbackHandler {


    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     *
     * @param clientData Object mechanism by which the user can pass in user data
     *                   that will be avilable at the time this callback is called.
     */
    public PhoenixWSCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public PhoenixWSCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */

    public Object getClientData() {
        return clientData;
    }


    /**
     * auto generated Axis2 call back method for moveMsToGrp method
     * override this method for handling normal response from moveMsToGrp operation
     */
    public void receiveResultmoveMsToGrp(MoveMsToGrpResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from moveMsToGrp operation
     */
    public void receiveErrormoveMsToGrp(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCallInfoByGrpId method
     * override this method for handling normal response from getCallInfoByGrpId operation
     */
    public void receiveResultgetCallInfoByGrpId(com.speedtalk.services.GetCallInfoByGrpIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCallInfoByGrpId operation
     */
    public void receiveErrorgetCallInfoByGrpId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for deleteMsOutGrp method
     * override this method for handling normal response from deleteMsOutGrp operation
     */
    public void receiveResultdeleteMsOutGrp(DeleteMsOutGrpResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deleteMsOutGrp operation
     */
    public void receiveErrordeleteMsOutGrp(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for setMsPttGrp method
     * override this method for handling normal response from setMsPttGrp operation
     */
    public void receiveResultsetMsPttGrp(SetMsPttGrpResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from setMsPttGrp operation
     */
    public void receiveErrorsetMsPttGrp(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCallInfoByMsIdGrpId method
     * override this method for handling normal response from getCallInfoByMsIdGrpId operation
     */
    public void receiveResultgetCallInfoByMsIdGrpId(com.speedtalk.services.GetCallInfoByMsIdGrpIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCallInfoByMsIdGrpId operation
     */
    public void receiveErrorgetCallInfoByMsIdGrpId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for isUpgrade method
     * override this method for handling normal response from isUpgrade operation
     */
    public void receiveResultisUpgrade(IsUpgradeResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from isUpgrade operation
     */
    public void receiveErrorisUpgrade(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addMsInGrp method
     * override this method for handling normal response from addMsInGrp operation
     */
    public void receiveResultaddMsInGrp(AddMsInGrpResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addMsInGrp operation
     */
    public void receiveErroraddMsInGrp(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for registerServer method
     * override this method for handling normal response from registerServer operation
     */
    public void receiveResultregisterServer(RegisterServerResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from registerServer operation
     */
    public void receiveErrorregisterServer(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getGrpInfoByGrpId method
     * override this method for handling normal response from getGrpInfoByGrpId operation
     */
    public void receiveResultgetGrpInfoByGrpId(com.speedtalk.services.GetGrpInfoByGrpIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getGrpInfoByGrpId operation
     */
    public void receiveErrorgetGrpInfoByGrpId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for deleteGrpByGrpId method
     * override this method for handling normal response from deleteGrpByGrpId operation
     */
    public void receiveResultdeleteGrpByGrpId(DeleteGrpByGrpIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deleteGrpByGrpId operation
     */
    public void receiveErrordeleteGrpByGrpId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for updateMsNameByMsId method
     * override this method for handling normal response from updateMsNameByMsId operation
     */
    public void receiveResultupdateMsNameByMsId(com.speedtalk.services.UpdateMsNameByMsIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from updateMsNameByMsId operation
     */
    public void receiveErrorupdateMsNameByMsId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getMsListByGrpId method
     * override this method for handling normal response from getMsListByGrpId operation
     */
    public void receiveResultgetMsListByGrpId(GetMsListByGrpIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getMsListByGrpId operation
     */
    public void receiveErrorgetMsListByGrpId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getMsInfoByMsId method
     * override this method for handling normal response from getMsInfoByMsId operation
     */
    public void receiveResultgetMsInfoByMsId(GetMsInfoByMsIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getMsInfoByMsId operation
     */
    public void receiveErrorgetMsInfoByMsId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getSysDateMillis method
     * override this method for handling normal response from getSysDateMillis operation
     */
    public void receiveResultgetSysDateMillis(GetSysDateMillisResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getSysDateMillis operation
     */
    public void receiveErrorgetSysDateMillis(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for createGrp method
     * override this method for handling normal response from createGrp operation
     */
    public void receiveResultcreateGrp(CreateGrpResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createGrp operation
     */
    public void receiveErrorcreateGrp(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCallInfoByMsId method
     * override this method for handling normal response from getCallInfoByMsId operation
     */
    public void receiveResultgetCallInfoByMsId(com.speedtalk.services.GetCallInfoByMsIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCallInfoByMsId operation
     */
    public void receiveErrorgetCallInfoByMsId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for updateGrpNameByGrpId method
     * override this method for handling normal response from updateGrpNameByGrpId operation
     */
    public void receiveResultupdateGrpNameByGrpId(com.speedtalk.services.UpdateGrpNameByGrpIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from updateGrpNameByGrpId operation
     */
    public void receiveErrorupdateGrpNameByGrpId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getCallDataByCallId method
     * override this method for handling normal response from getCallDataByCallId operation
     */
    public void receiveResultgetCallDataByCallId(com.speedtalk.services.GetCallDataByCallIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getCallDataByCallId operation
     */
    public void receiveErrorgetCallDataByCallId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getGrpListByMsId method
     * override this method for handling normal response from getGrpListByMsId operation
     */
    public void receiveResultgetGrpListByMsId(GetGrpListByMsIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getGrpListByMsId operation
     */
    public void receiveErrorgetGrpListByMsId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getLastGpsByGrpId method
     * override this method for handling normal response from getLastGpsByGrpId operation
     */
    public void receiveResultgetLastGpsByGrpId(com.speedtalk.services.GetLastGpsByGrpIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getLastGpsByGrpId operation
     */
    public void receiveErrorgetLastGpsByGrpId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getGpsByMsId method
     * override this method for handling normal response from getGpsByMsId operation
     */
    public void receiveResultgetGpsByMsId(GetGpsByMsIdResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getGpsByMsId operation
     */
    public void receiveErrorgetGpsByMsId(Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getSysDateStr method
     * override this method for handling normal response from getSysDateStr operation
     */
    public void receiveResultgetSysDateStr(GetSysDateStrResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getSysDateStr operation
     */
    public void receiveErrorgetSysDateStr(Exception e) {
    }


}
    