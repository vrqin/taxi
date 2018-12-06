package com.spring.jersy.hibernate.resource.others;

import com.spring.jersy.hibernate.model.entity.Carinfo;
import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.model.entity.Driver;
import com.spring.jersy.hibernate.model.service.CarinfoService;
import com.spring.jersy.hibernate.model.service.ClientService;
import com.spring.jersy.hibernate.model.service.DriverService;
import com.spring.jersy.hibernate.publics.util.ReadExcelUtils;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.resource.BaseResource;
import org.apache.log4j.Logger;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;
import java.util.Map;

@Component
@Path("/file")
@Scope("prototype")
public class UploadFileService extends BaseResource {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(UploadFileService.class);
    @Resource
    private DriverService driverService;

    @Resource
    private ClientService clientService;

    @Resource
    private CarinfoService carinfoService;

    private Client client;

    private String message = "";

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("account") String account, @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = fileDetail.getFileName();
        //后缀名
        String fix = name.substring(name.lastIndexOf(".") + 1);
        //重命名上传图片姓名
        String filename = account;

        //只能在linux 下面有效
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        String uploadedFileLocation = dir + PrcUrl + filename + "." + fix;
        //System.out.println(uploadedFileLocation);
        File file = new File(uploadedFileLocation);
        if (file.exists()) {
            file.delete();
        }


        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "<span style='font-size:12px'>上传完成</span> <script>document.getElementsByTagName('body')[0].style.margin=0</script>";

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/uploadidentity")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadidentity(@FormDataParam("account") String account, @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = fileDetail.getFileName();
        //后缀名
        String fix = name.substring(name.lastIndexOf(".") + 1);
        //重命名上传图片姓名
        String filename = account;

        //只能在linux 下面有效
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        String uploadedFileLocation = dir + PrcUrl + filename + "_identity" + "." + fix;
        //System.out.println(uploadedFileLocation);
        File file = new File(uploadedFileLocation);
        if (file.exists()) {
            file.delete();
        }


        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "<span style='font-size:12px'>上传完成</span> <script>document.getElementsByTagName('body')[0].style.margin=0</script>";

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/uploaddriving")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploaddriving(@FormDataParam("account") String account, @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = fileDetail.getFileName();
        //后缀名
        String fix = name.substring(name.lastIndexOf(".") + 1);
        //重命名上传图片姓名
        String filename = account;

        //只能在linux 下面有效
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        String uploadedFileLocation = dir + PrcUrl + filename + "_driving" + "." + fix;
        //System.out.println(uploadedFileLocation);
        File file = new File(uploadedFileLocation);
        if (file.exists()) {
            file.delete();
        }


        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "<span style='font-size:12px'>上传完成</span> <script>document.getElementsByTagName('body')[0].style.margin=0</script>";

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/uploadcarinfo")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadcarinfo(@FormDataParam("vehicleid") String vehicleid, @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = fileDetail.getFileName();
        //后缀名
        String fix = name.substring(name.lastIndexOf(".") + 1);
        //重命名上传图片姓名
        String filename = vehicleid;

        //只能在linux 下面有效
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        String uploadedFileLocation = dir + PrcUrl + filename + "_carinfo" + "." + fix;
        //System.out.println(uploadedFileLocation);
        File file = new File(uploadedFileLocation);
        if (file.exists()) {
            file.delete();
        }


        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "<span style='font-size:12px'>上传完成</span> <script>document.getElementsByTagName('body')[0].style.margin=0</script>";

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/uploaddiscountpon")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploaddiscountpon(@FormDataParam("id") String vehicleid, @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = fileDetail.getFileName();
        //后缀名
        String fix = name.substring(name.lastIndexOf(".") + 1);
        //重命名上传图片姓名
        String filename = vehicleid;

        //只能在linux 下面有效
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        String uploadedFileLocation = dir + DiscountUrl + filename + "_discount" + "." + fix;
        //System.out.println(uploadedFileLocation);
        File file = new File(uploadedFileLocation);
        if (file.exists()) {
            file.delete();
        }


        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "<span style='font-size:12px'>上传完成</span> <script>document.getElementsByTagName('body')[0].style.margin=0</script>";

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/uploadvehi")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadvehi(@FormDataParam("vehicleid") String vehicleid, @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = fileDetail.getFileName();
        //后缀名
        String fix = name.substring(name.lastIndexOf(".") + 1);
        //重命名上传图片姓名
        String filename = vehicleid;

        //只能在linux 下面有效
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        String uploadedFileLocation = dir + PrcUrl + filename + "_vehic" + "." + fix;
        //System.out.println(uploadedFileLocation);
        File file = new File(uploadedFileLocation);
        if (file.exists()) {
            file.delete();
        }


        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "<span style='font-size:12px'>上传完成</span> <script>document.getElementsByTagName('body')[0].style.margin=0</script>";

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/importDriver")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response importDriver(@FormDataParam("account") String account, @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = fileDetail.getFileName();
        //后缀名
        String fix = name.substring(name.lastIndexOf(".") + 1);
        //重命名上传图片姓名
        String filename = account;


        //只能在linux 下面有效
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        String uploadedFileLocation = dir + ExcUrl + filename + "_driver" + "." + fix;
        //System.out.println(uploadedFileLocation);
        File file = new File(uploadedFileLocation);
        if (file.exists()) {
            file.delete();
        }

        //		//System.out.println(dir);
        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        try {
            String filepath = uploadedFileLocation;
            //			String filepath = "d:\\driver001.xls";
            ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

            // 对读取Excel表格内容测试
            Map<Integer, Map<Integer, Object>> map = excelReader.readExcelContent();
            //System.out.println("获得Excel表格的内容:");
            //读取数据
            List<Driver> drivers = ReadExcelUtils.readDriver(map);
            if (!S.isNull(drivers) && drivers.size() > 0) {
                //写入数据
                message = writeDriver(drivers);
            } else {
                message = "导入失败！导入空数据";
            }


        } catch (FileNotFoundException e) {
            message = "导入失败！未找到指定路径的文件!";
            //System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        } catch (Exception e) {
            message = "导入失败！导入模版或格式错误，请使用导入模版!";
            e.printStackTrace();
        }

        String output = "<span style='font-size:12px'>" + message + "</span> <script>document.getElementsByTagName('body')[0].style.margin=0</script>";

        return Response.status(200).entity(output).build();

    }

    @POST
    @Path("/importCarinfo")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response importCarinfo(@FormDataParam("account") String account, @FormDataParam("file") InputStream uploadedInputStream, @FormDataParam("file") FormDataContentDisposition fileDetail) {
        //获取文件名
        String name = fileDetail.getFileName();
        //后缀名
        String fix = name.substring(name.lastIndexOf(".") + 1);
        //重命名上传图片姓名
        String filename = account;


        //只能在linux 下面有效
        String dir = System.getProperty("user.dir");
        dir = dir.replace("bin", "webapps");
        String uploadedFileLocation = dir + ExcUrl + filename + "_carinfo" + "." + fix;
        //System.out.println(uploadedFileLocation);
        File file = new File(uploadedFileLocation);
        if (file.exists()) {
            file.delete();
        }

        //		//System.out.println(dir);
        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        try {
            String filepath = uploadedFileLocation;
            //			String filepath = "d:\\carinfo001.xls";
            ReadExcelUtils excelReader = new ReadExcelUtils(filepath);

            // 对读取Excel表格内容测试
            Map<Integer, Map<Integer, Object>> map = excelReader.readExcelContent();
            //System.out.println("获得Excel表格的内容:");
            //读取数据
            List<Carinfo> carinfos = ReadExcelUtils.readCarinfo(map);
            if (!S.isNull(carinfos) && carinfos.size() > 0) {
                //写入数据
                message = writeCarinfo(carinfos);
            } else {
                message = "导入失败！导入空数据";
            }


        } catch (FileNotFoundException e) {
            message = "导入失败！未找到指定路径的文件!";
            //System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        } catch (Exception e) {
            message = "导入失败！导入模版或格式错误，请使用导入模版!";
            e.printStackTrace();
        }

        String output = "<span style='font-size:12px'>" + message + "</span> <script>document.getElementsByTagName('body')[0].style.margin=0</script>";

        return Response.status(200).entity(output).build();

    }

    private String writeDriver(List<Driver> drivers) {
        StringBuffer repeatAccount = new StringBuffer();
        StringBuffer repeatClient = new StringBuffer();
        StringBuffer repeatKabnum = new StringBuffer();
        StringBuffer repeatMessage = new StringBuffer();

        try {
            int importCount = 0;
            int importClientCount = 0;
            for (Driver driver : drivers) {
                client = clientService.findbyCompany(driver.getCompany());
                Carinfo carinfo = carinfoService.findByKabnum(driver.getKabnum());
                //System.out.println(driver.toString());
                if (S.isNull(driverService.findByName(driver.getAccount()))) {
                    if (!S.isNull(client)) {
                        if (!S.isNull(carinfo)) {
                            driver.setClientid(client.getClientId());
                            driver.setKabnumid(carinfo.getId());
                            //车辆绑定
                            driver.setCarinfo(carinfo);
                            driver.setRemain(1000);
                            driverService.save(driver);
                            importClientCount++;
                        } else {
                            repeatKabnum.append(driver.getAccount()).append(",");
                        }

                    } else {
                        repeatClient.append(driver.getAccount()).append(",");
                    }


                    importCount++;
                } else {
                    repeatAccount.append(driver.getAccount()).append(",");
                }


            }
            //			//System.out.println(repeatClient.toString());
            if (repeatKabnum.toString().length() > 0) {
                //System.out.println(repeatKabnum.toString());
                repeatMessage.append("司机登录帐号：").append(repeatKabnum.toString()).append("\n");
                repeatMessage.append("没有当前车辆信息，请先添加该帐号的车辆信息！");
            }
            if (repeatClient.toString().length() > 0) {
                //System.out.println(repeatClient.toString());
                repeatMessage.append("司机登录帐号：").append(repeatClient.toString()).append("\n");
                repeatMessage.append("没有当前企业或公司，请联系管理员添加企业或公司信息！");
            }
            if (repeatAccount.toString().length() > 0) {
                //System.out.println(repeatAccount.toString());
                repeatMessage.append("请修改重复的数据后再导入：\n");
                repeatMessage.append("司机登录帐号：").append(repeatAccount.toString()).append("\n");
            }
            if (repeatClient.toString().length() == 0 && repeatAccount.toString().length() == 0) {
                repeatMessage.append("成功导入" + importCount + "名司机信息！");
            }

        } catch (Exception e) {

            repeatMessage.append("导入司机信息失败,请仔细检查导入文件的数据！");
            LOGGER.error("处理重复数据异常：", e);

        }
        return repeatMessage.toString();
    }

    private String writeCarinfo(List<Carinfo> carinfos) {
        StringBuffer repeatAccount = new StringBuffer();
        StringBuffer repeatClient = new StringBuffer();
        StringBuffer repeatMessage = new StringBuffer();

        try {
            int importCount = 0;
            int importClientCount = 0;
            for (Carinfo carinfo : carinfos) {
                //System.out.println(carinfo);
                client = clientService.findbyCompany(carinfo.getCompany());


                //数据库不存在当前车辆
                if (S.isNull(carinfoService.findByKabnum(carinfo.getKabnum()))) {
                    //所属公司存在
                    if (!S.isNull(client)) {
                        carinfo.setClientid(client.getClientId());
                        carinfo.setDisplacement(Double.valueOf(30003));
                        carinfoService.save(carinfo);
                        importClientCount++;
                    } else {
                        repeatClient.append(carinfo.getKabnum()).append(",");
                    }


                    importCount++;
                } else {
                    //存在车辆，不能重复
                    repeatAccount.append(carinfo.getKabnum()).append(",");
                }


            }
            //			//System.out.println(repeatClient.toString());
            if (repeatClient.toString().length() > 0) {
                //System.out.println(repeatClient.toString());
                repeatMessage.append("车牌号码：").append(repeatClient.toString()).append("\n");
                repeatMessage.append("没有当前企业或公司，请联系管理员添加企业或公司信息！");
            }
            if (repeatAccount.toString().length() > 0) {
                //System.out.println(repeatAccount.toString());
                repeatMessage.append("请修改重复的数据后再导入：\n");
                repeatMessage.append("车牌号码：").append(repeatAccount.toString()).append("\n");
            }
            if (repeatClient.toString().length() == 0 && repeatAccount.toString().length() == 0) {
                repeatMessage.append("成功导入" + importCount + "名车辆信息！");
            }

        } catch (Exception e) {

            repeatMessage.append("导入车辆信息失败,请仔细检查导入文件的数据！");
            LOGGER.error("处理重复数据异常：", e);

        }
        return repeatMessage.toString();
    }


    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {

        try {
            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }


}