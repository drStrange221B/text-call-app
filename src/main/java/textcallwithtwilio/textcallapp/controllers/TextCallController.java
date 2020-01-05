package textcallwithtwilio.textcallapp.controllers;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class TextCallController {

    public static final String ACCOUNT_SID = "AC2c95d874391e7bbba859333a52524753";
    public static final String AUTH_TOKEN = "40bfe733f3ac7b7bb6b5fbd5f4aed142";
    public static final String TWILIO_NUMBER = "+14807254473";

    @RequestMapping("/greetings")
    public String greeting(@RequestParam(value="mode", required = false, defaultValue="text") String mode,
                           @RequestParam(value="number", required = true) String number, Model model)
    {
        model.addAttribute("number", number);
        model.addAttribute("mode",mode);

        if(mode.equalsIgnoreCase("text"))
        {
            sendSMS(number);
        }

        log.info("control has come up to this");
        return "greeting";
    }

//    @RequestMapping("/")
//    public String index(){
//        log.info("control has come up to this");
//
//        System.out.println("*****************************************");
//        return "greeting";
//    }

    private void sendSMS(String number){

        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("Body", " I am testing sms functionality for my application, if you get this text acknowledge please! ---Rojaya Maharjan"));
            params.add(new BasicNameValuePair("To", number));
            params.add(new BasicNameValuePair("From", TWILIO_NUMBER));

            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message message = messageFactory.create(params);

            log.info(message.getSid());
        }
        catch(TwilioRestException e)
        {
            log.info(e.getErrorMessage());
        }

    }


}
