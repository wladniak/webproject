package pl.wla.webproject.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataErrorResponse {
    private int status;
    private String msg;
    private long timeStamp;

    public DataErrorResponse(int status, String msg, long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }
}
