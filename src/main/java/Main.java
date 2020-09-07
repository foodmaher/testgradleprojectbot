import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

import java.util.ArrayList;

public final class Main {
    public static void main(final String[] args) {
        ArrayList<Object> strings = new ArrayList<Object>(2);
        ArrayList<String> n = new ArrayList<String>();
        n.add("Hi");
        n.add("23554");
        strings.add(0, "Maher");
        strings.add(1, "Baghdad");
        strings.add(2, "20");
        strings.add(3, n);
        JSON_database.wirteDataAndCreateJSON(strings);
    }

    private static void initDiscordConnected(){
        final String token = "NzUxODQzNDM1MTQ0NTQ0MzI2.X1O-ww.YrJdRLf62_f0RDGhPeTUttBNkKo";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("!ping".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block();
            }
        });

        gateway.onDisconnect().block();
    }
}
