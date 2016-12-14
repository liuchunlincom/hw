package com.lcl.hw.framework.serializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by Rain on 2016/12/13 20:02.
 */
@Component
public class JdkRedisSerializer implements RedisSerializer<Object> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final byte[] EMPTY_ARRAY = new byte[0];

    public JdkRedisSerializer() {
    }

    public byte[] serialize(Object object) {
        if(object == null) {
            return EMPTY_ARRAY;
        } else if(object instanceof byte[]) {
            return (byte[])((byte[])object);
        } else {
            ObjectOutputStream oos = null;
            ByteArrayOutputStream baos = null;

            byte[] var5;
            try {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                oos.flush();
                byte[] e = baos.toByteArray();
                var5 = e;
            } catch (Exception var17) {
                this.logger.error(var17.getMessage() + var17.getCause());
                throw new RuntimeException("Could not serialize " + var17.getMessage(), var17);
            } finally {
                if(oos != null) {
                    try {
                        oos.close();
                    } catch (IOException var16) {
                        throw new RuntimeException("Could not close ObjectOutputStream object", var16);
                    }
                }

                if(baos != null) {
                    try {
                        baos.close();
                    } catch (IOException var15) {
                        throw new RuntimeException("Could not close ByteArrayOutputStream object", var15);
                    }
                }

            }

            return var5;
        }
    }

    public Object deserialize(byte[] bytes) {
        if(this.isEmpty(bytes)) {
            return null;
        } else {
            ByteArrayInputStream bais = null;
            ObjectInputStream is = null;

            Object e;
            try {
                bais = new ByteArrayInputStream(bytes);
                is = new ObjectInputStream(bais);
                e = is.readObject();
            } catch (Exception var16) {
                this.logger.error("unserialize error", var16);
                throw new RuntimeException("Could not unserialize " + var16.getMessage(), var16);
            } finally {
                if(is != null) {
                    try {
                        is.close();
                    } catch (IOException var15) {
                        throw new RuntimeException("Could not close ObjectInputStream object", var15);
                    }
                }

                if(bais != null) {
                    try {
                        bais.close();
                    } catch (IOException var14) {
                        throw new RuntimeException("Could not close ByteArrayInputStream object", var14);
                    }
                }

            }

            return e;
        }
    }

    public boolean isEmpty(byte[] data) {
        return data == null || data.length == 0;
    }
}

