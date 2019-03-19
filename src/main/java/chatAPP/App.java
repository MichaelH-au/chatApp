package chatAPP;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // master thread
        EventLoopGroup masterGroup = new NioEventLoopGroup();

        // slave thread
        EventLoopGroup slaveGroup = new NioEventLoopGroup();

        try {
            // initialization of server
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(masterGroup, slaveGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(null);

            // start server set port number
            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
            // listen channel close
            channelFuture.channel().closeFuture().sync();

        } finally {
            masterGroup.shutdownGracefully();
            slaveGroup.shutdownGracefully();
        }
    }
}
