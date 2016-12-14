package com.lcl.hw.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rain on 2016/12/13 19:47.
 */
@Component
public class RedisClusterServersInfo {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String TIMEOUT_DEFAULT_VALUE = "2000";
    private String serversInfoString;
    private Set<HostAndPort> serverInfoSet = new HashSet();

    public RedisClusterServersInfo() {
    }

    public void setServersInfoString(String serversInfoString) {
        this.serversInfoString = serversInfoString;
    }

    @PostConstruct
    public void genServersSet() {
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
                this.serverInfoSet.add(hostAndPort);
            }
        }

    }

    public Set<HostAndPort> getServerInfoSet() {
        return this.serverInfoSet;
    }

    public void setServerInfoSet(Set<HostAndPort> serverInfoSet) {
        this.serverInfoSet = serverInfoSet;
    }

    public String getServersInfoString() {
        return this.serversInfoString;
    }
}

