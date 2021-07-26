package com.jx.platform.common.constant;

public class BusinessConstant {

    public enum ROLE_TYPE{
        CUSTOM("C","自定义"),
        SYSTEM("S","系统");
        private String code;
        private String msg;
         ROLE_TYPE(String code,String msg){
             this.code = code;
             this.msg = msg;
        }

        public String code() {
            return this.code;
        }

        public  String msg() {
            return this.msg;
        }
    }

}
