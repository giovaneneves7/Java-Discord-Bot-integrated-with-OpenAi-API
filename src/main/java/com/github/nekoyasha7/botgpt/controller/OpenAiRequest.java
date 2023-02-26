package com.github.nekoyasha7.botgpt.controller;

//--+ Imports +--//

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;


//--+ End Imports +--//
/**
 *
 * @author NekoYasha7
 */
public class OpenAiRequest {
    
    final private static String API_KEY = "YOUR_API_KEY_HERE";
    
    public static String request(String prompt){
        
        //--+ Instantiates the class  OpenAiService +--//
        OpenAiService service = new OpenAiService(API_KEY);
        
        //--+ Makes a request to the API +--//
        CompletionRequest request = CompletionRequest.builder()
                                                     .model("text-davinci-003")   
                                                     .prompt(prompt)
                                                     .maxTokens(700)
                                                     .build();
        
        
        //--+ returns the response from the API +--//
        String response = service.createCompletion(request).getChoices().get(0).getText();
        return response;
        
        
    }
    
}
