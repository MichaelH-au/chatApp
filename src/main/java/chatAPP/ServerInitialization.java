package chatAPP;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * initialization tools
 */
public class ServerInitialization extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // get pipline
        ChannelPipeline channelPipeline = socketChannel.pipeline();

        // add handler
        channelPipeline.addLast("HttpServerCodec", new HttpServerCodec());

        channelPipeline.addLast("customHandler", new CustomHandler());
    }
}
