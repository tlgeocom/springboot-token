package com.geesun.common;

/**
 * @author ：Mr.ZJW
 * @date ：Created 2022/2/28 10:26
 * @description：返回统一结果集
 */
public class Result<T> {

    private String message;
    private int retCode;
    private T data;

    private Result(T data) {
        this.retCode = 200;
        this.message = "成功";
        this.data = data;
    }

    private Result(CodeMsg cm) {
        if(cm == null){
            return;
        }
        this.retCode = cm.getRetCode();
        this.message = cm.getMessage();
    }

    /**
     * 成功时候的调用
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 成功，不需要传入参数
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Result<T> success(){
        return (Result<T>) success("");
    }
    /**
     * 失败时候的调用
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm){
        return new Result<T>(cm);
    }
    /**
     * 失败时候的调用,扩展消息参数
     * @param cm
     * @param msg
     * @return
     */
    public static <T> Result<T> error(CodeMsg cm,String msg){
        cm.setMessage(cm.getMessage()+"--"+msg);
        return new Result<T>(cm);
    }
    public T getData() {
        return data;
    }
    public String getMessage() {
        return message;
    }
    public int getRetCode() {
        return retCode;
    }
}
