package com.work.utils;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.net.InetAddress;

/**
 * @author zhourui
 */
public class ESUtils {
//    private static Client getClient()throws Exception{
//       return TransportClient.builder().build().addTransportAddress(new InetSocketTransportAddress
//             (InetAddress.getByName("192.168.209.121"), 9300));
//    }
    public static void createIndexFile() throws Exception{
        XContentBuilder mapping  = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("settings")
                .field("number_of_shards", 1)
                .field("number_of_replicas", 0)
                .endObject()
                .endObject()
                .startObject()
                .startObject("type_name")
                .startObject("properties")
                .startObject("type").field("type", "string").field("store", "yes").endObject()
                .startObject("eventCount").field("type", "long").field("store", "yes").endObject()
                .startObject("eventDate").field("type","date").field("format", "dateOptionalTime").field("store", "yes").endObject()
                .startObject("message").field("type","string").field("index", "not_analyzed").field("store", "yes").endObject()
                .endObject()
                .endObject()
                .endObject();

//        CreateIndexRequestBuilder builder = getClient().admin().indices().prepareCreate("index_name").setSource(mapping);
//
//       CreateIndexResponse response = builder.execute().actionGet();
//        if(response.isAcknowledged()){
//            System.out.println("创建索引文档成功！");
//        }else{
//            System.out.println("创建索引文档失败！");
//        }
    }
}
