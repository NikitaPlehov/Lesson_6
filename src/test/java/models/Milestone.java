package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Milestone {
        private String name;
        private String description;
        private int limit;
        private int offset;



}
