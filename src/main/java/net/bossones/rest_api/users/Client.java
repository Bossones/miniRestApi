package net.bossones.rest_api.users;

public class Client {

    private Integer id;
    private String name;
    private String position;
    private String number;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getNumber() {
        return number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
