package com.lcl.hw.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisShardInfo;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rain on 2016/12/13 19:48.
 */
@Component
public class RedisServersInfo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String TIMEOUT_DEFAULT_VALUE = "2000";
    private String password;
    private String weight;
    private String timeout;
    private List<JedisShardInfo> shardInfoList = new ArrayList();
    private String serversInfoString;
    private Set<HostAndPort> clusterServersSet = new HashSet();

    public RedisServersInfo() {
    }

    @PostConstruct
    public void genShardedList() {
        String[] shardInfoArray = StringUtils.commaDelimitedListToStringArray(this.serversInfoString);
        String[] var6 = shardInfoArray;
        int var7 = shardInfoArray.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String shardInfoStr = var6[var8];
            String[] hostElems = StringUtils.delimitedListToStringArray(shardInfoStr, ":");
            if(hostElems.length != 2 && hostElems.length != 3) {
                throw new IllegalArgumentException("At least,the ip address,port for the shared is required.");
            }

            String ipAddr = hostElems[0];
            String port = hostElems[1];
            if(ipAddr != null && !"".equals(ipAddr) && port != null && !"".equals(port)) {
                String weightStr;
                if(hostElems.length == 3 && !"".equals(hostElems[2])) {
                    weightStr = hostElems[2];
                } else {
                    weightStr = this.weight;
                }

                if(this.timeout == null || "".equals(this.timeout)) {
                    this.timeout = "2000";
                }

                JedisShardInfo jedisShardInfo = new JedisShardInfo(ipAddr, ipAddr + port, Integer.parseInt(port), Integer.parseInt(this.timeout), Integer.parseInt(weightStr));
                if(this.password != null && !"".equals(this.password)) {
                    jedisShardInfo.setPassword(this.password);
                }

                this.shardInfoList.add(jedisShardInfo);
            }
        }

    }

    public List<JedisShardInfo> getShardInfoList() {
        return this.shardInfoList;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShardInfoList(List<JedisShardInfo> shardInfoList) {
        this.shardInfoList = shardInfoList;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @PostConstruct
    public void genClusterServersSet() {
        String[] serversInfoArray = StringUtils.commaDelimitedListToStringArray(this.serversInfoString);
        String[] var5 = serversInfoArray;
        int var6 = serversInfoArray.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String serversInfoStr = var5[var7];
            String[] hostElems = StringUtils.delimitedListToStringArray(serversInfoStr, ":");
            if(hostElems.length != 2 && hostElems.length != 3) {
                throw new IllegalArgumentException("At least,the ip address,port for the Cluster is required.");
            }

            String ipAddr = hostElems[0];
            int port;
            if(hostElems[1] != null) {
                port = Integer.parseInt(hostElems[1]);
            } else {
                port = -1;
            }

            if(ipAddr != null && !"".equals(ipAddr) && port != -1 && !"".equals(Integer.valueOf(port))) {
                HostAndPort hostAndPort = new HostAndPort(ipAddr, port);
                this.clusterServersSet.add(hostAndPort);
            }
        }

    }

    public Set<HostAndPort> getClusterServersSet() {
        return this.clusterServersSet;
    }

    public void setClusterServersSet(Set<HostAndPort> clusterServersSet) {
        this.clusterServersSet = clusterServersSet;
    }

    public void setServersInfoString(String serversInfoString) {
        this.serversInfoString = serversInfoString;
    }

    public String getServersInfoString() {
        return this.serversInfoString;
    }
}

