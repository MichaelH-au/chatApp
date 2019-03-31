package chatAPP.netty;

import chatAPP.Services.UserService;
import chatAPP.enums.MsgActionEnum;
import chatAPP.utils.JsonUtils;
import chatAPP.utils.SpringUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;


public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // manage and record users channel
    public static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
//        String content = textWebSocketFrame.text();
//        System.out.println("receive data: " + content);

//        for (Channel channel: users) {
//            channel.writeAndFlush(new TextWebSocketFrame("[server received]" + LocalDateTime.now() + ", content:" + content));
//        }
//         same with the for loop
//        users.writeAndFlush(new TextWebSocketFrame("[server received]" + LocalDateTime.now() + ", content:" + content));

        // 1.get message from client
        String content = textWebSocketFrame.text();

        Channel currentChannel = channelHandlerContext.channel();

        DataContent dataContent = JsonUtils.jsonToPojo(content, DataContent.class);
        Integer action = dataContent.getAction();

        // 2. check the type of message
        if (action == MsgActionEnum.CONNECT.type) {
            // 2.1 initialization channel and link channel with userId
            String senderId = dataContent.getChatMsg().getSenderId();
            UserChannelRel.put(senderId, currentChannel);

        } else if (action == MsgActionEnum.CHAT.type) {
            // 2.2 normal chat message, save message to DB and set status of message
            ChatMsg chatMsg = dataContent.getChatMsg();
            String senderId = chatMsg.getSenderId();
            String receiverId = chatMsg.getReceiverId();
            String msg = chatMsg.getMsg();

            // default name of bean
            UserService userService = (UserService) SpringUtil.getBean("userServiceImpl");
            String msgId = userService.saveMsg(chatMsg);
            chatMsg.setMsgId(msgId);

            // forward message
            Channel receiverChannel = UserChannelRel.get(receiverId);
            if (receiverChannel == null) {
                // TODO channel is empty, use third part push notification

            } else {
                Channel findeChannel = users.find(receiverChannel.id());
                if (findeChannel != null) {
                    receiverChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(chatMsg)));
                } else {
                    // user offline push notification
                }
            }


        } else if (action == MsgActionEnum.SIGNED.type) {
            // 2.3 change message status

        } else if (action == MsgActionEnum.KEEPALIVE.type) {
            // 2.4 heart type

        }

    }

    /**
     * After connect, get channel from client and add to channelGroup
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        super.handlerAdded(ctx);
        users.add(ctx.channel());
    }

    /**
     * remove corresponding channel from channelGroup
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        super.handlerRemoved(ctx);
//        users.remove(ctx.channel());
        users.remove(ctx.channel());
        System.out.println("client disconnect long id:" + ctx.channel().id().asLongText());
        System.out.println("client disconnect short id:" + ctx.channel().id().asShortText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // print error
        cause.printStackTrace();

        // close channel and remove from group
        ctx.channel().close();
        users.remove(ctx.channel());

    }
}
