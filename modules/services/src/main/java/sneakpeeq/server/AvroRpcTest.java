package sneakpeeq.server;

import org.apache.avro.AvroRemoteException;
import org.apache.avro.ipc.NettyServer;
import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.apache.avro.ipc.specific.SpecificResponder;
import sneakpeeq.common.ipc.Products;
import sneakpeeq.common.models.Product;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shychan
 * Date: 2/16/13
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class AvroRpcTest {
    // A mock implementation
    public static class ProductImpl implements Products {
        public List<Product> findAll() throws AvroRemoteException, AvroRemoteException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public Product findById(int id) throws AvroRemoteException {
            Product p = new Product();
            p.setName("Stan " + id);
            return p;  //To change body of implemented methods use File | Settings | File Templates.
        }

        public List<Product> findBySiteId(int siteId) throws AvroRemoteException {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    private static NettyServer server;

    public static void main(String[] args) throws IOException {
        server = new NettyServer(new SpecificResponder(
                Products.class,
                new ProductImpl()),
                new InetSocketAddress(7001));

        NettyTransceiver client = new NettyTransceiver(
                new InetSocketAddress(server.getPort()));

        Products proxy = SpecificRequestor.getClient(Products.class, client);

        System.out.println("Result: " + proxy.findById(1357).getName());

        client.close();
        server.close();
    }
}
