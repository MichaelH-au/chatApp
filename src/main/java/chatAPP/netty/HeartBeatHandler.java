package chatAPP.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @Description extend ChannelInboundHandlerAdapter
 * check channel handler
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // check if IdleStatEvent
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            if (event.state() == IdleState.READER_IDLE) {
                System.out.println("read idle");
            } else if (event.state() == IdleState.WRITER_IDLE) {
                System.out.println("write idle");
            } else if (event.state() == IdleState.ALL_IDLE) {
                Channel channel = ctx.channel();

                // close idle channel and release resources
                channel.close();
                ChatHandler.users.size();
            }
        }
    }
}
