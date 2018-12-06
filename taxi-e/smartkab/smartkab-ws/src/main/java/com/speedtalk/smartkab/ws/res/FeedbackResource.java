package com.speedtalk.smartkab.ws.res;

import com.speedtalk.smartkab.ws.Constants;
import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.smartkab.ws.dao.FeedbackDao;
import com.speedtalk.smartkab.ws.dao.UserDao;
import com.speedtalk.smartkab.ws.db.TabFeedback;
import com.speedtalk.smartkab.ws.db.TabPhoneuser;
import com.speedtalk.smartkab.ws.domain.Content;
import com.speedtalk.smartkab.ws.domain.Response;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.Timestamp;

@Path("fb")
public class FeedbackResource {
    private FeedbackDao feedbackDao;
    private UserDao userDao;

    public FeedbackResource() {
        feedbackDao = new FeedbackDao();
        userDao = new UserDao();
    }

    @POST
    @Path("new")
    //	@Produces(MediaType.APPLICATION_JSON)
    @Produces("application/json;charset=utf-8")
    public Response newFeedBack(final Content content) {
        Response resp = new Response(Constants.SUCCESS_RESP, Constants.SUCCESS_DESC_RESP);
        try {
            TabPhoneuser user = userDao.getByAccount(content.getAccount());
            if (null == user) {
                resp.setCode(Constants.ACCOUNT_ERR_RESP);
                resp.setDesc(Constants.ACCOUNT_ERR_DESC_RESP);
                System.out.println(Utils.getLogFix() + "a incorrect user try to create a feedback!" + content.getAccount());
                return resp;
            }
            if (null == content.getContent() || content.getContent().trim().equals(""))
                return resp;

            TabFeedback feedback = new TabFeedback(content.getAccount(), content.getContent());
            feedback.setId(0);
            feedback.setTime(new Timestamp(System.currentTimeMillis()));
            feedbackDao.save(feedback);
            System.out.println(Utils.getLogFix() + content.getAccount() + " create a feedback!" + content.getContent());
        } catch (Exception e) {
            resp.setCode(Constants.FAILURE_RESP);
            resp.setDesc(Constants.FAILURE_DESC_RESP);
            e.printStackTrace();
        }
        return resp;
    }
}
