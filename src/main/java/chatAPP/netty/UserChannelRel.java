package chatAPP.netty;

import io.netty.channel.Channel;

import java.util.HashMap;

/**
 * UserId and chanel relationship
 */
public class UserChannelRel {

    private static HashMap<String, Channel> manager = new HashMap<String, Channel>();

    public static void put(String senderId, Channel channel) {
        manager.put(senderId, channel);
    }

    public static Channel get(String senderId) {
        return manager.get(senderId);
    }
}
