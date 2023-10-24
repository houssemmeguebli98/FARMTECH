/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aladi
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;;


public class SmsSender {
    public static final String ACCOUNT_SID = "AC797d6bb879aa1cf0e5268337bf3df365";
    public static final String AUTH_TOKEN = "d81d65bf1ba99d89836f03e757ab95c6";

    public static void sendSms(String toPhoneNumber, String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message sms = Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber("+12407433450"),
                message
        ).create();

        System.out.println("Message SID: " + sms.getSid());
    }
}
