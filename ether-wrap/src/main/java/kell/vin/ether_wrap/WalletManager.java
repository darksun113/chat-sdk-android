package kell.vin.ether_wrap;

import android.util.Log;

import org.ethereum.geth.Geth;
import org.ethereum.geth.Node;
import org.ethereum.geth.NodeConfig;

public class WalletManager {
    private static final WalletManager ourInstance = null;
    private String work_dir = null;
    private Node node = null;

    public static WalletManager getInstance(String work_dir) {
        if(ourInstance == null) {
            ourInstance = new WalletManager(work_dir);
        }
        return ourInstance;
    }

    private WalletManager(String work_dir) {
        this.work_dir = work_dir;
        initNode();
    }

    private void initNode() {
        if(node==null) {
            try {
                node = Geth.newNode(work_dir + "/.ethereum", new NodeConfig());
                node.start();
            } catch (Exception e) {
                Log.e("Kelvin",e.getMessage());
            }

        }
    }

    public String getName(String work_dir) {

    }

    public void stopNode() throws Exception{
        if(node!=null) {
            node.stop();
        }
    }
}
