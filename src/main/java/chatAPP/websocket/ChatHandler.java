package chatAPP.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;


public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // manage and record clients channel
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        String content = textWebSocketFrame.text();
        System.out.println("data: " + content);

        for (Channel channel: clients) {
            channel.writeAndFlush(new TextWebSocketFrame("[server received]" + LocalDateTime.now() + ", content:" + content));
        }
        // same with the for loop
//        clients.writeAndFlush(new TextWebSocketFrame("same"));
    }

    /**
     * After connect, get channel from client and add to channelGroup
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        super.handlerAdded(ctx);
        clients.add(ctx.channel());
    }

    /**
     * remove corresponding channel from channelGroup
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        super.handlerRemoved(ctx);
//        clients.remove(ctx.channel());
        System.out.println("client disconnect long id:" + ctx.channel().id().asLongText());
        System.out.println("client disconnect short id:" + ctx.channel().id().asShortText());
    }
}
