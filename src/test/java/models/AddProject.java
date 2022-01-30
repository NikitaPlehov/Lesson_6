package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddProject {
    private String name;
    private String announcement;
    @SerializedName(value = "show_announcement")
    private boolean show_announcement;
    @SerializedName(value = "suite_mode")
    private int suite_mode;
}
