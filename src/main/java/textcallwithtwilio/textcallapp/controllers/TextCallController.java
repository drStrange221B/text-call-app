package textcallwithtwilio.textcallapp.controllers;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import textcallwithtwilio.textcallapp.utilities.TextCallUtil;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class TextCallController {


    @Autowired
    private TextCallUtil textCallUtil;

    @RequestMapping("/greetings")
    public String greeting(@RequestParam(value="mode", required = false, defaultValue="text") String mode,
                           @RequestParam(value="number", required = true) String number, Model model)
    {
        model.addAttribute("number", number);
        model.addAttribute("mode",mode);

        if(mode.equalsIgnoreCase("text"))
        {
            textCallUtil.sendSMS(number);
        }

        log.info("control has come up to this");
        return "greeting";
    }

}
