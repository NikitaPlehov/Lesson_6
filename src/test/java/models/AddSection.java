package models;

import baseEntities.BaseApiTest;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddSection{
    private String name;
    private String description;

}
