package com.infras.web.controller.wx;

import com.mxixm.fastboot.weixin.annotation.WxAsyncMessage;
import com.mxixm.fastboot.weixin.annotation.WxController;
import com.mxixm.fastboot.weixin.annotation.WxMessageMapping;
import com.mxixm.fastboot.weixin.module.message.WxMessage;
import com.mxixm.fastboot.weixin.module.web.WxRequest;
import com.mxixm.fastboot.weixin.module.web.session.WxSession;

/**
 * Created by zhaoheng on 2017/10/24.
 */
@WxController
public class EventController {

    @WxMessageMapping(type = WxMessage.Type.TEXT)
    @WxAsyncMessage
    public String text(WxRequest wxRequest, String content) {
        WxSession wxSession = wxRequest.getWxSession();
        if(wxSession != null && wxSession.getAttribute("last") != null) {
            return "上次收到的消息内容为" + wxSession.getAttribute("last");
        }
        return "收到的内容为" + content;
    }
}

