package kz.kazimpex.parserxml.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "documentolog")
public class Documentolog {

    @Id
    private long id;

    @Indexed(unique = true)
    private String name;

}
