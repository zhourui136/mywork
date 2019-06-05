package com.work.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;


/**
 * @author zhourui
 */
@Configuration
public class ElasticSearchConfig {

    @Value("${elasticsearch.clustername}")
    private String clustername;

    @Value("${elasticsearch.node1.name}")
    private String node1Name;

    @Value("${elasticsearch.node1.address}")
    private String node1TransportAddress;

    @Value("${elasticsearch.node1.port}")
    private Integer node1TransportAddressPort;

    @Value("${elasticsearch.node2.name}")
    private String node2Name;

    @Value("${elasticsearch.node2.address}")
    private String node2TransportAddress;

    @Value("${elasticsearch.node2.port}")
    private Integer node2TransportAddressPort;

    @Value("${elasticsearch.node3.name}")
    public String node3Name;

    @Value("${elasticsearch.node3.address}")
    private String node3TransportAddress;
    @Value("${elasticsearch.node3.port}")
    private Integer node3TransportAddressPort;

    @Bean(name = "client")
    public Client client() {
        Settings settings = Settings.builder()
                .put("cluster.name", clustername)
                .put("client.transport.sniff", true)
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);
        try {
            client.addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(node1TransportAddress), node1TransportAddressPort))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(node2TransportAddress), node2TransportAddressPort))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(node3TransportAddress), node3TransportAddressPort));

        } catch (Exception e) {
            System.err.println("初始化失败:"+e);
        }
        return client;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client) {
        return new ElasticsearchTemplate(client);
    }


}
