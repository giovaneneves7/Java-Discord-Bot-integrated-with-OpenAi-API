package com.github.nekoyasha7.botgpt;

//--+ Imports +--//
import com.github.nekoyasha7.botgpt.slashcommands.Cai;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import java.util.EnumSet;

//--+ End Imports +--//
/**
 *
 * @author NekoYasha7
 */
public class Main {

    public static JDA jda;
    
    public static void main(String[] args) {
        
        //--+ Build the Bot +--//
        jda = JDABuilder.createDefault("YOUR_TOKEN_HERE")
                        .enableIntents((EnumSet.allOf(GatewayIntent.class)))
                        .build();
        
        //--+ Set Bot Presence +--//
       jda.getPresence().setPresence(
                                     OnlineStatus.ONLINE, Activity.of(Activity.ActivityType.WATCHING, ("Use '/cai'"))
                                    );
       
       //--+ Add Slash Command +--//
       jda.upsertCommand("cai", "chat with ai")
                        .addOption(OptionType.STRING, "prompt", "Enter a prompt to be answered by the AI", true)
                        .queue();
       
       //--+ Slash Commands Instance +--//
       jda.addEventListener(new Cai());
    }
}
