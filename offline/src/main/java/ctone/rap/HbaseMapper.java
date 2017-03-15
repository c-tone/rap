package ctone.rap;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.ipc.RpcControllerFactory;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by ouyi on 2017/2/28.
 */
public class HbaseMapper {

    private static final Logger logger = LoggerFactory.getLogger(HbaseMapper.class);

    private static Configuration config = HBaseConfiguration.create();

    private String configName;

    public void init() {
        config.addResource(configName);
    }

    //连接hbase
    private Admin connect() {
        try {
            Connection connection = ConnectionFactory.createConnection(config);
            Admin admin = connection.getAdmin();
            return admin;
        } catch (IOException e) {
            logger.error("connect error", e);
        }
        return null;
    }

    //关闭连接
    private void close(Admin admin) {
        if (admin != null) {
            try {
                admin.close();
            } catch (IOException e) {
                logger.error("close error", e);
            }
        }
    }

    /**
     * 建表
     *
     * @param namespace    命名空间
     * @param name         表名
     * @param columnFamily 列族
     */
    public void createTable(String namespace, String name, String[] columnFamily) throws IOException {
        if (StringUtils.isEmpty(namespace)) {
            namespace = NamespaceDescriptor.DEFAULT_NAMESPACE_NAME_STR;
        }
        TableName tableName = TableName.valueOf(namespace, name);
        HTableDescriptor descriptor = new HTableDescriptor(tableName);
        for (String cf : columnFamily) {
            HColumnDescriptor hcd = new HColumnDescriptor(cf);
            hcd.setKeepDeletedCells(KeepDeletedCells.TTL);//Deleted Cells are retained until the delete marker expires due to TTL
            descriptor.addFamily(hcd);
            descriptor.addFamily(hcd);
        }
        //半同步
        descriptor.setDurability(Durability.SYNC_WAL);
        Admin admin = connect();
        //创建命名空间
        admin.createNamespace(NamespaceDescriptor.create(namespace).build());
        //建表
        admin.createTable(descriptor);
        close(admin);
    }

    public void dropTable(String namespace, String name) {
        TableName tableName = TableName.valueOf(namespace, name);
        Admin admin = connect();
        try {
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        } catch (IOException e) {
            logger.error("dropTable error", e);
        }
    }

    public void putCF(String namespace, String name, String[] columnFamily) throws IOException {
        if (StringUtils.isEmpty(namespace)) {
            namespace = NamespaceDescriptor.DEFAULT_NAMESPACE_NAME_STR;
        }
        if (StringUtils.isEmpty(name)) {
            throw new IOException("name is empty");
        }
        if (ArrayUtils.isEmpty(columnFamily)) {
            throw new IOException("columnFamily is empty");
        }
        TableName tableName = TableName.valueOf(namespace, name);
        Admin admin = connect();
        if (admin.tableExists(tableName)) {
            admin.disableTable(tableName);
            HTableDescriptor descriptor = new HTableDescriptor(tableName);
            for (String cf : columnFamily) {
                if (StringUtils.isNotEmpty(cf)) {
                    HColumnDescriptor hcd = new HColumnDescriptor(cf);
                    hcd.setKeepDeletedCells(KeepDeletedCells.TTL);//Deleted Cells are retained until the delete marker expires due to TTL
                    descriptor.addFamily(hcd);
                }
            }
            admin.modifyTable(tableName, descriptor);
            admin.enableTable(tableName);
        }
        close(admin);
    }

    /**
     * 删除列族 会同时删除下挂的列，及单元
     */
    public void delCF(String namespace, String name, String[] columnFamily) throws IOException {
        if (StringUtils.isEmpty(namespace)) {
            namespace = NamespaceDescriptor.DEFAULT_NAMESPACE_NAME_STR;
        }
        if (StringUtils.isEmpty(name)) {
            throw new IOException("name is empty");
        }
        if (ArrayUtils.isEmpty(columnFamily)) {
            throw new IOException("columnFamily is empty");
        }
        TableName tableName = TableName.valueOf(namespace, name);
        Admin admin = connect();
        if (admin.tableExists(tableName)) {
            admin.disableTable(tableName);
            HTableDescriptor descriptor = new HTableDescriptor(tableName);
            for (String cf : columnFamily) {
                if (StringUtils.isNotEmpty(cf)) {
                    descriptor.removeFamily(Bytes.toBytes(cf));
                }
            }
            admin.modifyTable(tableName, descriptor);
            admin.enableTable(tableName);
        }
        close(admin);
    }

    /**
     * 如果rowKey cf c都一样，那么会更新value；否则新增
     */
    public void putRow(String namespace_name, String rowKey, String cf_c, String value) throws IOException {
        if (StringUtils.isEmpty(namespace_name)) {
            throw new IOException("namespace_name is empty");
        }
        if (StringUtils.isEmpty(rowKey)) {
            throw new IOException("rowKey is empty");
        }
        if (StringUtils.isEmpty(cf_c)) {
            throw new IOException("cf_c is empty");
        }
        Admin admin = connect();
        TableName tableName = TableName.valueOf(namespace_name);
        if (admin.tableExists(tableName)) {
            //构造halbe
            ClusterConnection clusterConnection = (ClusterConnection) admin.getConnection();//todo fix
            ConnectionConfiguration connectionConfiguration = clusterConnection.getConnectionConfiguration();
            RpcRetryingCallerFactory rpcRetryingCallerFactory = clusterConnection.getRpcRetryingCallerFactory();
            RpcControllerFactory rpcControllerFactory = clusterConnection.getRpcControllerFactory();
            HTable hTable = new HTable(tableName, clusterConnection, connectionConfiguration, rpcRetryingCallerFactory, rpcControllerFactory, null);
            //put
            String row = rowKey + "," + cf_c + "," + value;
            Cell cell;
            Put put = new Put(Bytes.toBytes(rowKey));
            //put.add();//todo
            hTable.put(put);
            hTable.close();
        }
        close(admin);
    }

    public void delRow(String namespace_name, String rowKey, String cf, String c, long timestamp) throws IOException {
        if (StringUtils.isEmpty(namespace_name)) {
            throw new IOException("namespace_name is empty");
        }
        if (StringUtils.isEmpty(rowKey)) {
            throw new IOException("rowKey is empty");
        }
        Admin admin = connect();
        TableName tableName = TableName.valueOf(namespace_name);
        if (admin.tableExists(tableName)) {
            //构造halbe
            ClusterConnection clusterConnection = (ClusterConnection) admin.getConnection();//todo fix
            ConnectionConfiguration connectionConfiguration = clusterConnection.getConnectionConfiguration();
            RpcRetryingCallerFactory rpcRetryingCallerFactory = clusterConnection.getRpcRetryingCallerFactory();
            RpcControllerFactory rpcControllerFactory = clusterConnection.getRpcControllerFactory();
            HTable hTable = new HTable(tableName, clusterConnection, connectionConfiguration, rpcRetryingCallerFactory, rpcControllerFactory, null);
            Delete delete = new Delete(Bytes.toBytes(rowKey));
            if (StringUtils.isNotEmpty(cf)) {
                //delete one cf
                if (timestamp > 0) {
                    delete.addFamily(Bytes.toBytes(cf), timestamp);
                } else {
                    delete.addFamily(Bytes.toBytes(cf));
                }

                if (StringUtils.isNotEmpty(c)) {
                    //delete columns of all version
                    if (timestamp > 0) {
                        delete.addColumns(Bytes.toBytes(cf), Bytes.toBytes(c), timestamp);
                    } else {
                        delete.addColumns(Bytes.toBytes(cf), Bytes.toBytes(c));
                    }
                }
            }
            hTable.delete(delete);
            hTable.close();
        }
        close(admin);
    }

    public void getRow() {
    }

    public void scan() {
    }
}
