package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cases {
    private String name;
    private int section_id;
    private String title;

}
