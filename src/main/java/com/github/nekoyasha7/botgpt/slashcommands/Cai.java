package com.github.nekoyasha7.botgpt.slashcommands;

//--+ Imports +--//

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import com.github.nekoyasha7.botgpt.controller.OpenAiRequest;

//--+ End Imports +--//
/**
 *
 * @author NekoYasha7
 */
public class Cai extends ListenerAdapter{
    
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        
        //--+ Verify if user is a Bot +--//
        if(event.getUser().isBot()) return;
        
        //--+ Verify if SlashCommand anme is equals 'cai' +--//
        if(event.getName().equals("cai")){
            
            //--+ Sends an Ephemeral message to whoever used the command +--//
            event.reply("Command used successfully")
                        .setEphemeral(true)
                        .queue();
            
            //--+ Sends the Bot response int the Channel 
            event.getChannel().sendMessage(event.getUser().getAsMention()                                         + 
                                           ", "                                                                   + 
                                           OpenAiRequest.request(event.getOption("prompt").getAsString()))
                              .queue();
        }
        
    }
   
}
