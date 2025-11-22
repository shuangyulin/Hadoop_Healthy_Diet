package com.handler;

import com.utils.R;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 *
 * @author abo
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求方式不支持
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        e.printStackTrace();
        return R.error(String.format("请求地址%s,不支持%s请求", requestURI, e.getMethod()));
    }

    /**
     * 参数验证失败异常
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        e.printStackTrace();
        return R.error(String.format("请求地址%s,参数验证失败%s", requestURI, message, e));
    }

    /**
     * 拦截错误SQL异常
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(BadSqlGrammarException.class)
    public R handleBadSqlGrammarException(BadSqlGrammarException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        e.printStackTrace();
        return R.error(String.format("请求地址%s,发生数据库异常%s", requestURI, e)).put("remark", "请检查字段是否正确！");
    }

    /**
     * 可以拦截表示违反数据库的完整性约束导致的异常。
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public R handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        e.printStackTrace();
        return R.error(String.format("请求地址%s,发生数据库异常%s", requestURI, e));
    }


    /**
     * 可以拦截违反数据库的非完整性约束导致的异常，可能也会拦截一些也包括 SQL 语句错误、连接问题、权限问题等各种数据库异常。
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(UncategorizedSQLException.class)
    public R handleUncategorizedSqlException(UncategorizedSQLException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        e.printStackTrace();
        return R.error(String.format("请求地址%s,发生数据库异常%s", requestURI, e)).put("remark", "请检查跨表操作是否正确！");
    }

    /**
     * 拦截未知的运行时异常
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public R handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        e.printStackTrace();
        return R.error(String.format("请求地址%s,发生未知运行异常%s", requestURI, e));
    }

    /**
     * 全局异常
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        e.printStackTrace();
        return R.error(String.format("请求地址%s,发生系统异常%s", requestURI, e));
    }
}
