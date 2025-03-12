package dto;

public class PetDto {
    private Integer id;
    private String name;
    private String status;

    public PetDto(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public PetDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("\n{" +
                "\n    id = %d,\n    name = '%s',\n    status = '%s'\n}", id, name, status);
    }

}
