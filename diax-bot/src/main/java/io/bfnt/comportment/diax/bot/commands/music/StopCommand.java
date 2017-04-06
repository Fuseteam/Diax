package io.bfnt.comportment.diax.bot.commands.music;

import io.bfnt.comportment.diax.bot.lib.audio.DiaxGuildMusicManager;
import io.bfnt.comportment.diax.bot.lib.command.DiaxCommand;
import io.bfnt.comportment.diax.bot.lib.command.DiaxCommandDescription;
import io.bfnt.comportment.diax.bot.lib.util.DiaxUtil;
import net.dv8tion.jda.core.entities.Message;

/**
 * Created by NachtRaben on 4/5/2017.
 */

@DiaxCommandDescription(triggers = {"stop"}, guildOnly = true)
public class StopCommand extends DiaxCommand {

    @Override
    public void execute(Message trigger, String truncated) {
        DiaxGuildMusicManager manager = DiaxGuildMusicManager.getManagerFor(trigger.getGuild());
        manager.scheduler.stop();
        trigger.getChannel().sendMessage(DiaxUtil.musicEmbed("Playback has been stopped.")).queue();
    }
}