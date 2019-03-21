package chatAPP.response;

public class CommonReturnTrye {

    private String status;
    private Object data;

    public static CommonReturnTrye create(Object result) {
        return CommonReturnTrye.create(result, "success");
    }


    public static CommonReturnTrye create(Object result, String status) {
        CommonReturnTrye response = new CommonReturnTrye();
        response.setData(result);
        response.setStatus(status);
        return response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
