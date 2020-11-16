package net.bossones.rest_api.responses;

public class ClientResponse {

    private Integer id;
    private String status;

    public ClientResponse(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
