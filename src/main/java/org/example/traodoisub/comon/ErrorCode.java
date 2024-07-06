package org.example.traodoisub.comon;

import org.example.traodoisub.exception.BaseErrorCode;
import org.springframework.http.HttpStatus;

/**
 * Cấu hình erorcode - error message - httpStatus code
 *
 * @author hieunt
 */
public enum ErrorCode implements BaseErrorCode {
    // auth
    USER_NOT_ACCEPT(1, "user.not.accept", HttpStatus.NOT_FOUND),
    REFRESH_TOKEN_REQUIRED(2, "refresh.token.required", HttpStatus.UNPROCESSABLE_ENTITY),
    REFRESH_TOKEN_NOT_EXIST(3, "refresh.token.not.exist", HttpStatus.UNPROCESSABLE_ENTITY),
    REFRESH_TOKEN_EXPIRED(4, "refresh.token.expired", HttpStatus.UNPROCESSABLE_ENTITY),
    GRANT_TYPE_NOT_SUPPORTED(5, "grant.type.not.supported", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_LOCKED(6, "user.locked", HttpStatus.UNPROCESSABLE_ENTITY),
    USER_NOT_FOUND(7, "username.not.found", HttpStatus.UNPROCESSABLE_ENTITY),
    TOKEN_INVALID(8, "token.invalid", HttpStatus.UNAUTHORIZED),
    TOKEN_EXPIRED(9, "token.expired", HttpStatus.UNAUTHORIZED),
    ACCESS_DENIED(10, "access.denied", HttpStatus.FORBIDDEN),
    USER_PASS_INVALID(11, "user.pass.invalid", HttpStatus.BAD_REQUEST),
    MAIL_TEMPLATE_NOT_FOUND(12, "mail.template.not.found", HttpStatus.NOT_FOUND),
    SERVER_ERROR(13, "server.error", HttpStatus.UNPROCESSABLE_ENTITY),
    WRONG_PASSWORD(1011, "wrong.password", HttpStatus.UNAUTHORIZED),
    CHECK_AUTHEN(14, "check.authen", HttpStatus.UNAUTHORIZED),
    CHECK_STATUS(19, "Phương án kiểm kê đã hoàn thành", HttpStatus.BAD_REQUEST),
    CHECK_PHUONG_AN(19, "Không tồn tại phương án nào", HttpStatus.BAD_REQUEST),
    CHECK_USER(20, "User không có quyền thực hiện ở đây", HttpStatus.BAD_REQUEST),
    IT02_ERROR(4005, "Mã bì kho không tồn tại trong chi nhánh", HttpStatus.BAD_REQUEST),
    NOT_FOUND_DECISION(21, "Không tìm thấy phương án", HttpStatus.BAD_REQUEST),
    VALIDATE_FAIL(22, "validate fail", HttpStatus.BAD_REQUEST),

    PROCESS_NOT_EXISTED(1005, "process.not.exist", HttpStatus.NOT_FOUND),
    NO_RIGHTS_EXECUTE(1006, "no.rights.execute", HttpStatus.METHOD_NOT_ALLOWED),
    HTTP_STATUS_CODE_EXCEPTION(1007, "", HttpStatus.BAD_REQUEST),
    UNPROCESSABLE_ENTITY(1008, "", HttpStatus.UNPROCESSABLE_ENTITY),
    PROCESS_VALIDATE_BCDG(1009, "", HttpStatus.NOT_FOUND);


    private final int code;

    private final String message;

    private final HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}