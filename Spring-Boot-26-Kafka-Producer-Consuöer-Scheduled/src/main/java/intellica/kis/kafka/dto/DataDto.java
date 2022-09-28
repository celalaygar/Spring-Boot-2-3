package intellica.kis.kafka.dto;

public class DataDto {

    private Integer id;

    private String dataName;


    public DataDto(Integer id, String dataName) {
        this.id = id;
        this.dataName = dataName;
    }

    public DataDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
}
