package sneakpeeq.server.services;

import org.apache.avro.AvroRemoteException;
import org.gearman.Gearman;
import org.gearman.GearmanFunction;
import org.gearman.GearmanFunctionCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sneakpeeq.common.ipc.Products;
import sneakpeeq.common.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class GearmanWrapperService implements GearmanFunction {

    @Autowired
    Gearman gearman;

    @PostConstruct
    public void postConstruct() {
    }


    public byte[] work(String s, byte[] bytes, GearmanFunctionCallback gearmanFunctionCallback) throws Exception {
        System.out.println(s);
        return bytes;
    }
}
