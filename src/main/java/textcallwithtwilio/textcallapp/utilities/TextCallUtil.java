package textcallwithtwilio.textcallapp.utilities;


import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
//@PropertySource("classpath:application.properties")
@Slf4j
public class TextCallUtil {

    @Value("${ACCOUNT_SID}")
    public  String ACCOUNT_SID ;

    @Value("${AUTH_TOKEN}")
    public  String AUTH_TOKEN ;

    @Value("${TWILIO_NUMBER}")
    public  String TWILIO_NUMBER ;



    public void sendSMS(String number){

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
