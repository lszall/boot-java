package com.jx.platform.common.request;
import lombok.Data;
import lombok.Getter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * request.getInputStream() 只能读取一次
 */
@Getter
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private byte[] body;

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        try {
            body = getByteByStream(request.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }
    public static byte[] getByteByStream (InputStream is) throws Exception {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);

        }
        bos.flush();
        return bos.toByteArray();
    }
}
