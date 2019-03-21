package chatAPP.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class WSServer {

    private static class SingletionWSServer {
        static final WSServer instance = new WSServer();
    }

    public static WSServer getInstance() {
        return SingletionWSServer.instance;
    }

    private EventLoopGroup masterGroup;
    private EventLoopGroup slaveGroup;
    private ChannelFuture channelFuture;
    private ServerBootstrap serverBootstrap;

    public WSServer() {
        masterGroup = new NioEventLoopGroup();
        slaveGroup = new NioEventLoopGroup();

        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(masterGroup, slaveGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WSServerInitialization());
    }

    public void start() {
        this.channelFuture = serverBootstrap.bind(8088);
        System.err.println("netty websocket server set up");
    }

}
