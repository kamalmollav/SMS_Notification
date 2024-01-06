package com.numetry.SMS.Verification.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.numetry.SMS.Verification.entity.SMS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SMSService {

    private final String ACCOUNT_SID ="ACb5c0e97320fdd45160d8b29b7983c427";

    private final String AUTH_TOKEN = "212d9f8557fa2972b8e7e9c25a3b4d07";

    private final String FROM_NUMBER = "+12058511405";

    public void send(SMS sms) {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage()).create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}
